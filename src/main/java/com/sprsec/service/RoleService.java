package com.sprsec.service;

import com.sprsec.model.Role;

public interface RoleService {
	
	public Role getRole(int id);
	
	public Role getRole(String rolename);

}
