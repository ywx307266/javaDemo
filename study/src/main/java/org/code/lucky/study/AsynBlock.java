package org.code.lucky.study;

/**
 * 单例设计模式
 * 
 * @author OIM
 *
 */
class Handler
{
	private static volatile  Handler instance = null;

	private Handler() {
		System.out.println("实例化对象："+Thread.currentThread().getName());
	}

	public static synchronized Handler getInstance()
	{
		if (null == instance)
		{
			synchronized (Handler.class)
			{
				if (null == instance)
				{
					instance = new Handler();
				}
			} 
		}
		return instance;
	}
}

public class AsynBlock
{

	public static void main(String[] args)
	{
		new Thread(() -> {System.out.println(Handler.getInstance().toString());},"线程A").start();
		new Thread(() -> {System.out.println(Handler.getInstance().toString());},"线程B").start();
		new Thread(() -> {System.out.println(Handler.getInstance().toString());},"线程C").start();
	}

}
