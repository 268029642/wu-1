package com.whp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whp.dao.UserDao;
import com.whp.service.UserService;
import com.whp.vo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public User findById(Integer uid) {
		return userDao.getById(uid);
	}

	@Override
	public List<User> findAll() {
		return userDao.getAll();
	}

}
