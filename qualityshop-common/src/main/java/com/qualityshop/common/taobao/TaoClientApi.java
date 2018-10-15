package com.qualityshop.common.taobao;

import com.qualityshop.common.utils.TaobaoClientUtils;
import com.taobao.api.ApiException;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import org.junit.Test;

/**
 * 淘宝客API接口
 */
public class TaoClientApi {

	/**
	 * taobao.tbk.item.get( 淘宝客商品查询 )
	 */
	@Test
	public void getItem() {
		TbkItemGetRequest req = new TbkItemGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		req.setQ("女装");
		req.setCat("16,18");
		req.setItemloc("杭州");

		TbkItemGetResponse rsp = null;
		try {
			rsp = TaobaoClientUtils.client.execute(req);
		} catch (ApiException e) {

			e.printStackTrace();
		}
		System.out.println(rsp.getBody());

	}

	/**
	 * taobao.tbk.item.recommend.get( 淘宝客商品关联推荐查询 )
	 */
	@Test
	public void getRecommend() {

		TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setNumIid(569118516896L);
		req.setCount(20L);
		req.setPlatform(1L);
		TbkItemRecommendGetResponse rsp = null;
		try {
			rsp = TaobaoClientUtils.client.execute(req);
		} catch (ApiException e) {

			e.printStackTrace();
		}
		System.out.println(rsp.getBody());

	}

	/**
	 * taobao.tbk.tpwd.create( 淘宝客淘口令 )
	 */
	@Test
	public void createTpwd() {
		TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
		req.setUserId("123");
		req.setText("长度大于5个字符");
		req.setUrl("https://uland.taobao.com/");
		req.setLogo("https://uland.taobao.com/");
		req.setExt("{}");
		TbkTpwdCreateResponse rsp = null;
		try {
			rsp = TaobaoClientUtils.client.execute(req);
		} catch (ApiException e) {

			throw new RuntimeException("生成淘客口令失败!");
		}
		System.out.println(rsp.getBody());
	}

	/**
	 * taobao.tbk.dg.item.coupon.get( 好券清单API【导购】 )
	 */
	@Test
	public void getCoupon() {
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		req.setAdzoneId(123L);
		req.setPlatform(1L);
		req.setCat("16,18");
		req.setPageSize(1L);
		req.setQ("女装");
		req.setPageNo(1L);
		TbkDgItemCouponGetResponse rsp = null;
		try {
			rsp = TaobaoClientUtils.client.execute(req);
		} catch (ApiException e) {

			e.printStackTrace();
		}
		System.out.println(rsp.getBody());

	}

	/**
	 * taobao.tbk.shop.get( 淘宝客店铺查询 )
	 */
	@Test
	public void getshop(){
		TbkShopGetRequest req = new TbkShopGetRequest();
		req.setFields("user_id,shop_title,shop_type,seller_nick,pict_url,shop_url");
		req.setQ("女装");
		req.setSort("commission_rate_des");
		req.setIsTmall(false);
		req.setStartCredit(1L);
		req.setEndCredit(20L);
		req.setStartCommissionRate(2000L);
		req.setEndCommissionRate(123L);
		req.setStartTotalAction(1L);
		req.setEndTotalAction(100L);
		req.setStartAuctionCount(123L);
		req.setEndAuctionCount(200L);
		req.setPlatform(1L);
		req.setPageNo(1L);
		req.setPageSize(20L);
		TbkShopGetResponse rsp = null;
		try {
			rsp = TaobaoClientUtils.client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
	}
     
}
