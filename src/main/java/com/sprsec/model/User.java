package com.sprsec.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fk_tbluser")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fk_tbluser_cid_gen")
	@SequenceGenerator(name = "fk_tbluser_cid_gen", sequenceName = "fk_tbluser_cid_seq")
	@Column(name = "cid")
	private Integer id;

	private String name;

	private String password;

	private boolean isAdmin;

	private String email;

	@Column(name = "lastloginfaildate")
	private Date lastLoginFailDate;

	@Column(name = "lastlogintime")
	private Date lastLoginTime;

	private boolean isPwdExpired;

	@Column(name = "prevlogintime")
	private Date prevLoginTime;

	private boolean isSystemDisabled;

	@Column(name = "ipaddress")
	private String ipAddress;

	private boolean signupUser;

	private String theme;

	private boolean deleted;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "fk_user_roles", joinColumns = { @JoinColumn(name = "userid", referencedColumnName = "cid") }, inverseJoinColumns = { @JoinColumn(name = "roleid", referencedColumnName = "cid") })
	private Role role;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLoginFailDate() {
		return lastLoginFailDate;
	}

	public void setLastLoginFailDate(Date lastLoginFailDate) {
		this.lastLoginFailDate = lastLoginFailDate;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public boolean isPwdExpired() {
		return isPwdExpired;
	}

	public void setPwdExpired(boolean isPwdExpired) {
		this.isPwdExpired = isPwdExpired;
	}

	public Date getPrevLoginTime() {
		return prevLoginTime;
	}

	public void setPrevLoginTime(Date prevLoginTime) {
		this.prevLoginTime = prevLoginTime;
	}

	public boolean isSystemDisabled() {
		return isSystemDisabled;
	}

	public void setSystemDisabled(boolean isSystemDisabled) {
		this.isSystemDisabled = isSystemDisabled;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean isSignupUser() {
		return signupUser;
	}

	public void setSignupUser(boolean signupUser) {
		this.signupUser = signupUser;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
