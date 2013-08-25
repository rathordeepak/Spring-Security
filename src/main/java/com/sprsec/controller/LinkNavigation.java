package com.sprsec.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.navigation.Menu;

@Controller
public class LinkNavigation {

	@Menu(title = "home", accessCode = "ROLE_PG_HOME", order = 1, visible = false)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView homePage() {
		return new ModelAndView("security/home");
	}

	@Menu(title = "index", accessCode = "ROLE_PG_HOME", order = 2, visible = false)
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView indexPage() {
		return new ModelAndView("security/home");
	}

	@Menu(title = "Manager", accessCode = "ROLE_PG_MGR_HOME", order = 3, visible = false)
	@RequestMapping(value = "/manager/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_MGR_HOME")
	public ModelAndView moderatorPage() {
		return new ModelAndView("security/mgr-home");
	}

	@Menu(title = "Employee", accessCode = "ROLE_PG_EMP_HOME", order = 4, visible = false)
	@RequestMapping(value = "/employee/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_EMP_HOME")
	public ModelAndView firstAdminPage() {
		return new ModelAndView("security/emp-home");
	}

	@Menu(title = "Admin", accessCode = "ROLE_PG_HOME", order = 5, visible = false)
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView secondAdminPage() {
		return new ModelAndView("security/admin-home");
	}

	@Menu(title = "Test", accessCode = "ROLE_TEST", order = 5, visible = false)
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@Secured("ROLE_TEST")
	public ModelAndView test() {
		return new ModelAndView("security/test");
	}

}
