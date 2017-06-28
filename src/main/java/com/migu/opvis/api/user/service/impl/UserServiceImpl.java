package com.migu.opvis.api.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.migu.opvis.api.user.dao.UserMapper;
import com.migu.opvis.api.user.domain.User;
import com.migu.opvis.api.user.service.UserService;
import com.migu.opvis.commons.dao.BaseDao;
import com.migu.opvis.commons.service.BaseServiceImpl;


@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User,User>
		implements UserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public User findOneByUsername(String username) {
		Assert.notNull(username);
		User user = new User();
		user.setUsername(username);
		List<User> userList = userDao.selectByExample(user);
		return userList.get(0);
	}

	
	@Override
	protected BaseDao<User, User, String> getDao() {
		return userDao;
	}


}
