package com.example.management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="group_details")
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int grpId;
	
	
	@Column(unique=true,nullable=false)
	private String groupName;
	
	private String groupDesc;
	
	/* @ManyToMany(mappedBy = "groups",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    private Set<User> users=new HashSet<User>();*/
	 
	@ManyToMany(mappedBy = "groups",cascade = CascadeType.MERGE)
	private Set<User> users;
	
	
	 public Group()
	 {}

	 
	 public Group(@NotNull int grpId, String groupName, String groupDesc, Set<User> users) {
		super();
		this.grpId = grpId;
		this.groupName = groupName;
		this.groupDesc = groupDesc;
		this.users = users;
	}


	public int getGrpId() {
			return grpId;
		}


		public void setGrpId(int grpId) {
			this.grpId = grpId;
		}

	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	} 

}
