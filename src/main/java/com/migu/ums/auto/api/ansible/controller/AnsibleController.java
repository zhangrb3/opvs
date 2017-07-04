package com.migu.ums.auto.api.ansible.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.migu.ums.auto.api.ansible.service.AnsibleService;

@Controller
@RequestMapping("/ansible")
public class AnsibleController {

	@Autowired
	AnsibleService ansibleService;
	
	@RequestMapping("/docommand")
	@ResponseBody
	public String docommand(@RequestParam("command") String command){
		String result = "";
		try {
			result= ansibleService.excute(command);
		} catch (IOException e) {
						e.printStackTrace();
		}
		return result;
	}
}
