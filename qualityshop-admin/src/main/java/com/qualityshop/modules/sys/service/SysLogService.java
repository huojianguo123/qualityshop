package com.qualityshop.modules.sys.service;


import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.common.utils.PageUtils;
import com.qualityshop.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 * 
 * @author changjian
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
