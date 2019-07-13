package com.fox.task.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fox.common.Interface.business;
import com.fox.service.globalProperties;

@Component
public class initTask implements ApplicationListener<ContextRefreshedEvent>
{
	private static Logger logger = LoggerFactory.getLogger(initTask.class);

	@Autowired
	@Qualifier("bussinessService")
	private business service;

	@Autowired
	private globalProperties config;

	public void onApplicationEvent(ContextRefreshedEvent arg0)
	{
		if (arg0.getApplicationContext().getParent() == null)
		{
			logger.error("***********Spring Root Context init successfully***********");

		}
		else
		{
			logger.error("***********Spring MVC ServletContext init successfully***********");
			logger.warn(config.getDataBaseUrl());
		}
	}


}
