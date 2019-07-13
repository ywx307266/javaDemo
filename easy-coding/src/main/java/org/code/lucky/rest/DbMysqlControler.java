package org.code.lucky.rest;

import javax.validation.Valid;

import org.code.lucky.entity.Person;
import org.code.lucky.pageVO.PersonVO;
import org.code.lucky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class DbMysqlControler
{
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public Object addRecord(@RequestBody @Valid PersonVO person)
	{
		return userService.addUser(person);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Person> getAllUsers()
	{
		return userService.findAll();
	}
}
