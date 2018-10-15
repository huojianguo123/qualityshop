package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.SmsMessageEntity;

/**
 * 短信通知接口
 *
 * @author huojg
 */
public interface SmsMessageDao extends BaseMapper<SmsMessageEntity> {
    public void Messagedelete(String mobile);
    public SmsMessageEntity MessageGet(String  mobile);
    void MessageInsert(SmsMessageEntity smsMessageEntity);

    void MessageUpdate(SmsMessageEntity smsMessageEntity);
}
