package com.qualityshop.controller;


import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.message.GenerateRandomTools;
import com.qualityshop.common.message.SmsTools;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.*;
import com.qualityshop.form.LoginForm;
import com.qualityshop.form.MessageLoginForm;
import com.qualityshop.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 登录接口
 *
 * @author changjian
 */
@RestController
@RequestMapping("/api")
@Api(tags="登录接口")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SmsMessageService smsMessageService;
    @Autowired
    private UserShopmemberService userShopmemberService;
    @Autowired
    private UserPointService userPointService;
    @Autowired
    private UserDetailPointService userDetailPointService;
    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("login")
    @ApiOperation("用户登录")
    public JSONObject login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        Map<String, Object> map = userService.login(form);
        List<String> list = new ArrayList<String>(map.keySet());
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",list);
        //用户登录
        //return R.ok(map);
        return json;
    }


    @PostMapping("Messagelogin")
    @ApiOperation("手机登录")
    public JSONObject Messagelogin(@RequestBody MessageLoginForm form){
        JSONObject json =new JSONObject();
        List<Object> list=new ArrayList<Object>();
        //1.查询当前用户信息
        UserShopmemberEntity userShopmemberEntity=  userShopmemberService.queryByShopmemberPhone(form.getMobile());
        if(userShopmemberEntity!=null){
            //list.add(userShopmemberEntity);
            //查询积分
            UserDetailPointEntity userDetailPointEntity=userDetailPointService.detailPointGet(userShopmemberEntity.getUserId());
            //查询用户佣金
            UserAccountEntity userAccountEntity= userAccountService.accountGet(userShopmemberEntity.getUserId());
            json.put("user", userShopmemberEntity);
            json.put("UserDetailPointEntity",userDetailPointEntity);
            json.put("UserAccountEntity",userAccountEntity);
        }else{
            UserShopmemberEntity UserShopmember=new UserShopmemberEntity();
            String userid=UUID.randomUUID().toString().replaceAll("-", "");
            UserShopmember.setUserId(userid);
            UserShopmember.setUserNickName(GenerateRandomTools.getRandomStr(2,0)+"极品城"+System.currentTimeMillis());
            UserShopmember.setUserAcutalName("");
            UserShopmember.setUserMemberGrade("0");
            UserShopmember.setUserGender("");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            Date date=df.parse(df.format(new Date()), pos);
            UserShopmember.setUserBirthday(date);
            UserShopmember.setCreateTime(date);
            UserShopmember.setUserNickImg("");
            UserShopmember.setUserPhone(form.getMobile());
            userShopmemberService.insertByShopmember(UserShopmember);
            //查询新增信息
            UserShopmemberEntity userShop=  userShopmemberService.queryByShopmember(userid);
            //新增用户初始化积分列表信息
            UserPointEntity userPointEntity =new UserPointEntity();
            String userPointId=UUID.randomUUID().toString().replaceAll("-", "");
            userPointEntity.setId(userPointId);
            userPointEntity.setUserId(userid);
            //默认积分0
            userPointEntity.setPoints("0");
            userPointEntity.setCode("1");
            userPointEntity.setPrority("0");
            userPointEntity.setBeginTime(date);
            //设置超时时间一年
            Long m = 365L*24L*60L*60L*1000L;//一年(毫秒)
            Long time2 = date.getTime()+m;//获取时间戳
            userPointEntity.setEndTime(new Date(time2));
            userPointEntity.setState("0");//默认开启积分
            userPointEntity.setRemark("新用户开启积分功能");
            userPointService.pointInsert(userPointEntity);
            //同步到积分明细表中
            UserDetailPointEntity userDetailPointEntity =new UserDetailPointEntity();
            userDetailPointEntity.setId(userPointId);
            userDetailPointEntity.setUserId(userPointEntity.getUserId());
            userDetailPointEntity.setPoints(userPointEntity.getPoints());
            userDetailPointEntity.setStartTime(userPointEntity.getBeginTime());
            userDetailPointEntity.setExpireTime(userPointEntity.getEndTime());
            userDetailPointService.detailPointInsert(userDetailPointEntity);
            //查询积分明细信息
            UserDetailPointEntity UserDetail=  userDetailPointService.detailPointGet(userDetailPointEntity.getUserId());

           //同步佣金
            UserAccountEntity userAccountEntity =new UserAccountEntity();
            userAccountEntity.setId(userPointId);
            userAccountEntity.setUserId(userPointEntity.getUserId());
            userAccountEntity.setTotal_account(BigDecimal.valueOf(0));
            userAccountEntity.setUse_account(BigDecimal.valueOf(0));
            userAccountEntity.setUnuse_account(BigDecimal.valueOf(0));
            userAccountEntity.setState("0");
            userAccountEntity.setCreate_time(date);
            userAccountService.accountInsert(userAccountEntity);
            if(userShop!=null){
                //list.add(userShop);
                json.put("user", userShop);
                json.put("UserDetailPointEntity",UserDetail);
                json.put("UserAccountEntity",userAccountEntity);
            }

        }
        //表单校验e
        ValidatorUtils.validateEntity(form);
        //短信登录验证码
        SmsMessageEntity smsMessageEntity=smsMessageService.MessageGet(form.getMobile());

        if(smsMessageEntity!=null){
            list.add(smsMessageEntity);
            //判断验证码是否相等
        if(form.getCode().equals(smsMessageEntity.getCode())){
            Long expireDate=smsMessageEntity.getExpire_time().getTime();
            Long newDate=new Date().getTime();
            //设置超时时间5分钟
            if(newDate>expireDate){
                smsMessageService.Messagedelete(form.getMobile());
                json.put("code", 500);
                json.put("msg", "验证码失效");
            }
            //验证码成功 登录成功
            json.put("code", 200);
            json.put("msg", "success");
            json.put("list",list);
            return json;
        }else{
            //登录失败
            json.put("code", 500);
            json.put("msg", "验证码错误");
            json.put("list",list);
            return json;
        }
        }
        json.put("code", 500);
        json.put("msg", "验证码失效");
        return json;
    }


    @PostMapping("pushMessage")
    @ApiOperation("发送短信获取验证码")
    public JSONObject pushMessage(@RequestBody MessageLoginForm form){
        //表单校验e
        ValidatorUtils.validateEntity(form);
        JSONObject json =new JSONObject();
        String message=GenerateRandomTools.getRandomStr(6,0);
        //短信发生验证码
        String resultmessage=SmsTools.sendAliMessage(form.getMobile(), message);
       if(resultmessage=="success"){
           json.put("code", 200);
           json.put("msg", "success");
          SmsMessageEntity smsMessageEntity=new SmsMessageEntity();
           //短信发送成功
           BeanUtils.copyProperties(form,smsMessageEntity);
           if(smsMessageEntity.getCreate_time()==null){
               SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
               ParsePosition pos = new ParsePosition(0);
               Date date=df.parse(df.format(new Date()), pos);
               smsMessageEntity.setCreate_time(date);// new Date()为获取当前系统时间
               //设置超时时间
               Long m = 5L * 60L * 1000L;//5分钟(毫秒)
               Long time2 = date.getTime()+m;//获取时间戳
               smsMessageEntity.setExpire_time(new Date(time2));
           }
           smsMessageEntity.setMobile(form.getMobile());
           smsMessageEntity.setCode(message);
           SmsMessageEntity smsMessage=smsMessageService.MessageGet(form.getMobile());
           if(smsMessage!=null){
               smsMessageEntity.setId(smsMessage.getId());
              smsMessageService.MessageUpdate(smsMessageEntity);
           }else{
               smsMessageEntity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
               smsMessageService.MessageInsert(smsMessageEntity);
           }
           return  json;
       }
       return null;
    }



    @PostMapping("logout")
    @ApiOperation("退出")
    public JSONObject logout(){
        JSONObject json =new JSONObject();
        //tokenService.expireToken(userId);   @Login
        json.put("code", 200);
        json.put("msg", "success");
        return json;
    }


}
