package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserAlipayEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 支付宝交易记录表
 *
 * @author huojg
 */
public interface UserAlipayDao extends BaseMapper<UserAlipayEntity> {

    public List<UserAlipayEntity> alipayGet(String  userId);
    public void alipayInsert(UserAlipayEntity UserAlipayEntity);
    List<UserAlipayEntity> queryByAlipayCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);
}
