package com.jijiyan.deal.startpoint.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Maps;
import com.jijiyan.deal.startpoint.model.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	private static Map<String, User> users = Maps.newHashMap();
	static{
		users.put("daxia", new User("daxia", "123456", "yuandaxia@gmail.com", "Software Engineer"));
		users.put("xiaoxia", new User("xiaoxia", "123456", "xiaoxia@gmail.com", "Manager"));
		users.put("xiake", new User("xiake", "123456", "xiake@gmail.com", "President"));
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
	public String addSubmit(@Validated User user, BindingResult br, MultipartFile file, HttpServletRequest req) throws IOException {
		String realPath = req.getSession().getServletContext().getRealPath("/res/upload");
		System.out.println(realPath);
		File f = new File(realPath+"/"+file.getOriginalFilename());
		FileUtils.copyInputStreamToFile(file.getInputStream(), f);
		if (br.hasErrors()) {
			return "user/add";
		}
		System.out.println(file.getName() + ", " + file.getOriginalFilename() + ", " + file.getContentType());
		users.put(user.getName(), user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String show(@PathVariable String name, Model model) {
		model.addAttribute(users.get(name));
		return "user/show";
	}
	
	//return json 
	@RequestMapping(value = "/{name}", method = RequestMethod.GET,params="jjj")
	@ResponseBody
	public User show(@PathVariable String name) {
		return users.get(name);
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
	
	@RequestMapping(value = "/{name}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable String name) {
		users.remove(name);
		return "redirect:/user/users";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String name, String password, HttpSession session) throws Exception {
		if(!users.containsKey(name)){
			throw new Exception("User not found");
		}
		User u = users.get(name);
		if(!u.getPassword().equals(password)){
			throw new Exception("password wrong");
		}
		session.setAttribute("loginUser", u);
		return "redirect:/user/users";
	}
	
//	@ExceptionHandler(value={Exception.class})
//	public String handluerException(Exception e, HttpServletRequest req){
//		req.setAttribute("e", e);
//		return "error";
//	}
	
}
