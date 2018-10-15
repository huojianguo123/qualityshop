package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.SmsMessageEntity;
import com.qualityshop.form.SmsMessageForm;
import com.qualityshop.service.SmsMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 短信通知接口
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="短信通知接口")
public class SmsMessageController {
    @Autowired
    private SmsMessageService smsMessageService;


    @GetMapping("smsMessage")
    @ApiOperation("短信通知查询")
    public JSONObject smsMessage(String mobile){
        SmsMessageEntity  smsMessageEntity=smsMessageService.MessageGet(mobile);
        List<SmsMessageEntity> list= new ArrayList<>();
        list.add(smsMessageEntity);
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",list);

        return json;
    }

    @PostMapping("smsMessageInsert")
    @ApiOperation("短信通知添加")
    public R collectInsert(SmsMessageForm smsMessageForm){
        SmsMessageEntity smsMessageEntity =new SmsMessageEntity();
        //表单校验
        ValidatorUtils.validateEntity(smsMessageForm);
        BeanUtils.copyProperties(smsMessageForm,smsMessageEntity);
        //短信查询
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
        SmsMessageEntity smsMessage=smsMessageService.MessageGet(smsMessageForm.getMobile());
        if(smsMessage!=null){
            smsMessageEntity.setId(smsMessage.getId());
            smsMessageService.MessageUpdate(smsMessageEntity);
        }else{
            smsMessageEntity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            smsMessageService.MessageInsert(smsMessageEntity);
        }
        return R.ok();
    }




}
