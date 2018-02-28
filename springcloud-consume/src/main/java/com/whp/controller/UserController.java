package com.whp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whp.service.UserClientService;
import com.whp.vo.User;

@RestController
@RequestMapping("/consume/user")
public class UserController {

	@Autowired
	private UserClientService userClientService;
	
	@GetMapping("/get/{uid}")
	public User get(@PathVariable("uid") long uid) {
		return userClientService.get(uid);
	}
	@GetMapping("/list")
	public List<User> list() {
		return userClientService.list();
	}
}
