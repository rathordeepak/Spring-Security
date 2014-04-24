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

import com.sprsec.common.CommonUtils;
import com.sprsec.service.UserService;

@Controller("profileInfoController")
public class ProfileInfoController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "profileinfo", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView secondAdminPage(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getUser());
		CommonUtils.headerInfo(request, model);
		return new ModelAndView("profileinfo", model);
	}

}
