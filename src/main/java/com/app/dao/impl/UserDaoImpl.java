package com.app.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.domain.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<User> findAll() {
		Session session = sessionFactory.openSession();
		List<User> userList = session.createQuery("from User c").getResultList();
    	session.close();
    	return userList;
	}
    
	public void insertUser(User user){
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}
}
