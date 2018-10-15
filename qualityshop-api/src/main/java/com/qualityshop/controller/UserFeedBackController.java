package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserFeedBackEntity;
import com.qualityshop.form.UserFeedBackForm;
import com.qualityshop.service.UserFeedBackService;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 反馈表
 *
 * @author gaoj
 */
@Controller
@RequestMapping("/api")
@Api(tags="反馈接口")
public class UserFeedBackController {

    @Autowired
    private UserFeedBackService userFeedBackService;


    @GetMapping("feedBack")
    @ApiOperation("反馈查询")
    @ResponseBody
    public JSONObject feedBack(String userId){
       List<UserFeedBackEntity>  list=userFeedBackService.feedBackGet(userId);
        JSONObject json =new JSONObject();
       if(list.size()>0){
          json.put("code", 200);
          json.put("msg", "success");
          json.put("list",list);

      }
        return json;
    }

    @PostMapping("feedBackInsert")
    @ApiOperation("反馈添加")
    @ResponseBody
    public R collectInsert(UserFeedBackForm userFeedBackForm){
        UserFeedBackEntity userFeedBackEntity =new UserFeedBackEntity();
        //表单校验
        ValidatorUtils.validateEntity(userFeedBackForm);
        BeanUtils.copyProperties(userFeedBackForm,userFeedBackEntity);
        //短信查询
        if(userFeedBackEntity.getCreate_time()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            Date date=df.parse(df.format(new Date()), pos);
            userFeedBackEntity.setCreate_time(date);// new Date()为获取当前系统时间
        }
        userFeedBackEntity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userFeedBackEntity.setUserId(userFeedBackForm.getUserId());
        userFeedBackEntity.setContent(userFeedBackForm.getContent());
        userFeedBackService.feedBackInsert(userFeedBackEntity);

        return R.ok();
    }


}
