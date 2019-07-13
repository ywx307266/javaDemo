package com.fox.groovy.code;

import org.springframework.stereotype.Service;

@Service
public class LogService
{
	public void printErrorMsg(String message){
		System.out.println("错误信息:"+message);
	}
}
