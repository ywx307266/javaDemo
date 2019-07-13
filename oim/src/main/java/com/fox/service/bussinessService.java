package com.fox.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fox.common.Interface.business;
@Service("bussinessService")
public class bussinessService implements business 
{
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#saveEntity(java.lang.Object)
	 */

	public void saveEntity(Object objectEntity) {
		getSession().save(objectEntity);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#updateEntity(java.lang.Object)
	 */

	public void updateEntity(Object objectEntity) {
		getSession().update(objectEntity);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#deleteEntity(java.lang.Object)
	 */

	public void deleteEntity(Object objectEntity) {
		getSession().delete(objectEntity);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#getObject(java.lang.Class, java.io.Serializable)
	 */

	public <T> T getObject(Class<T> c, Serializable id) {
		logger.info("查询学生信息，{}", id);
		return getSession().get(c, id);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#getLists(java.lang.String, java.util.Map)
	 */

	@SuppressWarnings("rawtypes")
	public List getLists(String hql, Map<String,Object> params) {
		Query query=getSession().createQuery(hql);
		if(null!=params){
			for (String key:params.keySet())
			{
				query.setParameter(key, params.get(key));
			}
		}
		return query.list();
	}

}
