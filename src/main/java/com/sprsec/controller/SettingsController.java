package com.sprsec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.common.CommonUtils;
import com.sprsec.model.CategoryType;
import com.sprsec.service.BudgetManager;
import com.sprsec.service.PublicManager;
import com.sprsec.service.UserService;

@Controller
public class SettingsController {

	@Autowired
	private UserService userService;

	@Autowired
	private PublicManager publicManager;

	@Autowired
	private BudgetManager budgetManager;

	@RequestMapping(value = "settings", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView homePage(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getUser());
		CommonUtils.headerInfo(request, model);
		return new ModelAndView("settings", model);
	}

	@RequestMapping(value = "category-type", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	Map<String, Object> categoryType(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categoryTypes", publicManager.getObjects(CategoryType.class));
		return model;
	}

	@RequestMapping(value = "category-type", method = RequestMethod.POST)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	Map<String, Object> saveCategoryType(HttpServletRequest request,
			@RequestBody CategoryType categoryType) {
		Map<String, Object> model = new HashMap<String, Object>();
		publicManager.saveObject(categoryType);
		return model;
	}

	@RequestMapping(value = "category-type/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	Map<String, Object> deleteCategoryType(HttpServletRequest request,
			@PathVariable("id") int id) {
		Map<String, Object> model = new HashMap<String, Object>();
		publicManager.removeObject(CategoryType.class, id);
		return model;
	}

	@RequestMapping(value = "category-item", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	Map<String, Object> categoryItems(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categoryTypes", publicManager.getObjects(CategoryType.class));
		return model;
	}

	@RequestMapping(value = "category-item/{type}", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	Map<String, Object> categoryItem(HttpServletRequest request,
			@PathVariable("type") int type) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categoryTypes", budgetManager.getCategoryItems(type));
		return model;
	}

}
