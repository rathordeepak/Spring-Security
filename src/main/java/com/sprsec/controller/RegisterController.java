package com.sprsec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.service.PublicManager;
import com.sprsec.service.RoleService;

@Controller("registerController")
public class RegisterController {

	@Autowired
	private PublicManager publicManager;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "register.html", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("register", model);
	}

	@RequestMapping(value = "register.html", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> saveRegister(HttpServletRequest request,
			@RequestBody Map<String, Object> inputs) {
		Map<String, Object> model = new HashMap<String, Object>();
		/*User user = new User();
		user.setName(inputs.get("name").toString());
		user.setPassword(inputs.get("password").toString());
		publicManager.saveObject(user);
		Role role = roleService.getRole("employee");
		UserRole userRole = new UserRole();
		userRole.setUserid(user);
		userRole.setRoleid(role);
		publicManager.saveObject(userRole);*/
		return model;
	}
}
