package com.sprsec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.sprsec.common.CustomDateSerializer;

@Entity
@Table(name = "tbltransition")
public class Transition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbltransition_cid_gen")
	@SequenceGenerator(name = "tbltransition_cid_gen", sequenceName = "tbltransition_cid_seq")
	@Column(name = "cid")
	private Integer id;

	@ManyToOne(targetEntity = CategoryType.class)
	@JoinColumn(name = "categorytype")
	@JsonIgnore
	private CategoryType categoryType;

	@ManyToOne(targetEntity = CategoryItem.class)
	@JoinColumn(name = "categoryitem")
	private CategoryItem categoryItem;

	@DateTimeFormat(pattern = "dd MMM yyyy")
	@JsonSerialize(using = CustomDateSerializer.class)
	@Column(name = "transDate")
	private Date transDate;

	private double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public CategoryItem getCategoryItem() {
		return categoryItem;
	}

	public void setCategoryItem(CategoryItem categoryItem) {
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
