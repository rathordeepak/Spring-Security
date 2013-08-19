package com.sprsec.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblrole")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblrole_cid_gen")
	@SequenceGenerator(name = "tblrole_cid_gen", sequenceName = "tblrole_cid_seq")
	@Column(name = "cid")
	private Integer id;

	private String name;

	private Date lastupdatedon;

	private boolean isprivate;

	private boolean system;

	private boolean description;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_role_accessrights", joinColumns = { @JoinColumn(name = "roleid", referencedColumnName = "cid") }, inverseJoinColumns = { @JoinColumn(name = "featureid", referencedColumnName = "cid") })
	private Set<AccessRights> userRoles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastupdatedon() {
		return lastupdatedon;
	}

	public void setLastupdatedon(Date lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}

	public boolean isIsprivate() {
		return isprivate;
	}

	public void setIsprivate(boolean isprivate) {
		this.isprivate = isprivate;
	}

	public boolean isSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}

	public boolean isDescription() {
		return description;
	}

	public void setDescription(boolean description) {
		this.description = description;
	}

	public Set<AccessRights> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<AccessRights> userRoles) {
		this.userRoles = userRoles;
	}

}
