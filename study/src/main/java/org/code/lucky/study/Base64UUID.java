package org.code.lucky.study;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask{

	@Override
	public void run()
	{
		System.out.println("調度執行： "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
	}
	
}
public class Base64UUID
{
	public static void main(String[] args)
	{
		Timer timer=new Timer();
		timer.schedule(new MyTask(), 1000, 2000);
		
		ThreadLocal<String> tl=new ThreadLocal<String>();
		tl.set("hello");
		
		System.out.println(tl.get());
	}
}
