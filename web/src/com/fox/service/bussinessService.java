package com.fox.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fox.common.Interface.business;
@Service("bussinessService")
public class bussinessService implements business 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#saveEntity(java.lang.Object)
	 */
	@Override
	public void saveEntity(Object objectEntity) {
		getSession().save(objectEntity);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#updateEntity(java.lang.Object)
	 */
	@Override
	public void updateEntity(Object objectEntity) {
		getSession().update(objectEntity);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#deleteEntity(java.lang.Object)
	 */
	@Override
	public void deleteEntity(Object objectEntity) {
		getSession().delete(objectEntity);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#getObject(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <T> T getObject(Class<T> c, Serializable id) {
		return getSession().get(c, id);
	}

	/* (non-Javadoc)
	 * @see com.fox.service.business#getLists(java.lang.String, java.util.Map)
	 */
	@Override
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
