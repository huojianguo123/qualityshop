package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserConcernEntity;
import com.qualityshop.form.UserConcernForm;
import com.qualityshop.service.UserConcernService;
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
import java.util.Map;
import java.util.UUID;

/**
 * 关注接口
 *
 * @author changjian
 */
@Controller
@RequestMapping("/api")
@Api(tags="关注接口")
public class UserConcernController {

    @Autowired
    private UserConcernService userConcernService;
    @GetMapping("concer")
    @ApiOperation("关注查询")
    @ResponseBody
    public JSONObject concer( String page,  String  userId){
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        List<UserConcernEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(page==null){
           list=userConcernService.queryByConcern(userId);
        }else if(Integer.parseInt(page)==0){
           offset=0;
           end=10;
           list=userConcernService.queryByConcernCountId(userId, offset,end);
        }else if(Integer.parseInt(page)>=1){
            offset=Integer.parseInt(page)*10;
            end=(Integer.parseInt(page)+1)*10;
            list=userConcernService.queryByConcernCountId(userId, offset,end);
           //list=userConcernService.queryByConcernCount( offset,end);
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

    @PostMapping("concerInsert")
    @ApiOperation("新增关注")
    @ResponseBody
    public R concerInsert(UserConcernForm  userConcernForm){
        UserConcernEntity  userConcernEntity =new UserConcernEntity();
        userConcernEntity.setConcernId(UUID.randomUUID().toString().replaceAll("-", ""));
        //表单校验
        ValidatorUtils.validateEntity(userConcernForm);
        BeanUtils.copyProperties(userConcernForm,userConcernEntity);
        //关注查询
       if(userConcernEntity.getCreate_time()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            userConcernEntity.setCreate_time(df.parse(df.format(new Date()), pos));// new Date()为获取当前系统时间
        }
       userConcernService.insertByConcern(userConcernEntity);
        return R.ok();
    }
    @PostMapping("concerDelete")
    @ApiOperation("删除关注")
    @ResponseBody
    public JSONObject concerDelete(String concerId){
        JSONObject json =new JSONObject();
        if(concerId!=null||concerId!=""){
            userConcernService.concerDelete(concerId);
            json.put("code", 200);
            json.put("msg", "success");
        }
        return json;
    }

}