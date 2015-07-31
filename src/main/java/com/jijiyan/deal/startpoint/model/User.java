package com.jijiyan.deal.startpoint.model;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class User {
	@NotNull(message="用户名不为空哥们")
	@NotEmpty(message="用户名不为空哥们")
	private String name;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
