package com.migu.opvis.api.user.service;

import com.migu.opvis.api.user.domain.User;
import com.migu.opvis.commons.service.BaseService;


public interface UserService extends BaseService<User> {
	User findOneByUsername(String username);
	
}
