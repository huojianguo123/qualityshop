package com.qualityshop.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.common.exception.RRException;
import com.qualityshop.common.validator.Assert;
import com.qualityshop.dao.UserDao;
import com.qualityshop.entity.TokenEntity;
import com.qualityshop.entity.UserEntity;
import com.qualityshop.form.LoginForm;
import com.qualityshop.service.TokenService;
import com.qualityshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private TokenService tokenService;

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public Map<String, Object> login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		/*if(!user.getPassword().equals(DigestUtils.md5Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}*/
		if(!user.getPassword().equals(form.getPassword())){
			throw new RRException("手机号或密码错误");
		}

		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(user.getUserId());

		Map<String, Object> map = new HashMap<>(2);
		map.put("token", tokenEntity.getToken());
		map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

		return map;
	}







}
