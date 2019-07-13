package com.fox.task.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class quartzTask2 implements Job
{
	
	
	public quartzTask2() {
		super();
	}

	private void printMsg(JobExecutionContext arg0){
		System.out.println(Thread.currentThread().getName()+" trriger cron job2 begin ..." + arg0.isRecovering());
		try
		{
			Thread.sleep(10*60000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" trriger cron job2 over ..." + arg0.isRecovering());
	}

	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		printMsg(arg0);
		
	}
}
