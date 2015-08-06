package com.jijiyan.deal.startpoint.model;

import javax.inject.Inject;

import org.junit.Test;

import com.jijiyan.deal.startpoint.service.UserService;
import com.jijiyan.deal.startpoint.test.BaseUnitTest;

public class PersonTest extends BaseUnitTest{
	
	@Inject
	private UserService userService;
	
	@Test
	public void savePerson() {
		userService.insertUser(new User("帅呆了sdfvsd", "123456", "yuandaxia@gmail.com", "I am good"));
	}
}
