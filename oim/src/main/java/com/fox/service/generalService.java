package com.fox.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fox.common.Interface.business;

@Service("generalService")
public class generalService implements business
{


	public void saveEntity(Object objectEntity) {
		// TODO Auto-generated method stub

	}


	public void updateEntity(Object objectEntity) {
		// TODO Auto-generated method stub

	}


	public void deleteEntity(Object objectEntity) {
		// TODO Auto-generated method stub

	}


	public <T> T getObject(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List getLists(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
