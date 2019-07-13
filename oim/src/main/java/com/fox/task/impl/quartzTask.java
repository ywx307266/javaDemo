package com.fox.task.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class quartzTask implements Job
{
	
	
	public quartzTask() {
		super();
	}

	private void printMsg(){
		System.out.println(Thread.currentThread().getName()+" trriger cron job begin ...");
		try
		{
			Thread.sleep(2*60000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" trriger cron job over ...");
	}

	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		printMsg();
		
	}
}
