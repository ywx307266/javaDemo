package org.code.lucky.service;

import java.util.List;

import org.code.lucky.config.UserConfig;
import org.code.lucky.dao.DbUtils;
import org.code.lucky.entity.Person;
import org.code.lucky.pageVO.PersonVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	DbUtils		dbUtils;

	@Autowired
	UserConfig	userConfig;

	public Person addUser(PersonVO personVO)
	{
		Person person = new Person();
		BeanUtils.copyProperties(personVO, person);
		person.setHandler(userConfig.getRunUser());

		dbUtils.save(person);

		return person;
	}

	public List<Person> findAll()
	{
		return dbUtils.findAll();
	}
}
