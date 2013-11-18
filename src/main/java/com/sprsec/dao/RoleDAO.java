package com.sprsec.dao;

import com.sprsec.model.Role;

public interface RoleDAO {
	
	public Role getRole(int id);

	public Role getRole(String rolename);

}
