package com.fox.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "dog")
public class Dog
{
	@Id
	private int		id;
	private String	name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "dogId")
	private Set<DogAddress> dogAddress;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Dog() {
	}

	public Set<DogAddress> getDogAddress()
	{
		return dogAddress;
	}

	public void setDogAddress(Set<DogAddress> dogAddress)
	{
		this.dogAddress = dogAddress;
	}

}
