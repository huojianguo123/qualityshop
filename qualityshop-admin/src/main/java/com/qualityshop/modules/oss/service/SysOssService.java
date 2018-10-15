
package com.qualityshop.modules.oss.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.common.utils.PageUtils;
import com.qualityshop.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 * 
 * @author changjian
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
