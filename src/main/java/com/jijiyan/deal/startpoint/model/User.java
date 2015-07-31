package com.jijiyan.deal.startpoint.model;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class User {
	@NotNull(message = "用户名不为空哥们")
	@NotEmpty(message = "用户名不为空哥们")
	private String name;
	private String email;
	private String title;

	public User() {
	}

	public User(String name, String email, String title) {
		this.name = name;
		this.email = email;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
