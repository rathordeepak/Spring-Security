package com.sprsec.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("profileInfoController")
public class ProfileInfoController {

	@RequestMapping(value = "profileinfo", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView secondAdminPage() {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("profileinfo", model);
	}

}
