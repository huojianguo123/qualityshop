package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.UserSnapEntity;
import com.qualityshop.form.UserSnapForm;
import com.qualityshop.service.UserSnapService;
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

/**
 * 点赞接口
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="点赞接口")
public class UserSnapController {
    @Autowired
   private UserSnapService userSnapService;

    @GetMapping("snap")
    @ApiOperation("点赞查询")
    @ResponseBody
    public JSONObject snap(String page, String  userId){
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        List<UserSnapEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(page==null){
            list=userSnapService.queryBySnap(userId);
        }else if(Integer.parseInt(page)==0){
            offset=1;
            end=10;
            list=userSnapService.queryBySnapCountId(userId, offset,end);
        }else if(Integer.parseInt(page)>=1){
            offset=Integer.parseInt(page)*10;
            end=(Integer.parseInt(page)+1)*10;
            list=userSnapService.queryBySnapCountId(userId, offset,end);
            //list=userConcernService.queryByConcernCount( offset,end);
        }
        //过滤出符合条件的数据
        // List<UserConcernEntity> filterList = list.stream().filter(a -> a.getConcernId().equals("香蕉")).collect(Collectors.toList());
        //JSONArray json = JSONArray.fromObject(list);
        // map = list.stream().collect(Collectors.toMap(UserConcernEntity::getConcernId, a -> a,(k1, k2)->k1));
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",list);

        return json;
    }

    @PostMapping("snapInsert")
    @ApiOperation("新增点赞")
    public R concerInsert(UserSnapForm userSnapForm){
        UserSnapEntity userSnapEntity =new UserSnapEntity();
        //表单校验
        ValidatorUtils.validateEntity(userSnapForm);
        BeanUtils.copyProperties(userSnapForm,userSnapEntity);
        //关注查询
        if(userSnapEntity.getVote_time()==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            ParsePosition pos = new ParsePosition(0);
            userSnapEntity.setVote_time(df.parse(df.format(new Date()), pos));// new Date()为获取当前系统时间
        }
        userSnapService.insertBySnap(userSnapEntity);
        return R.ok();
    }




}
