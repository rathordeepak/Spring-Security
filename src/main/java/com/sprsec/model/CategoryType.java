package com.sprsec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblcategorytype")
public class CategoryType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblcategorytype_cid_gen")
	@SequenceGenerator(name = "tblcategorytype_cid_gen", sequenceName = "tblcategorytype_cid_seq")
	@Column(name = "cid")
	private Integer id;

	private String description;

	private String code;

	public Integer getId() {
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
