package com.fox.rest.tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("tag")
public class tagService
{
	@GetMapping(path="/index")
	public ModelAndView  getCurrentUser(){
		ModelAndView  view=new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping(path="",method=RequestMethod.GET)
	public String getCurrentUserInfo(){
		
		return "操作成功";
	}
	
	@RequestMapping(path="/{message}",method=RequestMethod.POST)
	public String  getCurrentUser1(@PathVariable String message){
		return message;
	}
	
	@RequestMapping(path="/{message}/{success}",method=RequestMethod.GET)
	public String  getCurrentUser2(@PathVariable String message,@PathVariable String success){
		
		return String.format("%s,%s", success,message);
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public String  getCurrentUser11(@PathVariable("id") String idx){
		
		return String.format("账号: %s ,基本信息已经删除.",idx);
	}

}
