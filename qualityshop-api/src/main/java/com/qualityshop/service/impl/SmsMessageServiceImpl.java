package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.SmsMessageDao;
import com.qualityshop.entity.SmsMessageEntity;
import com.qualityshop.service.SmsMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 短信验证码接口
 *
 * @author huojg
 */
@Service("smsMessageService")
public class SmsMessageServiceImpl extends ServiceImpl<SmsMessageDao,SmsMessageEntity> implements SmsMessageService {
    @Resource
    private SmsMessageDao smsMessaeDao;

    @Override
    public void MessageInsert(SmsMessageEntity smsMessageEntity) {
        smsMessaeDao.MessageInsert(smsMessageEntity);
    }

    @Override
    public void Messagedelete(String mobile){
        smsMessaeDao.Messagedelete(mobile);
    }

    @Override
    public SmsMessageEntity MessageGet(String  mobile){
        return  smsMessaeDao.MessageGet(mobile);
    }

    @Override
    public void MessageUpdate(SmsMessageEntity smsMessageEntity) {
       smsMessaeDao.MessageUpdate(smsMessageEntity);
    }

}
