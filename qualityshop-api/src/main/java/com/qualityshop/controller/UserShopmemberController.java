package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserAccountEntity;
import com.qualityshop.entity.UserDetailPointEntity;
import com.qualityshop.entity.UserPointEntity;
import com.qualityshop.entity.UserShopmemberEntity;
import com.qualityshop.form.UserShopmemberForm;
import com.qualityshop.service.UserAccountService;
import com.qualityshop.service.UserDetailPointService;
import com.qualityshop.service.UserPointService;
import com.qualityshop.service.UserShopmemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 手机用户信息接口
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="手机用户信息接口")
public class UserShopmemberController {
    @Autowired
    private UserShopmemberService userShopmemberService;

    @Autowired
    private UserPointService userPointService;
    @Autowired
    private UserDetailPointService userDetailPointService;
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("modelUser")
    @ApiOperation("手机用户信息查询")
    @ResponseBody
    public JSONObject modelUser(String userId){
        //表单校验
        //ValidatorUtils.validateEntity(form);
        Map<String, Object> map=null;
        List<UserShopmemberEntity> list=new ArrayList<>();
        UserShopmemberEntity userShopmemberEntity=  userShopmemberService.queryByShopmember(userId);
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        String sss=dfs.format(userShopmemberEntity.getUserBirthday());
        userShopmemberEntity.setUserBirthday(dfs.parse( dfs.format(userShopmemberEntity.getUserBirthday()), pos));
        //查询积分明细信息
        UserDetailPointEntity UserDetail=  userDetailPointService.detailPointGet(userId);

        list.add(userShopmemberEntity);

        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",list);
        json.put("points",UserDetail.getPoints());
        return json;
    }
    @GetMapping("openUser")
    @ApiOperation("微信用户信息查询")
    @ResponseBody
    public JSONObject openUser(String openId){
        //表单校验
        //ValidatorUtils.validateEntity(form);
        Map<String, Object> map=null;
        List<UserShopmemberEntity> list=new ArrayList<>();
        UserShopmemberEntity userShopmemberEntity=  userShopmemberService.queryOpenByShopmember(openId);
        list.add(userShopmemberEntity);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",userShopmemberEntity);
        return json;
    }

    @PostMapping("ModelUserInsert")
    @ApiOperation("手机用户新增")
    @ResponseBody
    public R ModelUserInsert(UserShopmemberForm userShopmemberForm){
        JSONObject json =new JSONObject();
        UserShopmemberEntity userShopmemberEntity =new UserShopmemberEntity();
        //表单校验
        ValidatorUtils.validateEntity(userShopmemberForm);
        BeanUtils.copyProperties(userShopmemberForm,userShopmemberEntity);
        //用户信息查询
        if(userShopmemberEntity.getCreateTime()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            userShopmemberEntity.setCreateTime(df.parse(df.format(new Date()), pos));// new Date()为获取当前系统时间
            userShopmemberEntity.setUserBirthday(df.parse(df.format(new Date()), pos));
        }
        if(userShopmemberEntity.getOpenId()!=null){
            userShopmemberEntity.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        UserShopmemberEntity userShopmemb=  userShopmemberService.queryOpenByShopmember(userShopmemberForm.getOpenId());
        if(userShopmemb!=null){
            return  R.ok("用户已存在");
        }else{
        userShopmemberService.insertByShopmember(userShopmemberEntity);

        //查询新增信息
        UserShopmemberEntity userShop=  userShopmemberService.queryByShopmember(userShopmemberEntity.getUserId());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        ParsePosition pos = new ParsePosition(0);
        Date date=df.parse(df.format(new Date()), pos);
        //新增用户初始化积分列表信息
        UserPointEntity userPointEntity =new UserPointEntity();
        String userPointId=UUID.randomUUID().toString().replaceAll("-", "");
        userPointEntity.setId(userPointId);
        userPointEntity.setUserId(userShopmemberEntity.getUserId());
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
        }
        return R.ok();
    }

    @PostMapping("ModelUserUpdate")
    @ApiOperation("手机用户修改")
    @ResponseBody
    public JSONObject ModelUserUpdate(UserShopmemberForm userShopmemberForm){
        UserShopmemberEntity userShopmemberEntity =new UserShopmemberEntity();
        //表单校验
        ValidatorUtils.validateEntity(userShopmemberForm);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);

        //BeanUtils.copyProperties(userShopmemberForm,userShopmemberEntity);
        userShopmemberEntity.setUserId(userShopmemberForm.getUserId());
        userShopmemberEntity.setUserNickName(userShopmemberForm.getUserNickName());
        userShopmemberEntity.setUserNickImg(userShopmemberForm.getUserNickImg());
        userShopmemberEntity.setUserAcutalName(userShopmemberForm.getUserAcutalName());
        userShopmemberEntity.setUserMemberGrade(userShopmemberForm.getUserMemberGrade());
        userShopmemberEntity.setUserGender(userShopmemberForm.getUserGender());
        userShopmemberEntity.setUserPhone(userShopmemberForm.getUserPhone());
        userShopmemberEntity.setAlipayAccount(userShopmemberForm.getAlipayAccount());
        userShopmemberEntity.setAlipayName(userShopmemberForm.getAlipayName());
        if(userShopmemberForm.getUserBirthday()!=null){
           //设置日期格式
            String birthday=userShopmemberForm.getUserBirthday();
         userShopmemberEntity.setUserBirthday(dfs.parse(birthday, pos));
            }
        //用户信息查询
        if(userShopmemberForm.getCreateTime()==null){

            userShopmemberEntity.setCreateTime(df.parse(df.format(new Date()), pos));// new Date()为获取当前系统时间
        }
        if(userShopmemberForm.getUserBirthday()==null){
            userShopmemberEntity.setUserBirthday(dfs.parse(dfs.format(new Date()), pos));
        }
        userShopmemberService.shopmemberUpdate(userShopmemberEntity);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        return json;
    }
    @PostMapping("ModelUserDelete")
    @ApiOperation("手机用户删除")
    @ResponseBody
    public JSONObject ModelUserDelete(String userId){
        JSONObject json =new JSONObject();
        if(userId!=null||userId!=""){
            userShopmemberService.shopmemberdelete(userId);
            json.put("code", 200);
            json.put("msg", "success");
        }
        return json;
    }

}
