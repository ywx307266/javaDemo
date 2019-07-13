package oim;

public class Work
{

	public static String version = "v1.0";

	public synchronized void dowork()
	{
		System.out.println(String.format("thread[%s] begin visit dowork", Thread.currentThread().getName()));

		try
		{
			Thread.sleep(6000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println(String.format("thread[%s] end visit dowork", Thread.currentThread().getName()));
	}

	public void doClear()
	{
		synchronized (Work.class)
		{
			System.out.println(String.format("thread[%s] begin visit doClear", Thread.currentThread().getName()));
			try
			{
				Thread.sleep(7000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(String.format("thread[%s] end visit doClear", Thread.currentThread().getName()));
		}
	}

	public void print()
	{
		System.out.println(String.format("current version: %s", Work.version));
	}
}
