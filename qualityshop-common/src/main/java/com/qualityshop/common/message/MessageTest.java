package com.qualityshop.common.message;

import com.aliyuncs.exceptions.ClientException;

/**
 * 短信平台接口对接测试
 *
 * @author huojg
 */
public class MessageTest {

    public static void main(String[] args) throws ClientException, InterruptedException {

        //发短信
       String msg= SmsTools.sendAliMessage("18606595301",GenerateRandomTools.getRandomStr(6,2));
       /* System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());*/
        Thread.sleep(3000L);
        //查明细
    }
}
