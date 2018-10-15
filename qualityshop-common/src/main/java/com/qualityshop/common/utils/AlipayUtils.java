package com.qualityshop.common.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.qualityshop.common.taobao.AlipayTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 单笔转账到支付宝账户API工具类
 *
 * @author gaoj
 */
public class AlipayUtils {

    public static String private_app_key;

    public static String alipay_key;

    public static String app_id;

    public static String server_url;

    public static String sign_type;

    public static String dataformat;

    public static String charset;

    public static Properties alipay_properties;

    public static  AlipayClient alipayClient;

    static {

        alipay_properties=new Properties();
        InputStream inStream=AlipayTest.class.getClassLoader().getResourceAsStream("quality_shop_alipay.properties");
        try {
            alipay_properties.load(inStream);

            server_url=alipay_properties.getProperty("server_url");

            alipay_key=alipay_properties.getProperty("alipay_key");

            private_app_key=alipay_properties.getProperty("private_app_key");

            app_id=alipay_properties.getProperty("app_id");

            sign_type=alipay_properties.getProperty("sign_type");

            dataformat=alipay_properties.getProperty("dataformat");

            charset=alipay_properties.getProperty("charset");

        } catch (IOException e) {

            throw new RuntimeException("对不起,你配置的支付宝服务器支付参数解析出错,请检查!");
        }
        alipayClient = new DefaultAlipayClient(server_url,app_id,private_app_key,dataformat,charset,alipay_key,sign_type);

    }

}
