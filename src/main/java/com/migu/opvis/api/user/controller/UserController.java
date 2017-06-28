package com.migu.opvis.api.user.controller;

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

import com.migu.opvis.api.user.domain.User;
import com.migu.opvis.api.user.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userserviceimpl;

	@RequestMapping("/userList")
	public ModelAndView getList(Map<String,Object> model){
		ModelAndView mv = new ModelAndView("user_list"); //返回的view就是templetes下面文件的名称    
        model.put("time",new Date());    
        model.put("message","33333");    
        List<User> users = new ArrayList<User>();  
        users = findAll();
        System.out.println(users.size());  
        mv.addObject("title", "Spring MVC And Freemarker");    
        mv.addObject("content", " Hello world ， test my first spring mvc ! ");    
        mv.addObject("users",users);  
        return mv;    
	}
	@RequestMapping("/findbyname")
	@ResponseBody
	public User register(@RequestParam("username") String username) {
		User user = userserviceimpl.findOneByUsername(username);
		return user;
	}

	@RequestMapping("/findone/{id}")
	@ResponseBody
	public User findOne(@PathVariable() String id) {
		return userserviceimpl.findOne(id);
	}

	@RequestMapping("/findall")
	@ResponseBody
	public List<User> findAll() {
		return userserviceimpl.findAll();
	}

	@RequestMapping("/add")
	@ResponseBody
	public User add(
			@RequestParam(value = "username", required = false) String name,
			@RequestParam(value = "age", required = false) int age) {
		User user = new User();
		user.setAge(age);
		user.setUsername(name);
		return userserviceimpl.create(user);
	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	@ResponseBody
	public int deleteByPrimaryKey(@PathVariable String id) {
		userserviceimpl.delete(id);
		return 1;
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	@ResponseBody
	public int deleteByExample(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "age", required = false) int age) {
		User user = new User();
		user.setUsername(username);
		user.setAge(age);
		userserviceimpl.deleteAll();
		return 1;

	}

	@RequestMapping("/update")
	@ResponseBody
	public int update(
			@RequestParam("id") String id,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam("age") Integer age) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setAge(age);
		userserviceimpl.update(user);
		return 1;
	}

}
