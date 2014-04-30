package com.sprsec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.UserDAO;
import com.sprsec.model.User;
import com.sprsec.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public User getUser(String login) {
		return userDAO.getUser(login);
	}

	@Override
	public User getUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User authuser = (authentication != null && authentication
				.getPrincipal() instanceof org.springframework.security.core.userdetails.User) ? (org.springframework.security.core.userdetails.User) authentication
				.getPrincipal() : null;
		User user = new User();
		user.setName(authuser.getUsername());
		return user == null ? null : user;
	}

}
