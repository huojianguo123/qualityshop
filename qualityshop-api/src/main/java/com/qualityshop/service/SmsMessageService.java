package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.SmsMessageEntity;

/**
 * TODO
 *
 * @author gaoj
 */
public interface SmsMessageService extends IService<SmsMessageEntity> {
    void MessageInsert(SmsMessageEntity smsMessageEntity);
    public void Messagedelete(String mobile);
    public SmsMessageEntity MessageGet(String  mobile);
    void MessageUpdate(SmsMessageEntity smsMessageEntity);

}
