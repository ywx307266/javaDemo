package com.test.objects;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fox.util.JacksonUtils;
public class TestMain
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Student stu=new Student();
		stu.setStuNo("ywx307266");
		stu.setName("闫永超");
		stu.setSchoolName("陕西理工大学");
		stu.setAge(24);
		stu.setAddress(new Address("陕西省","汉中市","朝阳路12号10#公寓207室"));
		stu.setBeginIN(new Date());

		String jsonStr=JacksonUtils.beanToString(stu);
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		sb.append(""+jsonStr+",");
		stu=new Student();
		stu.setStuNo("ywx307267");
		stu.setName("斩影");
		stu.setSchoolName("陕西理工大学");
		stu.setAge(44);
		stu.setAddress(new Address("陕西省","汉中市","朝阳路12号10#公寓207室"));
		stu.setBeginIN(new Date());

	    jsonStr=JacksonUtils.beanToString(stu);
		sb.append(""+jsonStr+"");
		sb.append("]");
		//System.out.println(sb.toString());
		List<SuperMan> list=new ArrayList<SuperMan>();
		
		System.out.println(list.getClass());
		list=(List<SuperMan>) JacksonUtils.JsonStrToBeanList(SuperMan.class, sb.toString());
		System.out.println(list.get(0).getName());
		
	}

}
