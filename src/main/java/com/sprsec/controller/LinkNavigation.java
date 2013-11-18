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
import com.sprsec.service.impl.Navigation;

@Controller
public class LinkNavigation {

	@Autowired
	private Navigation navigation;

	@Menu(title = "home", url = "/", accessCode = "ROLE_PG_HOME", order = 1, visible = false)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView homePage(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "index", url = "/index", accessCode = "ROLE_PG_HOME", order = 2, visible = false)
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView indexPage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Manager", url = "/manager/home", accessCode = "ROLE_PG_MGR_HOME", order = 3, visible = false)
	@RequestMapping(value = "/manager/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_MGR_HOME")
	public ModelAndView moderatorPage() {
		return new ModelAndView("moderation");
	}

	@Menu(title = "Employee", url = "/employee/home", accessCode = "ROLE_PG_EMP_HOME", order = 4, visible = false)
	@RequestMapping(value = "/employee/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_EMP_HOME")
	public ModelAndView firstAdminPage() {
		return new ModelAndView("admin-second");
	}

	@Menu(title = "Admin", url = "/admin/home", accessCode = "ROLE_PG_HOME", order = 5, visible = false)
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView secondAdminPage() {
		return new ModelAndView("admin-first");
	}

	@Menu(title = "Test", url = "/test", accessCode = "ROLE_TEST", order = 5, visible = false)
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@Secured("ROLE_TEST")
	public ModelAndView test() {
		return new ModelAndView("test");
	}

}
