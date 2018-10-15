package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserAccountEntity;

/**
 * 佣金表接口
 *
 * @author huojg
 */
public interface UserAccountService extends IService<UserAccountEntity> {
    public UserAccountEntity accountGet(String  userId);
    public void accountInsert(UserAccountEntity userAccountEntity);
    public void accountUpdate(UserAccountEntity userAccountEntity);
    public void accountDelete(String userId);
}
