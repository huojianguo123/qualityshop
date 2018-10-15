
package com.qualityshop.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.common.utils.PageUtils;
import com.qualityshop.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 数据字典
 *
 * @author changjian
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

