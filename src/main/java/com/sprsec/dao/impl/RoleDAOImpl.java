package com.sprsec.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprsec.dao.RoleDAO;
import com.sprsec.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);
		return role;
	}

	public Role getRole(String loginuser) {
		Role role = (Role) getCurrentSession()
				.createQuery("from Role where name =" + loginuser).list()
				.get(0);
		return role;
	}

}
