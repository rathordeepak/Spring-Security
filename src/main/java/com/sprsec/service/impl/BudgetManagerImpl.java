package com.sprsec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.BudgetDao;
import com.sprsec.model.CategoryItem;
import com.sprsec.service.BudgetManager;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BudgetManagerImpl implements BudgetManager {

	@Autowired
	private BudgetDao budgetDao;

	@Override
	public List<CategoryItem> getCategoryItems(int categoryType) {
		return budgetDao.getCategoryItems(categoryType);
	}

}
