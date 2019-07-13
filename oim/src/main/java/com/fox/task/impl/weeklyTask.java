package com.fox.task.impl;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fox.task.abstractTask;
@Component
public class weeklyTask extends abstractTask
{
	private static Logger logger=Logger.getLogger(weeklyTask.class);
			
	@Override
	protected void execute()
	{	
		logger.info(String.format("[%s] start weekly working...", Thread.currentThread().getName()));

		logger.info(String.format("[%s] over weekly working", Thread.currentThread().getName()));

	}

}
