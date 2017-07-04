package com.migu.ums.auto.api.ansible.service;

import java.io.IOException;
import java.io.InputStream;

public interface AnsibleService {

	public abstract String excute(String command) throws IOException;

	public abstract String getResult(InputStream inputStream);

}