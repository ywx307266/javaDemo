package org.code.lucky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer	id;

	private String	name;

	private String	email;

	private String	handler;

	private String	address;
}
