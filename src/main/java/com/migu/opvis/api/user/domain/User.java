package com.migu.opvis.api.user.domain;


import com.migu.opvis.commons.domain.AbstractEntity;


public class User extends AbstractEntity {
	
	private String username;
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
