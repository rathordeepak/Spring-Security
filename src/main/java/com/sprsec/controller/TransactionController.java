package com.sprsec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.common.CommonUtils;
import com.sprsec.controller.form.TransitionForm;
import com.sprsec.model.Transition;
import com.sprsec.service.PublicManager;
import com.sprsec.service.UserService;

@Controller
public class TransactionController {

	@Autowired
	private UserService userService;

	@Autowired
	private PublicManager publicManager;

	@RequestMapping(value = "transaction", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView homePage(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getUser());
		CommonUtils.headerInfo(request, model);
		return new ModelAndView("transaction", model);
	}

	@RequestMapping(value = "transition", method = RequestMethod.POST)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	Map<String, Object> saveTransition(HttpServletRequest request,
			@RequestBody TransitionForm transitionForm) {
		Map<String, Object> model = new HashMap<String, Object>();
		Transition transition = publicManager.getObjectOrNull(Transition.class,
				transitionForm.getId());
		if (transition == null) {
			transition = new Transition();
		}
		transition.setAmount(transitionForm.getAmount());
		transition.setTransDate(transitionForm.getTransDate());
		publicManager.saveObject(transition);
		return model;
	}
}
