package com.sprsec.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.navigation.Menu;
import com.sprsec.service.impl.Navigation;
import com.sprsec.service.impl.Navigation.NavEntry;

@Controller
public class LinkNavigation {

	@Autowired
	private Navigation navigation;

	@Menu(title = "home", url = "/", accessCode = "ROLE_PG_HOME", order = 1, visible = false)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView homePage(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails
				.getAuthorities();
		Map<String, NavEntry> allowAccessList = navigation.getMenuList();
		List<NavEntry> navigationEntries = new ArrayList<NavEntry>();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (allowAccessList.get(grantedAuthority.getAuthority()) != null) {
				navigationEntries.add(allowAccessList.get(grantedAuthority
						.getAuthority()));
			}
		}
		model.put("menus", navigationEntries);
		return new ModelAndView("security/home", model);
	}

	@Menu(title = "index", url = "/index", accessCode = "ROLE_PG_HOME", order = 2, visible = false)
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView indexPage() {
		return new ModelAndView("security/home");
	}

	@Menu(title = "Manager", url = "/manager/home", accessCode = "ROLE_PG_MGR_HOME", order = 3, visible = false)
	@RequestMapping(value = "/manager/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_MGR_HOME")
	public ModelAndView moderatorPage() {
		return new ModelAndView("security/moderation");
	}

	@Menu(title = "Employee", url = "/employee/home", accessCode = "ROLE_PG_EMP_HOME", order = 4, visible = false)
	@RequestMapping(value = "/employee/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_EMP_HOME")
	public ModelAndView firstAdminPage() {
		return new ModelAndView("security/admin-second");
	}

	@Menu(title = "Admin", url = "/admin/home", accessCode = "ROLE_PG_HOME", order = 5, visible = false)
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView secondAdminPage() {
		return new ModelAndView("security/admin-first");
	}

	@Menu(title = "Test", url = "/test", accessCode = "ROLE_TEST", order = 5, visible = false)
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@Secured("ROLE_TEST")
	public ModelAndView test() {
		return new ModelAndView("security/test");
	}

}
