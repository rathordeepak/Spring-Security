package com.sprsec.dao;

import java.util.List;

import com.sprsec.model.CategoryItem;

public interface BudgetDao {

	List<CategoryItem> getCategoryItems(int categoryType);

}
