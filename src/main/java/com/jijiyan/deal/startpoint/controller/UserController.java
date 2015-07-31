package com.jijiyan.deal.startpoint.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Maps;
import com.jijiyan.deal.startpoint.model.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	Map<String, User> users = Maps.newHashMap();
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
		
		users.put("yuandaxia", new User("袁大侠"));
		users.put("yuanxiaoxia", new User("袁小侠"));
		users.put("yuanxiake", new User("袁侠客"));
		model.addAttribute("users", users);
		return "user/list";
	}
	
/*
 * version 1
 * @RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String adda(User user) {
		users.put(user.getName(), user);
		return "redirect:/user/users";
	}
 * 
 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("user")User user) {
		return "user/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSubmit(@Validated User user, BindingResult br) {
		if (br.hasErrors()) {
			return "user/add";
		}
		users.put(user.getName(), user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String show(User user) {
		users.put(user.getName(), user);
		return "redirect:/user/users";
	}
}
