package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserCollectEntity;
import com.qualityshop.form.UserCollectForm;
import com.qualityshop.service.UserCollectService;
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
import java.util.*;

/**
 * 收藏接口
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="收藏接口")
public class UserCollectController {
    @Autowired
    private UserCollectService userCollectService;


    @GetMapping("collect")
    @ApiOperation("收藏查询")
    @ResponseBody
    public JSONObject collect(String page, String  userId){
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        List<UserCollectEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(page==null){
            list=userCollectService.queryByCollect(userId);
        }else if(Integer.parseInt(page)==0){
            offset=1;
            end=10;
            list=userCollectService.queryByCollectCountId(userId, offset,end);
        }else if(Integer.parseInt(page)>=1){
            offset=Integer.parseInt(page)*10;
            end=(Integer.parseInt(page)+1)*10;
            list=userCollectService.queryByCollectCountId(userId, offset,end);
            //list=userConcernService.queryByConcernCount( offset,end);
        }
        //过滤出符合条件的数据
        // List<UserConcernEntity> filterList = list.stream().filter(a -> a.getConcernId().equals("香蕉")).collect(Collectors.toList());
        //JSONArray json = JSONArray.fromObject(list);
        // map = list.stream().collect(Collectors.toMap(UserConcernEntity::getConcernId, a -> a,(k1, k2)->k1));
        JSONObject json =new JSONObject();
        if(list.size()>0){
           for(UserCollectEntity UserCollect:list){
                String [] tabs=UserCollect.getProduct_tab().split(",");
               UserCollect.setProduct_tabs(tabs);
            }
            json.put("code", 200);
            json.put("msg", "success");
        }else{
            json.put("code", 200);
            json.put("msg", "数据为空");
        }
        json.put("list",list);
        return json;
    }

    @PostMapping("collectInsert")
    @ApiOperation("新增收藏")
    public R collectInsert(UserCollectForm userCollectForm){
        UserCollectEntity userCollectEntity =new UserCollectEntity();
        userCollectEntity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //表单校验
        ValidatorUtils.validateEntity(userCollectForm);
        BeanUtils.copyProperties(userCollectForm,userCollectEntity);
        //关注查询
        if(userCollectEntity.getCreate_time()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            userCollectEntity.setCreate_time(df.parse(df.format(new Date()), pos));// new Date()为获取当前系统时间
        }
        userCollectService.insertByCollect(userCollectEntity);
        return R.ok();
    }



}
