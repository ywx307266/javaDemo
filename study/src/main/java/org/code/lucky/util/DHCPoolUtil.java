package org.code.lucky.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 返回数据库连接 通过DhcP Pool
 * 
 * @author OIM
 *
 */
public class DHCPoolUtil extends IConnect
{

	public DHCPoolUtil() {
		super();
		// 创建数据库连接池
		try
		{
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}