package com.jijiyan.deal.startpoint.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jijiyan.deal.startpoint.dao.UserDao;
import com.jijiyan.deal.startpoint.model.User;
import com.jijiyan.deal.startpoint.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Inject
	 private UserDao userDao;

	@Override
	@Transactional
	public void insertUser(User user) {
		userDao.insertUser(user);		
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
