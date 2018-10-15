package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserAlipayEntity;

import java.util.List;

/**
 * 交易表
 *
 * @author huojg
 */
public interface UserAlipayService extends IService<UserAlipayEntity> {

    public List<UserAlipayEntity> alipayGet(String  userId);
    public void alipayInsert(UserAlipayEntity UserAlipayEntity);
    List<UserAlipayEntity> queryByAlipayCountId(String userId, int offset, int end);
}
