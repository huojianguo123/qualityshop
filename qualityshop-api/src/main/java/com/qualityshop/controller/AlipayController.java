package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.qualityshop.common.utils.AlipayUtils;
import com.qualityshop.entity.UserAccountEntity;
import com.qualityshop.entity.UserAlipayEntity;
import com.qualityshop.service.UserAccountService;
import com.qualityshop.service.UserAlipayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 单笔转账到支付宝账户API
 *
 * @author huojg
 */
@RestController
@RequestMapping("/api")
@Api(tags="单笔转账到支付宝账户接口")
public class AlipayController {
    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAlipayService userAlipayService;
    @PostMapping("lipay")
    @ApiOperation("单笔转账到支付宝账户")
    public JSONObject login(String real_name ,String amount,String phone,String userId) {
        JSONObject json =new JSONObject();
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        long out_biz_no=System.currentTimeMillis()+new Random().nextInt()*366466465;

        System.out.println(out_biz_no);
        String pay_name="极品城";
        String params="{" +
                "\"out_biz_no\":\""+out_biz_no+"\"," +
                "\"payee_type\":\"ALIPAY_LOGONID\"," +
                "\"payee_account\":\""+phone+"\"," +
                "\"amount\":\""+amount+"\"," +
                "\"payer_show_name\":\""+pay_name+"\"," +
                "\"payee_real_name\":\""+real_name+"\"," +
                "\"remark\":\"极品城温馨提示:尊敬的用户,感谢您使用《极品城APP》,你成功提现到支付宝账号"+amount+"元\"" +
                "}";
        System.out.println(params);

        request.setBizContent(params);

        AlipayFundTransToaccountTransferResponse response = null;

        try {

            response = AlipayUtils.alipayClient.execute(request);
        } catch (AlipayApiException e) {

            e.printStackTrace();
        }

        if(response.isSuccess()){
            System.out.println("提现成功");
            json.put("code", 200);
            json.put("msg", "提现成功");
            //1.提现成功，去除资金表中的佣金
            UserAccountEntity userAccount=userAccountService.accountGet(userId);
            //setScale(3, java.math.BigDecimal.ROUND_HALF_UP);
            if(userAccount!=null){
                userAccount.setTotal_account(userAccount.getTotal_account().subtract(new BigDecimal(amount)));
                userAccount.setUse_account(userAccount.getUse_account().add(new BigDecimal(amount)));
                userAccount.setUnuse_account(userAccount.getUnuse_account().add(new BigDecimal(amount)));
                userAccountService.accountUpdate(userAccount);
            }
           //2.查询支付宝订单信息,把提现信息保存支付宝信息表中
            aliPayInsert(userId,response.getOutBizNo(),response.getOrderId(),amount);

            return json;
        } else {
            json.put("code", 400);
            json.put("msg", "提现失败");
            System.out.println("提现失败");

            return json;

        }
    }
    @GetMapping("lipaySelect")
    @ApiOperation("单笔转账到支付宝账户查询")
    @ResponseBody
    public JSONObject lipaySelect(String out_biz_no,String order_id) {
        AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
        JSONObject json =new JSONObject();
        //out_biz_no  商户订单号 ；order_id是支付宝交易号 | 流水号
        request.setBizContent("{" +
                "\"out_biz_no\":\""+out_biz_no+"\"," +
                "\"order_id\":\""+order_id+"\"" +
                "  }");
        AlipayFundTransOrderQueryResponse response = null;
        try {
            response = AlipayUtils.alipayClient.execute(request);
        } catch (AlipayApiException e) {

            e.printStackTrace();
        }
        if(response.isSuccess()){

            Map<String,String> params=response.getParams();

            for(Map.Entry<String, String> data:params.entrySet()) {
                String key=data.getKey();
                String value=data.getValue();

                System.out.println(key+":::"+value);
            }
            System.out.println(response.getBody());
            json.put("code", 200);
            json.put("msg", "查询成功");
            return json;

        } else {

            System.out.println("查询失败");
            return json;
        }

    }

    /**
     * 新增支付信息表信息
      */

    public JSONObject aliPayInsert(String userId,String out_biz_no,String order_id,String amount) {
        AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
        JSONObject json =new JSONObject();
        //out_biz_no  商户订单号 ；order_id是支付宝交易号 | 流水号
        request.setBizContent("{" +
                "\"out_biz_no\":\""+out_biz_no+"\"," +
                "\"order_id\":\""+order_id+"\"" +
                "  }");
        AlipayFundTransOrderQueryResponse response = null;
        try {
            response = AlipayUtils.alipayClient.execute(request);
        } catch (AlipayApiException e) {

            e.printStackTrace();
        }
        if(response.isSuccess()){

            Map<String,String> params=response.getParams();

            for(Map.Entry<String, String> data:params.entrySet()) {
                String key=data.getKey();
                String value=data.getValue();

                System.out.println(key+":::"+value);
            }
            System.out.println(response.getBody());
            //把信息新增到支付表中
            UserAlipayEntity userAlipayEntity=new UserAlipayEntity();
            userAlipayEntity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            userAlipayEntity.setUserId(userId);
            userAlipayEntity.setPay_name("极品城");
            userAlipayEntity.setOrder_id(response.getOrderId());
            userAlipayEntity.setOut_biz_no(response.getOutBizNo());
            userAlipayEntity.setAccountTime(response.getPayDate());
            userAlipayEntity.setAmount(amount);
            userAlipayService.alipayInsert(userAlipayEntity);
            json.put("code", 200);
            json.put("msg", "查询成功");
            return json;

        } else {

            System.out.println("查询失败");
            return json;
        }

    }

}