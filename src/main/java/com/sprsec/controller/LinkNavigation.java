package com.sprsec.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkNavigation {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView homePage() {
		return new ModelAndView("security/home");
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView indexPage() {
		return new ModelAndView("security/home");
	}

	@RequestMapping(value = "/manager/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_MGR_HOME")
	public ModelAndView moderatorPage() {
		return new ModelAndView("security/mgr-home");
	}

	@RequestMapping(value = "/employee/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_EMP_HOME")
	public ModelAndView firstAdminPage() {
		return new ModelAndView("security/emp-home");
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView secondAdminPage() {
		return new ModelAndView("security/admin-home");
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@Secured("ROLE_TEST")
	public ModelAndView test() {
		return new ModelAndView("security/test");
	}

}
