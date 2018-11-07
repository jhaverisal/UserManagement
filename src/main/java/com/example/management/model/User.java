package com.example.management.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;

	@NotNull
	private String fname;

	@NotNull
	private String lname;

	@Column(unique=true,nullable=false)
	private String emailId;

	private String address;

	@Column(unique=true,nullable=false)
	private String userName;

	@NotNull
	private String password;

	@ManyToOne //(mappedBy="users", cascade= CascadeType.ALL)
	private UserType type;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "user_group",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "group_id")}
			)
	private Set<Group> groups=new HashSet<>();

	//@JsonIgnore
	//@OneToMany(mappedBy = "userId", cascade=CascadeType.ALL)
	//private List<UserGroup> userGroups;

	public User()
	{}
	
	
	
	public User(int userId, @NotNull String fname, @NotNull String lname, String emailId, String address,
			String userName, @NotNull String password, UserType type, Set<Group> groups) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.groups = groups;
	}



	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Set<Group> getGroups() {
		return groups;
	}


	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}


	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

}
