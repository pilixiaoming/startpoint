package com.jijiyan.deal.startpoint.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.jijiyan.deal.startpoint.model.User;

public interface UserService {
	void insertUser(User user);
	List<User> findAllUsers();
}
