package com.fox.task.impl;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;

import com.fox.task.abstractTask;
@Component
public class dailyTask extends abstractTask
{
	private static Logger logger=Logger.getLogger(dailyTask.class);
	@Override
	protected void execute()
	{	
		logger.info(String.format("[%s] start daily working...", Thread.currentThread().getName()));
		try
		{
			Thread.sleep(30*60000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		logger.info(String.format("[%s] over daily working", Thread.currentThread().getName()));

	}

}
