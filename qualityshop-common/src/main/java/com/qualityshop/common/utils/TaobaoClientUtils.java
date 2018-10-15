package com.qualityshop.common.utils;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;

/**
 * 淘宝客API接口
 *
 * @author huojg
 */
public class TaobaoClientUtils {
    public static final String url="http://gw.api.taobao.com/router/rest";

    public static final String key="24930482";
    public static final String secret="afa6006124e6c0f199f6b998e7d2f7d9";

    public static final TaobaoClient client;
    static {

        client= new DefaultTaobaoClient(url,key,secret);
    }

}
