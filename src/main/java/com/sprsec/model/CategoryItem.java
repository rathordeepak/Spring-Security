package com.sprsec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblcategorytype")
public class CategoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblcategorytype_cid_gen")
	@SequenceGenerator(name = "tblcategorytype_cid_gen", sequenceName = "tblcategorytype_cid_seq")
	@Column(name = "cid")
	private Integer id;

	private String description;

	@ManyToOne(targetEntity=CategoryType.class)
	@JoinColumn(name = "type")
	private CategoryType type;

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

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

}
