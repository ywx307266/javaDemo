package com.fox.groovy.code;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain
{
	public static void main(String[] args){
		
		try
		{
			@SuppressWarnings("resource")
			ApplicationContext context=new ClassPathXmlApplicationContext("com/config/ApplicationContext.xml");
			utilService service=(utilService) context.getBean("utilService");
			service.printCurrentTime();
		} catch (BeansException e)
		{
			// TODO Auto-generated catch block
			e.toString();
		}

	}

}
