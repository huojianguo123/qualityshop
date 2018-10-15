package com.qualityshop.common.taobao;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.BaichuanUserLoginRequest;
import com.taobao.api.request.HttpdnsGetRequest;
import com.taobao.api.response.BaichuanUserLoginResponse;
import com.taobao.api.response.HttpdnsGetResponse;

public class ApiTest {
/*
*飞猪开放平台
 */
	public static void main(String[] args) throws Exception {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "25025861", "c00e460c77f2cd9e70cd57dd9643ed65");
		HttpdnsGetRequest req = new HttpdnsGetRequest();
		HttpdnsGetResponse rsp = client.execute(req,"610142117246ef59099714fd0a357153a999ef8b829a6394076582702");
		System.out.println(rsp.getBody());
		/*TopAuthTokenCreateRequest req1 = new TopAuthTokenCreateRequest();
		req1.setCode("0_ebKlCPqc6OD8RBlB0DzfnpUg2");
		req1.setUuid("abc");
		TopAuthTokenCreateResponse rsp1 = client.execute(req1,"610142117246ef59099714fd0a357153a999ef8b829a6394076582702");
		System.out.println(rsp1.getBody());*/

		//查询买家信息
		BaichuanUserLoginRequest req2 = new BaichuanUserLoginRequest();
		req2.setName("");
		BaichuanUserLoginResponse rsp2 = client.execute(req2, "610142117246ef59099714fd0a357153a999ef8b829a6394076582702");
		System.out.println(rsp2.getBody());

		//订单信息


	}
}
