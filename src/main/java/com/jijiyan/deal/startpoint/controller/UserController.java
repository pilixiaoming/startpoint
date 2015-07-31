package com.jijiyan.deal.startpoint.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Maps;
import com.jijiyan.deal.startpoint.model.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	private static Map<String, User> users = Maps.newHashMap();
	static{
		users.put("daxia", new User("daxia", "yuandaxia@gmail.com", "Software Engineer"));
		users.put("xiaoxia", new User("xiaoxia", "xiaoxia@gmail.com", "Manager"));
		users.put("xiake", new User("xiake", "xiake@gmail.com", "President"));
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
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
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String show(@PathVariable String name, Model model) {
		model.addAttribute(users.get(name));
		return "user/show";
	}
	
	@RequestMapping(value = "/{name}/update", method = RequestMethod.GET)
	public String update(@PathVariable String name, Model model) {
		model.addAttribute(users.get(name));
		return "user/update";
	}
	
	@RequestMapping(value = "/{name}/update", method = RequestMethod.POST)
	public String updateSubmit(@PathVariable String name, User user) {
		users.put(name, user);
		return "redirect:/user/users";
	}
}
