package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserAccountDao;
import com.qualityshop.entity.UserAccountEntity;
import com.qualityshop.service.UserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 佣金表接口
 *
 * @author huojg
 */
@Service("userAccountService")
public class UserAccountServiceImpl extends ServiceImpl<UserAccountDao,UserAccountEntity> implements UserAccountService{

    @Resource
    private UserAccountDao userAccountDao;

    @Override
    public UserAccountEntity accountGet(String userId) {
        UserAccountEntity userAccountEntity= userAccountDao.accountGet(userId);
        return userAccountEntity;
    }

    @Override
    public void accountInsert(UserAccountEntity userAccountEntity) {
        userAccountDao.accountInsert(userAccountEntity);
    }

    @Override
    public void accountUpdate(UserAccountEntity userAccountEntity) {
        userAccountDao.accountUpdate(userAccountEntity);
    }

    @Override
    public void accountDelete(String userId) {
        userAccountDao.accountDelete(userId);
    }
}
