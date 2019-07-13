package com.fox.rest.sgmt;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.fox.common.Interface.business;
import com.fox.entity.*;
import com.fox.service.globalProperties;
import com.fox.util.JsonResult;

@RestController
@RequestMapping("sg")
public class sgService
{
	 @Autowired
	 @Qualifier("bussinessService")
	 private business service;
	 
	 @Autowired
	 @Qualifier("generalService")
	 private business genservice;
	 
	 @Autowired
	 private globalProperties config;
	 
	 @RequestMapping("getData/{id}")
	 public student getStudentInfo(@PathVariable("id") int id) {	
		 
		 student stu=null;
		 stu=service.getObject(student.class, id);
	     return stu;
	 }
	 
	 @RequestMapping(path="delData/{id}",method=RequestMethod.DELETE)
	 public void removeStudentInfo(@PathVariable("id") int id) {	
		 service.deleteEntity(service.getObject(student.class, id));
	 }
	 
	 @RequestMapping("delDog/{id}")
	 public void delDog(@PathVariable("id") int id) {	
		 service.deleteEntity(service.getObject(Dog.class, id));
	 }
	 
	 @RequestMapping("getTelephone/{id}")
	 public telephone queryPhone(@PathVariable("id") int id) {	
		 
		 telephone phone=service.getObject(telephone.class, id);
		 
	     return phone;
	 }
	 
	@RequestMapping(path="addTelephone/{phone}/{userid}",method=RequestMethod.POST)
	 public JsonResult queryPhone(@PathVariable("phone") String phone,@PathVariable("userid") String userid,String area) {
		 JsonResult result=new JsonResult();
		 telephone Tphone=new telephone();
		 Tphone.setArea(area);
		 Tphone.setPhonenumber(phone);
		 Tphone.setUserid(Integer.valueOf(userid));
		 service.saveEntity(Tphone);
	    
	     result.setSuccess(true);
	     return result;
	 }
	 
	 @SuppressWarnings("unchecked")
	 @RequestMapping(path = "getList")
	 public List<student> queryAllStudent() {
		 Map<String, Object> params=new HashMap<String, Object>();
		 params.put("name", "zhang");
		 String hql="from student where id in (select id from student where name =:name) and name=:name";
	     return (List<student>)service.getLists(hql, params);
	 }
	 
	 @RequestMapping(path = "save")
	 public JsonResult save() {
		 JsonResult result=new JsonResult();
		 for(int i=1;i<30;i++){
			 service.saveEntity(new student(i,"严"+i,"陕西渭南市北疆"+i+"组",new Date()));
		 }		 
			 result.setSuccess(true);
			     
	     return result;
	 }
	 
	 @RequestMapping(path = "saveData",method=RequestMethod.POST)
	 public student saveStudent(student stu, BindingResult result) {
		 service.saveEntity(stu);
	     return stu;
	 }
	
	 
	 @RequestMapping(path = "saveDogData",method=RequestMethod.GET)
	 public JsonResult saveDogData() {
		 JsonResult result=new JsonResult();
		 try
		{
			Set<DogAddress> adddogs=new HashSet<DogAddress>();
			 Dog dog=new Dog();
			 dog.setName("秋田犬1号");
			 
			 Address address=new Address();
			 address.setName("日本九州福岛高宛县");
			
			 DogAddress da=new DogAddress();
			 da.setAdd(address);
			 adddogs.add(da);
			 
			 address=new Address();
			 address.setName("陕西榆林");		 
			 da=new DogAddress();
			 da.setAdd(address);
			 adddogs.add(da);
			 
			 address=new Address();
			 address.setName("美国洛杉矶");		 
			 da=new DogAddress();
			 da.setAdd(address);
			 adddogs.add(da);
			 
			 dog.setDogAddress(adddogs);
			 service.saveEntity(dog);
		} catch (Exception e)
		{
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
	     return result;
	 }
	 
	 @RequestMapping(path = "getDogData/{id}",method=RequestMethod.GET)
	 public Dog getDogData(@PathVariable int id) {

		 Dog dog=service.getObject(Dog.class, id);
		 
	     return dog;
	 }
}
