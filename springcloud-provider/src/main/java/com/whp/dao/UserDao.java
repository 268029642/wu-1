package com.whp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.whp.vo.User;

@Mapper
public interface UserDao {

	User getById(Integer uid);
	
	List<User> getAll();
}
