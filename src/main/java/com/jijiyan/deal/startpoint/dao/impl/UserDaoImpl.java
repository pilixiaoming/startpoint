package com.jijiyan.deal.startpoint.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.jijiyan.deal.startpoint.dao.UserDao;
import com.jijiyan.deal.startpoint.model.User;

@Component
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
