package com.fox.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="studentTable")
public class student
{
	@Id
	private int id;
	private String name;
	private String address;
	private Date login;
	private boolean canWork;
	
	@OneToMany(targetEntity=telephone.class,cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private Set<telephone> phones=new HashSet<telephone>(0);
	
	public Date getLogin() {
		return login;
	}
	public void setLogin(Date login) {
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<telephone> getPhones() {
		return phones;
	}
	public void setPhones(Set<telephone> phones) {
		this.phones = phones;
	}
	
	public boolean isCanWork() {
		return canWork;
	}
	public void setCanWork(boolean canWork) {
		this.canWork = canWork;
	}
	public student() {
		
	}
	public student(int id, String name, String address,Date login) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.login=login;
	}
	@Override
	public String toString()
	{
		return "student [id=" + id + ", name=" + name + ", address=" + address + ", login=" + login + ", canWork="
				+ canWork + ", phones=" + phones + "]";
	}
	
	
}
