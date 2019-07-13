package org.code.lucky.study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest
{

	public static void main(String[] args)
	{
		Pattern pattern = Pattern.compile("http://[a-z.]+\\?([a-z]+=[a-z0-9]+&)*([a-zA-Z]+=[a-z0-9]+)");
		Matcher matcher = pattern.matcher("http://www.baidu.com?key=name&value=taobao&isDelete=true");
		if (matcher.matches())
		{
			for (int i = 1; i <= matcher.groupCount(); i++)
			{
				System.out.println(matcher.group(i));
			}
		}
	}

}
