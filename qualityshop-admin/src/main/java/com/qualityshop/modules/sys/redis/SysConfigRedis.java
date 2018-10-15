package com.qualityshop.modules.sys.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qualityshop.common.utils.RedisKeys;
import com.qualityshop.common.utils.RedisUtils;
import com.qualityshop.modules.sys.entity.SysConfigEntity;

/**
 * 系统配置Redis
 *
 * @author changjian
 */
@Component
public class SysConfigRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if(config == null){
            return ;
        }
        String key = RedisKeys.getSysConfigKey(config.getParamKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfigEntity get(String configKey){
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfigEntity.class);
    }
}
