package org.code.lucky.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 用户自定义全局参数集合
 * 
 * @author OIM
 */

@Configuration
@ConfigurationProperties(prefix = "user.control")
public class UserConfig
{

	private String	autoCommit;
	private int		maxConnectionCount;
	private String	runUser;
	private String	runUserAuth;

	public String getAutoCommit()
	{
		return autoCommit;
	}

	public void setAutoCommit(String autoCommit)
	{
		this.autoCommit = autoCommit;
	}

	public int getMaxConnectionCount()
	{
		return maxConnectionCount;
	}

	public void setMaxConnectionCount(int maxConnectionCount)
	{
		this.maxConnectionCount = maxConnectionCount;
	}

	public String getRunUser()
	{
		return runUser;
	}

	public void setRunUser(String runUser)
	{
		this.runUser = runUser;
	}

	public String getRunUserAuth()
	{
		return runUserAuth;
	}

	public void setRunUserAuth(String runUserAuth)
	{
		this.runUserAuth = runUserAuth;
	}

}
