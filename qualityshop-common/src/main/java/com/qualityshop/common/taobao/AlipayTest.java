package com.qualityshop.common.taobao;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.qualityshop.common.utils.AlipayUtils;
import org.junit.Test;

import java.util.Map;
import java.util.Random;

/**
 * 单笔转账到支付宝账户API
 *
 * @author huojg
 */
public class AlipayTest {

    public static void main(String[] args) {
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        long out_biz_no=System.currentTimeMillis()+new Random().nextInt()*366466465;

        System.out.println(out_biz_no);

        String params="{" +
                "\"out_biz_no\":\""+out_biz_no+"\"," +
                "\"payee_type\":\"ALIPAY_LOGONID\"," +
                "\"payee_account\":\"18336294757\"," +
                "\"amount\":\"0.1\"," +
                "\"payer_show_name\":\"青岛畅卓网络科技有限公司\"," +
                "\"payee_real_name\":\"丁静\"," +
                "\"remark\":\"极品城温馨提示:尊敬的用户,感谢您使用《极品城APP》,你成功提现到支付宝账号0.1元\"" +
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
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

    }

    @Test
    public void testQuery() {
        AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
        //out_biz_no  商户订单号 ；order_id是支付宝交易号 | 流水号
        request.setBizContent("{" +
                "\"out_biz_no\":\"1537144973055\"," +
                "\"order_id\":\"20181008110070001502700040219891\"" +
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


        } else {
            System.out.println("调用失败");
        }

    }
    @Test
    public void testJudey() {

        String userInfo="Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_2 like Mac OS X) AppleWebKit/603.2.4 (KHTML, like Gecko) Mobile/14F89 MicroMessenger/6.7.2 NetType/WIFI Language/zh_CN";


        if(userInfo.contains("android")||userInfo.contains("Android")) {

            System.out.println("android");

        }
        else if(userInfo.contains("ios")|| userInfo.contains("IOS")||userInfo.contains("Ios")||userInfo.contains("iPhone")||userInfo.contains("Mac")) {

            System.out.println("IOS");

        }
    }
}
