package com.fox.test;

import com.fox.util.JacksonUtils;
import com.test.objects.Student;

public class Test
{

	public static void main(String[] args)
	{
		Student stu=new Student();
		stu.setAge(23);
		stu.setName("闫永超");
		stu.setSchoolName("陕西理工大学");
		stu.setStuNo("ywx307266");
		
		System.out.println(JacksonUtils.beanToString(stu));
		
	}

}
