package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.entity.UserAlipayEntity;
import com.qualityshop.service.UserAlipayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 支付宝账户表
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="支付宝账户表接口")
public class UserAlipayController {

    @Autowired
    private UserAlipayService userAlipayService;

    @GetMapping("alipay")
    @ApiOperation("支付宝账户查询")
    @ResponseBody
    public JSONObject alipay(String page, String  userId){
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        List<UserAlipayEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(page==null){
            list=userAlipayService.alipayGet(userId);
        }else if(Integer.parseInt(page)==0){
            offset=1;
            end=10;
            list=userAlipayService.queryByAlipayCountId(userId, offset,end);
        }else if(Integer.parseInt(page)>=1){
            offset=Integer.parseInt(page)*10;
            end=(Integer.parseInt(page)+1)*10;
            list=userAlipayService.queryByAlipayCountId(userId, offset,end);
        }
        JSONObject json =new JSONObject();
        if(list.size()>0){
            json.put("code", 200);
            json.put("msg", "success");
        }else{
            json.put("code", 200);
            json.put("msg", "数据为空！");
        }
        json.put("list",list);

        return json;
    }
}
