package com.migu.ums.auto.api.user.service;

import com.migu.ums.auto.api.user.domain.User;
import com.migu.ums.auto.commons.service.BaseService;


public interface UserService extends BaseService<User> {
	User findOneByUsername(String username);
	
}
