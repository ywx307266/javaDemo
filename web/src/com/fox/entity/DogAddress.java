package com.fox.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="add_dog")
public class DogAddress
{
	@Id
	private int idx;
	
	private int dogid;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addid")
	private Address add;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public int getDogid() {
		return dogid;
	}
	public void setDogid(int dogid) {
		this.dogid = dogid;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	
	
}
