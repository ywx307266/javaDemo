package org.code.lucky.pool;

import java.io.IOException;

import org.code.lucky.util.DHCPoolUtil;

public class PoolTest
{

	public static void main(String[] args) throws IOException
	{
		try (DHCPoolUtil util = new DHCPoolUtil())
		{
			System.out.println(util.getConnection());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
