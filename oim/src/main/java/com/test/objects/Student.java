package com.test.objects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("data")
public class Student extends peopleBasicInfo
{

	private String	stuNo;
	private String	schoolName;

	private Date beginIN;

	public String getStuNo()
	{
		return stuNo;
	}

	public void setStuNo(String stuNo)
	{
		this.stuNo = stuNo;
	}

	public String getSchoolName()
	{
		return schoolName;
	}

	public void setSchoolName(String schoolName)
	{
		this.schoolName = schoolName;
	}

	public Date getBeginIN()
	{

		return (Date) (beginIN == null ? beginIN : beginIN.clone());
	}

	public void setBeginIN(Date beginIN)
	{
		this.beginIN = beginIN;
	}

}
