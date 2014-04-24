package com.sprsec.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprsec.dao.BudgetDao;
import com.sprsec.model.CategoryItem;

@Repository
public class BudgetDaoImpl implements BudgetDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<CategoryItem> getCategoryItems(int categoryType) {
		Criteria criteria = getCurrentSession().createCriteria(
				CategoryItem.class);
		criteria.add(Restrictions.eq("type", categoryType));
		return (List<CategoryItem>) criteria.list();
	}
}
