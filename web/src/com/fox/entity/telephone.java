package com.fox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="telephone")
public class telephone
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idx;
	private String phonenumber;
	private String area;
	private int userid;
	
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	

	public telephone( String telephonenumber, String area) {
		this.phonenumber = telephonenumber;
		this.area = area;
	}

	public telephone() {
		// TODO Auto-generated constructor stub
	}
	
}
