package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserAlipayDao;
import com.qualityshop.entity.UserAlipayEntity;
import com.qualityshop.service.UserAlipayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交易表
 *
 * @author huojg
 */
@Service("userAlipayService")
public class UserAlipayServiceImpl  extends ServiceImpl<UserAlipayDao,UserAlipayEntity> implements UserAlipayService {

    @Resource
    private UserAlipayDao userAlipayDao;

    @Override
    public List<UserAlipayEntity> alipayGet(String userId) {
        List<UserAlipayEntity> userAlipayEntity=userAlipayDao.alipayGet(userId);
        return userAlipayEntity;
    }

    @Override
    public void alipayInsert(UserAlipayEntity UserAlipayEntity) {
        userAlipayDao.alipayInsert(UserAlipayEntity);

    }

    @Override
    public List<UserAlipayEntity> queryByAlipayCountId(String userId, int offset, int end) {
        List<UserAlipayEntity> list=userAlipayDao.queryByAlipayCountId(userId,offset,end);
        return list;
    }
}
