package com.sprsec.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.UserDAO;
import com.sprsec.model.AccessRights;
import com.sprsec.model.Role;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {

		com.sprsec.model.User domainUser = userDAO.getUser(login);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new User(domainUser.getName(), domainUser.getPassword(),
				enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, getAuthorities(domainUser.getRole()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(role
				.getUserRoles());
		return authList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			Set<AccessRights> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (AccessRights feature : roles) {
			String featureCode = "ROLE_" + feature.getCode().toUpperCase();
			authorities.add(new SimpleGrantedAuthority(featureCode));
		}
		return authorities;
	}

}
