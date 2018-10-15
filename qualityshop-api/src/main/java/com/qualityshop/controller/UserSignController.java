package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserDetailPointEntity;
import com.qualityshop.entity.UserPointEntity;
import com.qualityshop.entity.UserShopmemberEntity;
import com.qualityshop.entity.UserSignEntity;
import com.qualityshop.form.UserSignForm;
import com.qualityshop.service.UserDetailPointService;
import com.qualityshop.service.UserPointService;
import com.qualityshop.service.UserShopmemberService;
import com.qualityshop.service.UserSignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 签到接口
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="签到接口")
public class UserSignController {

    @Autowired
    private UserSignService userSignService;
    @Autowired
    private UserShopmemberService userShopmemberService;

    @Autowired
    private UserPointService userPointService;

    @Autowired
    private UserDetailPointService userDetailPointService;

    @GetMapping("sign")
    @ApiOperation("签到查询")
    @ResponseBody
    public JSONObject sign(String userId){
        List<UserSignEntity> listUser=userSignService.queryBySign(userId);
        List<UserSignEntity> list= new ArrayList<>();
        JSONObject json =new JSONObject();
        if(listUser.size()>0){
            for(UserSignEntity user:listUser){
                String[] aa=user.getArrays_time().split(" ");
                user.setWeek(aa);
                list.add(user);
                json.put("code", 200);
                json.put("msg", "success");
            }

        }else{
            json.put("code", 200);
            json.put("msg", "当前信息不存在！");
        }
        json.put("list",list);

        return json;
    }

    @GetMapping("signDate")
    @ApiOperation("查询当天用户是否签到")
    @ResponseBody
    public JSONObject signDate(String userId,String  sign_date){
        //查询当天是否签到
        int count=userSignService.querySignDate(userId,sign_date);
        JSONObject json =new JSONObject();
        if(count>=1){
            json.put("code", 200);
            json.put("msg", "success");
            json.put("list",count);
        }
        return json;
    }


