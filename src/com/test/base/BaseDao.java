package com.test.base;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author
 * 
 *         Sep 3, 2013
 * @param <T>
 */
public class BaseDao<T> {

	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public <T> T queryById(Class<T> entityClass, Integer id) {
		return (T) getSession().get(entityClass, id);
	}

	public <T> void save(T t) {
		getSession().save(t);

	}

	public <T> void update(T t) {
		getSession().update(t);

	}

	public <T> void delete(T t) {
		getSession().delete(t);

	}

	public <T> void delete(Class<T> entityClass, Integer id) {
		getSession().delete(queryById(entityClass, id));

	}

	/**
	 * 
	 * @param <T>
	 * @param hql
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> queryForList(String hql) {
		return queryForList(hql, new Object[] {});
	}

	/**
	 * 
	 * @param <T>
	 * @param hql
	 * @param entityClass
	 * @param param
	 * @return
	 */
	public <T> List<T> queryForList(String hql, Object param) {
		return queryForList(hql, new Object[] { param });

	}

	/**
	 * 
	 * @param <T>
	 * @param hql
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public <T> List<T> queryForList(String hql, Object[] params) {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		return (List<T>) query.list();

	}

	/**
	 * 
	 * @param <T>
	 * @param hql
	 * @param entityClass
	 * @param params
	 * @return
	 */
	public T queryForObject(String hql, Object[] params) {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		return (T) query.uniqueResult();

	}

	public <T> List<T> findByPage(String hql, int firstResult, int maxResult) {
		return findByPage(hql, new Object[] {}, firstResult, maxResult);

	}

	public <T> List<T> findByPage(String hql, Object param, int firstResult,
			int maxResult) {
		return findByPage(hql, new Object[] { param }, firstResult, maxResult);

	}

	public <T> List<T> findByPage(String hql, Object[] params, int firstResult,
			int maxResult) {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return (List<T>) query.list();

	}

	private void setQueryParams(Query query, Object[] params) {
		if (null == params) {
			return;
		}
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

}
