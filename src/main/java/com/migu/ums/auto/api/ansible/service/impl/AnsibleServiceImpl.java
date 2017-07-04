package com.migu.ums.auto.api.ansible.service.impl;

import java.io.InputStreamReader;

import java.io.BufferedReader;

import java.io.InputStream;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.migu.ums.auto.api.ansible.service.AnsibleService;

@Service
public class AnsibleServiceImpl implements AnsibleService {

	/* (non-Javadoc)
	 * @see com.migu.ums.auto.api.ansible.service.impl.AnsibleService#excute(java.lang.String)
	 */
	@Override
	public  String excute(String command) throws IOException {

		Process process = Runtime.getRuntime().exec(command);
		String result = getResult(process.getInputStream())+getResult(process.getErrorStream());
		System.out.println(result);
		System.out.println("finish");
		return result;

	}

	/* (non-Javadoc)
	 * @see com.migu.ums.auto.api.ansible.service.impl.AnsibleService#getResult(java.io.InputStream)
	 */
	@Override
	public String getResult(InputStream inputStream) {
		if (inputStream == null) {

			System.out.println("input null");

			return "no result";

		}

		String line = "";
		StringBuffer result = new StringBuffer();

		try

		{
			BufferedReader input = new BufferedReader(new InputStreamReader(
					inputStream));
			while ((line = input.readLine()) != null) {
				result.append(line);
			}

		} catch (IOException e1) {

			System.out.println("Êä³öÁ÷Ê§°Ü" + e1);

			e1.printStackTrace();

		} finally {

			try {
				if (inputStream != null) {
					inputStream.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return result.toString();
	}
}
