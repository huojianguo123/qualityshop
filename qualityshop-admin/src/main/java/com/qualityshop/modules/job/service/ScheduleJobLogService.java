
package com.qualityshop.modules.job.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.common.utils.PageUtils;
import com.qualityshop.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author changjian
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
