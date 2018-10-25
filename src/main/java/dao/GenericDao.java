package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericDao<T> {

	private Class<T> klass;
	
	public GenericDao(Class<T>klass) {
		this.klass = klass;
	}
	
	public T find(long l) {
		EntityManager em = DataBaseHelper.createEntityManager();
		T findClient = em.find(klass, l);
		return findClient;
	}
	
	public List<T> findAll() {
		EntityManager em = DataBaseHelper.createEntityManager();
		DataBaseHelper.beginTx(em);
		List<T> listT = null;
		TypedQuery<T> query = em.createQuery("FROM " + klass.getName() + " k", klass);
		listT = query.getResultList();
		return listT;
	}
	
	public void persist(T klass) {
		EntityManager em = DataBaseHelper.createEntityManager();
		DataBaseHelper.beginTx(em);
		try {
			em.persist(klass);
			DataBaseHelper.commitTxAndClose(em);
		} catch (Exception e) {
			DataBaseHelper.rollbackTxAndClose(em);
			e.printStackTrace();
		}
	}
	
	public void remove(T klass) {
		EntityManager em = DataBaseHelper.createEntityManager();
		DataBaseHelper.beginTx(em);
		try {
			em.remove(em.contains(klass) ? klass : em.merge(klass));
			DataBaseHelper.commitTxAndClose(em);
		} catch (Exception e) {
			DataBaseHelper.rollbackTxAndClose(em);
			e.printStackTrace();
		}
	}
	
	public void merge(T klass) {
		EntityManager em = DataBaseHelper.createEntityManager();
		DataBaseHelper.beginTx(em);
		try {
			em.merge(klass);
			DataBaseHelper.commitTxAndClose(em);
		} catch (Exception e) {
			DataBaseHelper.rollbackTxAndClose(em);
			e.printStackTrace();
		}
	}
	
}
