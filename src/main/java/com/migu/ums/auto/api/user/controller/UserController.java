package com.migu.ums.auto.api.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.migu.ums.auto.api.user.domain.User;
import com.migu.ums.auto.api.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;

	@RequestMapping("/userList")
	public ModelAndView getList(Map<String, Object> model) {
		ModelAndView mv = new ModelAndView("userList"); // 返回的view就是templetes下面文件的名称
		model.put("time", new Date());
		model.put("message", "33333");
		List<User> users = new ArrayList<User>();
		users = findAll();
		System.out.println(users.size());
		mv.addObject("title", "Spring MVC And Freemarker");
		mv.addObject("content", " Hello world ， test my first spring mvc ! ");
		mv.addObject("users", users);
		return mv;
	}

	@RequestMapping("/adduser")
	public ModelAndView adduser(Map<String, Object> model) {
		ModelAndView mv = new ModelAndView("adduser");
		return mv;
	}

	@RequestMapping("/updateuser/{id}")
	public ModelAndView updateuser(@PathVariable() String id,
			Map<String, Object> model) {
		ModelAndView mv = new ModelAndView("update"); 
		User user = userservice.findOne(id);
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/findbyname")
	@ResponseBody
	public User register(@RequestParam("username") String username) {
		User user = userservice.findOneByUsername(username);
		return user;
	}

	@RequestMapping("/findone/{id}")
	@ResponseBody
	public User findOne(@PathVariable() String id) {
		return userservice.findOne(id);
	}

	@RequestMapping("/findall")
	@ResponseBody
	public List<User> findAll() {
		return userservice.findAll();
	}

	@RequestMapping("/add")
	@ResponseBody
	public ModelAndView add(
			@RequestParam(value = "username", required = false) String name,
			@RequestParam(value = "age", required = false) int age,
			ModelAndView mv) {
		User user = new User();
		user.setAge(age);
		user.setUsername(name);
		userservice.create(user);
		mv.setViewName("redirect:/user/userList");
		return mv;
	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteByPrimaryKey(@PathVariable String id,
			ModelAndView mv) {
		userservice.delete(id);
		mv.setViewName("redirect:/user/userList");
		return mv;
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	@ResponseBody
	public String deleteByExample() {
		userservice.deleteAll();
		return "success";
	}

	@RequestMapping("/update")
	@ResponseBody
	public ModelAndView update(
			@RequestParam("id") String id,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam("age") Integer age, ModelAndView mv) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setAge(age);
		userservice.update(user);
		mv.setViewName("redirect:/user/userList");
		return mv;
	}

}
