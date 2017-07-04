package com.migu.ums.auto.api.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.migu.ums.auto.api.user.dao.UserMapper;
import com.migu.ums.auto.api.user.domain.User;
import com.migu.ums.auto.api.user.service.UserService;
import com.migu.ums.auto.commons.dao.BaseDao;
import com.migu.ums.auto.commons.service.BaseServiceImpl;



@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User,User>
		implements UserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public User findOneByUsername(String username) {
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
