package org.code.lucky.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class IConnect implements AutoCloseable
{
	protected Properties	props		= new Properties();

	protected DataSource	dataSource	= null;

	public IConnect() {
		try
		{
			props.load(C3P0PoolUtil.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public Connection getConnection()
	{
		Connection connection = null;
		try
		{
			connection = dataSource.getConnection();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void close() throws Exception
	{
		if (dataSource != null)
		{
			try
			{
				DataSources.destroy(dataSource);
				System.out.println("释放数据库连接池");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
