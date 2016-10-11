package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.UserDao;
import com.app.domain.entity.User;
import com.app.service.UserService;	

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public List<User> findAllUser() {
		return userDao.findAll();
	}

}
