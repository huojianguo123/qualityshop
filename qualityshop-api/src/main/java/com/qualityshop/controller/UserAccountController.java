package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserAccountEntity;
import com.qualityshop.form.UserAccountForm;
import com.qualityshop.service.UserAccountService;
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

/**
 * 佣金表
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="佣金表接口")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("account")
    @ApiOperation("佣金查询")
    @ResponseBody
    public JSONObject point(String userId){
        UserAccountEntity userAccountEntity=userAccountService.accountGet(userId);
        List<UserAccountEntity> list= new ArrayList<>();
        if(userAccountEntity!=null){
            list.add(userAccountEntity);
        }
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",list);

        return json;
    }

    @PostMapping("accountInsert")
    @ApiOperation("佣金添加")
    public R collectInsert(UserAccountForm userAccountForm){
        UserAccountEntity userAccountEntity =new UserAccountEntity();
        //表单校验
        ValidatorUtils.validateEntity(userAccountForm);
        BeanUtils.copyProperties(userAccountForm,userAccountEntity);
        //短信查询
        if(userAccountEntity.getCreate_time()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            Date date=df.parse(df.format(new Date()), pos);
            userAccountEntity.setCreate_time(date);// new Date()为获取当前系统时间
            userAccountEntity.setState("0");//佣金表默认开启
        }
        userAccountService.accountInsert(userAccountEntity);
        return R.ok();
    }

    @PostMapping("accountupdate")
    @ApiOperation("佣金修改")
    public R accountupdate(UserAccountForm userAccountForm){
        UserAccountEntity userAccountEntity =new UserAccountEntity();
        //表单校验
        ValidatorUtils.validateEntity(userAccountForm);
        BeanUtils.copyProperties(userAccountForm,userAccountEntity);
        userAccountService.accountUpdate(userAccountEntity);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "佣金修改成功");
        return R.ok();
    }
    @PostMapping("accountdelete")
    @ApiOperation("佣金删除")
    public R pointdelete(String userId){
        userAccountService.accountDelete(userId);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "佣金删除成功");
        return R.ok();
    }

}
