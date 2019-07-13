package com.fox.util;

import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
public class JacksonUtils
{

	public static  String beanToString(Object obj){
		
		String str="";
		ObjectMapper mapper=new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		mapper.setDateFormat(format);  
		try
		{
			mapper.setSerializationInclusion(Include.NON_EMPTY);
			mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
			str=mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e)
		{			
			e.printStackTrace();
		}
		return str;
		
	}
	
	public static <T>  T JsonStrToBean(Class<T> c,String jsonString){
		
		T obj=null;
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{			
			obj=mapper.readValue(jsonString, c);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	public static List<?> JsonStrToBeanList(Class<?> c,String jsonString){
		
		List<?> obj=null;
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, c);  
		try
		{			
			obj=mapper.readValue(jsonString, javaType);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
}
