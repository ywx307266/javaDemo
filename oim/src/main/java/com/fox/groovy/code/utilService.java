package com.fox.groovy.code;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fox.entity.student;

@Component
public class utilService
{
	@Autowired
	private LogService logService;
	
	public void printCurrentTime(){
		logService.printErrorMsg("我错了,我要挂了.");
	}
	
	/**
	 * 查询指定学生信息
	 */
	public student getData(int id){
		return new student(id,"闫永超","陕西省渭南市合阳县知堡乡北知堡村二组",new Date());
	}
	
	/**
	 * 返回所有学生信息列表
	 * @return
	 */
	public List<student> getList(){
		 List<student> list=new ArrayList<student>();
		 list.add(new student(1,"杨军","河北邯郸",new Date()));
		 list.add(new student(11,"张展","陕西西安",new Date()));
		 list.add(new student(111,"王抗战","广东湛江",new Date()));
	     return list;
	}
}
