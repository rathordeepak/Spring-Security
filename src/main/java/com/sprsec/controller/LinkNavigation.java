package com.sprsec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.navigation.Menu;
import com.sprsec.service.UserService;
import com.sprsec.service.impl.Navigation;

@Controller
public class LinkNavigation {

	@Autowired
	private Navigation navigation;
	
	@Autowired
	private UserService userService;

	@Menu(title = "home", url = "/", accessCode = "ROLE_PG_HOME", order = 1, visible = false)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView homePage(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menus", navigation.displayMenuList());
		model.put("user", userService.getUser());
		return new ModelAndView("home", model);
	}

	@Menu(title = "index", url = "/index", accessCode = "ROLE_PG_HOME", order = 2, visible = false)
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView indexPage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menus", navigation.displayMenuList());
		model.put("user", userService.getUser());
		return new ModelAndView("home", model);
	}

}
