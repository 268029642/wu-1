package com.whp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.whp.service.UserService;
import com.whp.vo.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/get/{uid}")
	@HystrixCommand(fallbackMethod="getFallback")
	public User get(@PathVariable("uid") int uid) {
		return userService.findById(uid);
	}
	
	@GetMapping("/list")
	@HystrixCommand(fallbackMethod="listFallback")
	public List<User> list() {
		return userService.findAll();
	}
	
	public User getFallback(@PathVariable("uid") int uid) {
		User user = new User();
		user.setUid(9999);
		user.setUsername("[error] user-provider");
		user.setAddress("user get fallback");
		return user;
	}
	
	public List<User> listFallback() {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setUid(9999);
		user.setUsername("[error] user-provider");
		user.setAddress("user list fallback");
		list.add(user);
		return list;
	}
}
