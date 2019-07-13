package org.code.lucky.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * 本地系统级命令执行接口
 * 
 * @author OIM
 *
 */
public class RuntimeTest
{
	public static void main(String[] args) throws Exception
	{
		Runtime rt = Runtime.getRuntime();

		System.out.println(rt.freeMemory() / 1024 / 1024);

		Process p = rt.exec("ping -n 10 127.0.0.1");

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null)
		{
			System.out.println(line);
		}

	}

}
