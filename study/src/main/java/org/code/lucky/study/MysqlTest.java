package org.code.lucky.study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import org.code.lucky.util.DruidPoolUtil;

/**
 * Mysql数据库多线程数据插入
 * 
 * @author OIM
 *
 */
class dataTask implements Runnable
{

	Connection			conn	= null;
	int					count	= 100;

	SimpleDateFormat	dFormat	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Random				random	= new Random();
	CountDownLatch		latch	= null;

	public dataTask(Connection conn, CountDownLatch latch, int count) {
		this.conn = conn;
		this.latch = latch;
		this.count = count;
	}

	@Override
	public void run()
	{
		try
		{
			PreparedStatement state = conn.prepareStatement("insert into orderinfo values(?,?,?,?)");
			for (int i = 0; i < count; i++)
			{
				state.setString(1, UUID.randomUUID().toString());
				state.setString(2, "闫永超 - " + i);
				state.setInt(3, random.nextInt(100));
				state.setString(4, dFormat.format(new Date(System.currentTimeMillis() - i * 1000)));
				state.addBatch();
			}
			state.executeBatch();
			conn.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			latch.countDown();
		}
	}

}

public class MysqlTest
{

	public static void main(String[] args)
	{
		try (DruidPoolUtil poolUtil = new DruidPoolUtil())
		{
			int sum = 100;
			int threadCount = 5;
			int countPerThread = sum / threadCount;
			long startTime = System.currentTimeMillis();
			CountDownLatch latch = new CountDownLatch(threadCount);
			for (int i = 0; i < threadCount; i++)
			{
				new Thread(new dataTask(poolUtil.getConnection(), latch, countPerThread), "数据插入线程" + i).start();
			}
			try
			{
				latch.await();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) / 1000.0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
