package org.code.lucky.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Mysql数据库连接获取辅助类
 * 
 * @author OIM
 *
 */
public class NativeMysqlUtil
{

	private static Properties props = new Properties();

	static
	{
		try
		{
			props.load(NativeMysqlUtil.class.getResourceAsStream("/jdbc.properties"));

			Class.forName(props.getProperty("driverClassName"));
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static Connection getConnection()
	{
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(props.getProperty("url"),
					props.getProperty("username"), props.getProperty("password"));

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return conn;
	}
}
