package com.sprsec.controller.form;

import java.io.Serializable;

public class CategoryItemForm implements Serializable {

	private Integer id;

	private String description;
	private int type;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
