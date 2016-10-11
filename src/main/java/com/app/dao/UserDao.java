package com.app.dao;

import java.util.List;

import com.app.domain.entity.User;

public interface UserDao {
	
	List<User> findAll();
}
