package com.whp.service;

import java.util.List;

import com.whp.vo.User;

public interface UserService {

	User findById(Integer uid);
	
	List<User> findAll();
}
