package org.code.lucky.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * 返回数据库连接 通过C3P0 Pool
 * 
 * @author OIM
 *
 */
public class C3P0PoolUtil extends IConnect
{

	public C3P0PoolUtil() {
		super();
		try
		{
			// 设置连接数据库的配置信息
			DataSource ds_unpooled = DataSources.unpooledDataSource(props.getProperty("url"),
					props.getProperty("username"), props.getProperty("password"));

			dataSource = DataSources.pooledDataSource(ds_unpooled, props);

			System.out.println(dataSource);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}