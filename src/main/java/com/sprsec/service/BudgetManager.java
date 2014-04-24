package com.sprsec.service;

import java.util.List;

import com.sprsec.model.CategoryItem;

public interface BudgetManager {

	public List<CategoryItem> getCategoryItems(int categoryType);
}
