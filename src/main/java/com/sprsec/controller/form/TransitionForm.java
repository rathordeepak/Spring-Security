package com.sprsec.controller.form;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sprsec.common.CustomDateSerializer;

public class TransitionForm {

	int id;
	int categoryType;
	int categoryItem;
	@JsonSerialize(using = CustomDateSerializer.class)
	Date transDate;
	double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	public int getCategoryItem() {
		return categoryItem;
	}

	public void setCategoryItem(int categoryItem) {
		this.categoryItem = categoryItem;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
