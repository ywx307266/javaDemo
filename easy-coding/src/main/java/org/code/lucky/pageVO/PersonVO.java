package org.code.lucky.pageVO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PersonVO
{
	@NotBlank(message = "name must be not empty.")
	private String	name;

	@NotBlank(message = "email must be not empty.")
	@Email(message="请输入合法邮箱地址")
	private String	email;
	
	private String	address;
}
