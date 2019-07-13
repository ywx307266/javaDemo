package com.fox.common.Interface;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface business
{

	void saveEntity(Object objectEntity);

	void updateEntity(Object objectEntity);

	void deleteEntity(Object objectEntity);

	<T> T getObject(Class<T> c, Serializable id);

	List getLists(String hql, Map<String, Object> params);

}