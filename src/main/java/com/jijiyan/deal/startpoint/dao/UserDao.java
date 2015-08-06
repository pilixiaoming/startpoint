package com.jijiyan.deal.startpoint.dao;

import java.util.List;
import com.jijiyan.deal.startpoint.model.User;

public interface UserDao {
	void insertUser(User user);
	List<User> findAllUsers();
}
