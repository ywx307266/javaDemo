package org.code.lucky.study;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者-消费者模型
 * @author OIM
 *
 */
public class ProviderConsumer
{
	public static void main(String[] args)
	{
		DataHub data = new DataHub();
		new Thread(new Provide(data)).start();

		Consume consume1 = new Consume(data);
		Consume consume2 = new Consume(data);
		new Thread(consume1, "消费Thread1: ").start();
		new Thread(consume2, "消费Thread2: ").start();
	}
}

class DataHub
{
	boolean			flag	= true;									// 是否允许生产

	boolean			over	= false;
	Queue<String>	queue	= new ArrayBlockingQueue<String>(100);

	/**
	 * 消息生产
	 * 
	 * @param message[]
	 */
	public synchronized void add(String... message)
	{
		if (!flag)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		queue.add(message[0]);
		flag = false;
		if (message.length > 1)
		{
			over = true;
		}
		this.notifyAll();

	}

	/**
	 * 消息消费
	 * 
	 * @return
	 */
	public synchronized String consume()
	{

		String message = "";
		if (flag)
		{
			try
			{
				if (!over)
				{
					this.wait();
				}
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		try
		{
			Thread.sleep(200);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		message = queue.poll();
		flag = true;
		this.notifyAll();
		return message;

	}
}

class Consume implements Runnable
{

	DataHub data;

	public Consume(DataHub data) {
		this.data = data;
	}

	public void run()
	{
		for (int i = 1; i < 11; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + this.data.consume());
		}

		System.out.println("消费任务完成");
	}

}

class Provide implements Runnable
{
	DataHub data;

	public Provide(DataHub data) {
		this.data = data;
	}

	public void run()
	{
		for (int i = 1; i < 11; i++)
		{
			if (i == 10)
			{
				this.data.add(String.format("message[index=%d]", i), "over");
			}
			else
			{
				this.data.add(String.format("message[index=%d]", i));
			}
		}

		System.out.println("生产任务完成");
	}

}