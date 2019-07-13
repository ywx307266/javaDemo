package com.fox.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class globalProperties
{
	@Value("${driverClass}")
	private String dataBaseDrvier;
	
	@Value("${jdbcUrl}")
	private String dataBaseUrl;
	
	@Value("${user}")
	private String dataBaseUser;
	
	@Value("${password}")
	private String dataBasePassword;

	public String getDataBaseDrvier()
	{
		return dataBaseDrvier;
	}

	public void setDataBaseDrvier(String dataBaseDrvier)
	{
		this.dataBaseDrvier = dataBaseDrvier;
	}

	public String getDataBaseUrl()
	{
		return dataBaseUrl;
	}

	public void setDataBaseUrl(String dataBaseUrl)
	{
		this.dataBaseUrl = dataBaseUrl;
	}

	public String getDataBaseUser()
	{
		return dataBaseUser;
	}

	public void setDataBaseUser(String dataBaseUser)
	{
		this.dataBaseUser = dataBaseUser;
	}

	public String getDataBasePassword()
	{
		return dataBasePassword;
	}

	public void setDataBasePassword(String dataBasePassword)
	{
		this.dataBasePassword = dataBasePassword;
	}

	public globalProperties() {
		super();
	}
	
}
