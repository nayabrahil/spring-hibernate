package com.app.service;

import java.util.List;
import com.app.domain.entity.User;

public interface UserService {
	
	List<User> findAllUser();

	void save(User user);
}
