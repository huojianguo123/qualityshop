package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserDetailPointEntity;
import com.qualityshop.entity.UserPointEntity;
import com.qualityshop.form.UserPointForm;
import com.qualityshop.service.UserDetailPointService;
import com.qualityshop.service.UserPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 积分总额表
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="积分接口")
public class UserPointController {
    @Autowired
    private UserPointService userPointService;

    @Autowired
    private UserDetailPointService userDetailPointService;

    @GetMapping("point")
    @ApiOperation("积分查询")
    @ResponseBody
    public JSONObject point(String userId){
        UserPointEntity userPointEntity=userPointService.pointGet(userId);
        List<UserPointEntity> list= new ArrayList<>();
        list.add(userPointEntity);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",list);

        return json;
    }

    @PostMapping("pointInsert")
    @ApiOperation("积分添加")
    public R collectInsert(UserPointForm userPointForm){
        UserPointEntity userPointEntity =new UserPointEntity();
        //表单校验
        ValidatorUtils.validateEntity(userPointForm);
        BeanUtils.copyProperties(userPointForm,userPointEntity);
        //短信查询
        if(userPointEntity.getBeginTime()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            Date date=df.parse(df.format(new Date()), pos);
            userPointEntity.setBeginTime(date);// new Date()为获取当前系统时间
            //设置超时时间一年
            Long m = 365L*24L*60L*60L*1000L;//一年(毫秒)
            Long time2 = date.getTime()+m;//获取时间戳
            userPointEntity.setEndTime(new Date(time2));
        }
        //同步到明细表中
        UserPointEntity userPoint=userPointService.pointGet(userPointEntity.getId());
        UserDetailPointEntity userDetailPointEntity =new UserDetailPointEntity();
        userDetailPointEntity.setUserId(userPointEntity.getUserId());
        userDetailPointEntity.setStartTime(userPointEntity.getBeginTime());
        userDetailPointEntity.setExpireTime(userPointEntity.getEndTime());
        if(userPoint!=null){
            userPointEntity.setId(userPoint.getId());
            userDetailPointEntity.setId(userPoint.getId());
            userDetailPointEntity.setPoints(userPointEntity.getPoints());
            userPointService.pointUpdate(userPointEntity);
            //同步到积分明细表中
            userDetailPointService.detailPointUpdate(userDetailPointEntity);

        }else{
            String userid=UUID.randomUUID().toString().replaceAll("-", "");
            userPointEntity.setId(userid);
            userDetailPointEntity.setId(userid);
            //默认积分0
            userDetailPointEntity.setPoints("0");
            userPointService.pointInsert(userPointEntity);
            //同步到积分明细表中
            userDetailPointService.detailPointInsert(userDetailPointEntity);
        }
        return R.ok();
    }

    @PostMapping("pointupdate")
    @ApiOperation("积分修改")
    public R pointupdate(UserPointForm userPointForm){
        UserPointEntity userPointEntity=userPointService.pointGet(userPointForm.getUserId());
        int a =Integer.parseInt(userPointEntity.getPoints());
        if(a>0&&a<=1000){
            userPointEntity.setPrority("1");
        }else if (a>1000&&a<=2000){
            userPointEntity.setPrority("2");
        }else if(a>2000&&a<=3000){
            userPointEntity.setPrority("3");
        }else if(a>3000&&a<=4000){
            userPointEntity.setPrority("4");
        }
        else if(a>4000&&a<=5000){
            userPointEntity.setPrority("5");
        }
        else if(a>5000&&a<=6000){
            userPointEntity.setPrority("6");
        }
        else if(a>6000&&a<=7000){
            userPointEntity.setPrority("7");
        }
        userPointService.pointUpdate(userPointEntity);
        //查询积分明细信息
        UserDetailPointEntity UserDetail=  userDetailPointService.detailPointGet(userPointForm.getUserId());
        UserDetail.setPoints(userPointEntity.getPoints());
        userDetailPointService.detailPointUpdate(UserDetail);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "积分修改成功");
        return R.ok();
    }

    @PostMapping("pointdelete")
    @ApiOperation("积分删除")
    public R pointdelete(String userId){
        userPointService.pointDelete(userId);
        userDetailPointService.detailPointDelete(userId);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "积分删除成功");
        return R.ok();
    }




}
