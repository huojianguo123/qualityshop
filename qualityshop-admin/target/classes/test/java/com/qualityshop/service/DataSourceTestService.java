
package com.qualityshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qualityshop.datasources.DataSourceNames;
import com.qualityshop.datasources.annotation.DataSource;
import com.qualityshop.modules.sys.entity.SysUserEntity;
import com.qualityshop.modules.sys.service.SysUserService;

/**
 * 测试多数据源
 *
 * @author changjian
 */
@Service
public class DataSourceTestService {
    @Autowired
    private SysUserService sysUserService;

    public SysUserEntity queryUser(Long userId){
        return sysUserService.selectById(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public SysUserEntity queryUser2(Long userId){
        return sysUserService.selectById(userId);
    }
}
