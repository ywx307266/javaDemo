package org.code.lucky.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 返回数据库连接 通过Ali Druid Pool
 * 
 * @author OIM
 *
 */
public class DruidPoolUtil extends IConnect
{

	public DruidPoolUtil() {
		super();
		// 创建数据库连接池
		try
		{
			dataSource = DruidDataSourceFactory.createDataSource(props);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}