    @PostMapping("signInsert")
    @ApiOperation("签到添加")
    @ResponseBody
    public JSONObject signInsert(UserSignForm userSignForm){
        UserSignEntity userSignEntity =new UserSignEntity();
        //表单校验
        ValidatorUtils.validateEntity(userSignForm);
        BeanUtils.copyProperties(userSignForm,userSignEntity);
        JSONObject json =new JSONObject();
        //判断用户是否登录
        UserShopmemberEntity userShopmemberEntity=  userShopmemberService.queryByShopmember(userSignForm.getUserId());
        if(userShopmemberEntity==null){
            //用户没有登录 提示登录,
            json.put("code", 200);
            json.put("msg", "当前您还没有登录，请先登录！");
            return json;
        }else{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            if(userSignForm.getSign_time()==null){
                Date date=df.parse(df.format(new Date()), pos);
                userSignEntity.setSign_time(date);// new Date()为获取当前系统时间
                String userid= UUID.randomUUID().toString().replaceAll("-", "");
                userSignEntity.setSign_id(userid);
                //转换星期存储起来;
                userSignEntity.setArrays_time(dateToWeek(dfs.format(new Date())));
            }else{
                try {
                    Date date=dfs.parse(userSignForm.getSign_time());
                    userSignEntity.setSign_time(date);
                    userSignEntity.setArrays_time(dateToWeek(dfs.format(date)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            userSignEntity.setSign_state("1");//表默认未签到
            userSignEntity.setSign_poins("3");
            //查询当天用户是否签到
            int count=userSignService.querySignDate(userSignEntity.getUserId(),dfs.format(userSignEntity.getSign_time()));
            if(count>=1){
                json.put("code", 400);
                json.put("msg", "今天已经签到了！");
                return json;
            }else{
                //新增积分 -
                UserPointEntity userPoint=userPointService.pointGet(userSignForm.getUserId());
                UserDetailPointEntity  userDetailPointEntity=userDetailPointService.detailPointGet(userSignForm.getUserId());
                if(userDetailPointEntity!=null){
                    int point=Integer.parseInt(userDetailPointEntity.getPoints())+3;
                    userDetailPointEntity.setPoints(String.valueOf(point));
                    //同步到积分明细表中
                    userDetailPointService.detailPointUpdate(userDetailPointEntity);
                    json.put("totalPoints", userDetailPointEntity.getPoints());
                }
                if(userPoint!=null){
                    int point=Integer.parseInt(userPoint.getPoints())+3;
                    userPoint.setPoints(String.valueOf(point));
                    userPointService.pointUpdate(userPoint);
                }

                userSignService.insertBySign(userSignEntity);
                json.put("code", 200);
                json.put("msg", "success");
                return json;
            }

        }

    }

    @PostMapping("signtupdate")
    @ApiOperation("签到修改")
    public R signtupdate(UserSignForm userSignForm){
        UserSignEntity userSignEntity =new UserSignEntity();
        //表单校验
        ValidatorUtils.validateEntity(userSignForm);
        BeanUtils.copyProperties(userSignForm,userSignEntity);
        userSignService.signUpdate(userSignEntity);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "签到修改成功");
        return R.ok();
    }
    @PostMapping("signdelete")
    @ApiOperation("签到删除")
    public R signdelete(String userId){
        userSignService.signdelete(userId);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "签到删除成功");
        return R.ok();
    }

    @PostMapping("Supplement")
    @ApiOperation("一签补签")
    @ResponseBody
    public JSONObject Supplement(String userId) {
        JSONObject json =new JSONObject();
        UserSignEntity userSignEntity = new UserSignEntity();
        long nd = 1000 * 24 * 60 * 60;
        long day=0;
        // 查询当前用户总签到天数，如果没有补签的天，直接返回
        List<UserSignEntity> UserSiglist=userSignService.queryBySign(userId);
        if(UserSiglist.size()>0){
            long weekcount=0;
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String weeks=dateToWeek(dfs.format(new Date()));
            switch(weeks){
                case "星期一" :
                    weekcount=1;
                    break;
                case "星期二" :
                    weekcount=2;
                    break;
                case "星期三" :
                    weekcount=3;
                    break;
                case "星期四" :
                    weekcount=4;
                    break;
                case "星期五" :
                    weekcount=5;
                    break;
                case "星期六" :
                    weekcount=6;
                    break;
                case "星期天" :
                    weekcount=7;
                    break;
            }
            //查询的记录数等于当天的天数
           if(UserSiglist.size()==weekcount){
               json.put("code", 200);
               json.put("msg", "没有可补签得天数！");
               return json;
           }
        }

        //1.查询当前第一天签到的信息
        UserSignEntity userSignEntitys=userSignService.firstSignDate(userId);
        SimpleDateFormat dfk = new SimpleDateFormat("yyyy-MM-dd");
        //没有签到的信息   可以是（一键补签）周一，可能里面没有一条记录
        if(userSignEntitys==null){
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String weeks=dateToWeek(dfs.format(new Date()));
            switch(weeks){
                case "星期一" :
                    day=1;
                    break;
                case "星期二" :
                    day=2;
                    break;
                case "星期三" :
                    day=3;
                    break;
                case "星期四" :
                    day=4;
                    break;
                case "星期五" :
                    day=5;
                    break;
                case "星期六" :
                    day=6;
                    break;
                case "星期天" :
                    day=7;
                    break;
            }
            //判断今天是否签到
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date  date=null;
            //2.周一一键补签的时候
            if (day==1){
                userSignEntity.setUserId(userId);
                ParsePosition pos = new ParsePosition(0);
                userSignEntity.setSign_time(df.parse(df.format(new Date()), pos));
                getUserSignEntity(userSignEntity);

                json.put("code", 200);
                json.put("msg", "补签成功");
                return json;
            }
            for(int i=1;i<day;i++){
                //从第一天开始加1天
                Calendar calendar= new GregorianCalendar();
                    calendar.setTime(new Date());
                    calendar.add(calendar.DATE,-i);
                    //这个时间就是日期往后推一天的结果
                    date=calendar.getTime();
                int counts= userSignService.querySignDate(userId,df.format(date));
                if(counts==0){
                    //今天没有签到,进行签到
                    userSignEntity.setUserId(userId);
                    userSignEntity.setSign_time(date);
                    getUserSignEntity(userSignEntity);
                }
            }
            //当天一签签到 ，当前几天没有一次签到
            userSignEntity.setUserId(userId);
            ParsePosition pos = new ParsePosition(0);
            userSignEntity.setSign_time(df.parse(df.format(new Date()), pos));
            getUserSignEntity(userSignEntity);

            json.put("code", 200);
            json.put("msg", "补签成功");
            return json;
        }else{
        //2.获取当前的日期
        // 获得两个时间的毫秒时间差异
        long diff =System.currentTimeMillis()-userSignEntitys.getSign_time().getTime();
        // 计算差多少天
         day = diff / nd;
        }
        //2.如果第一条数据是今天的  先签到后，一签不签 day=0；
       if(day==0){
           long count=0;;
           SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
           String weeks=dateToWeek(dfs.format(new Date()));
           switch(weeks){
               case "星期一" :
                   count=1;
                   break;
               case "星期二" :
                   count=2;
                   break;
               case "星期三" :
                   count=3;
                   break;
               case "星期四" :
                   count=4;
                   break;
               case "星期五" :
                   count=5;
                   break;
               case "星期六" :
                   count=6;
                   break;
               case "星期天" :
                   count=7;
                   break;
           }
           //判断今天是否签到
           Date  date=null;
           for(int i=1;i<count;i++){
               //从第一天开始加1天
               Calendar calendar= new GregorianCalendar();
                   calendar.setTime(new Date());
                   calendar.add(calendar.DATE,-i);
               date=calendar.getTime();
               int counts= userSignService.querySignDate(userId,dfs.format(date));
               if(counts==0){
                   //今天没有签到,进行签到
                   userSignEntity.setUserId(userId);
                   userSignEntity.setSign_time(date);
                   getUserSignEntity(userSignEntity);
               }
           }
           json.put("code", 200);
           json.put("msg", "补签成功");
           return json;
       }

        //判断今天是否签到
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date  date=null;
        for(int i=1;i<=day;i++){
            //从第一天开始加1天
            Calendar calendar= new GregorianCalendar();
            if(userSignEntitys==null){
                calendar.setTime(new Date());
                calendar.add(calendar.DATE,-i);
                date=calendar.getTime();
            }else{
                calendar.setTime(userSignEntitys.getSign_time());
                //把日期往后增加一天.整数往后推,负数往前移动
                calendar.add(calendar.DATE,i);
                //这个时间就是日期往后推一天的结果
                date=calendar.getTime();
            }

            int counts= userSignService.querySignDate(userId,df.format(date));
            if(counts==0){
                //今天没有签到,进行签到
                userSignEntity.setUserId(userId);
                userSignEntity.setSign_time(date);
                getUserSignEntity(userSignEntity);
            }
        }
        json.put("code", 200);
        json.put("msg", "补签成功");
        return json;
    }

    /**
     *
     * @param datetime
     * @return  根据时间转换周期
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        ParsePosition pos = new ParsePosition(0);
        try {
             datet=df.parse(datetime, pos);
            cal.setTime(datet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 签到内容
     */
    public  void getUserSignEntity(UserSignEntity userSignEntity){
        //获取当前时间
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
       ParsePosition pos = new ParsePosition(0);
           // Date date=df.parse(df.format(new Date()), pos);
           // userSignEntity.setSign_time(dfs.parse(dfs.format(new Date()), pos));// new Date()为获取当前系统时间
            String userid= UUID.randomUUID().toString().replaceAll("-", "");
            userSignEntity.setSign_id(userid);
            //转换星期存储起来;
            userSignEntity.setArrays_time(dateToWeek(dfs.format(userSignEntity.getSign_time())));
             userSignEntity.setSign_state("1");//表默认未签到
            userSignEntity.setSign_poins("3");
        userSignService.insertBySign(userSignEntity);

    }
}
