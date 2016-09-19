package ua.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;

import ua.dao.GenericDao;

public abstract class GenericDaoImpl<E, ID> implements GenericDao<E, ID> {
	
	private final Class<E> entityClass;
	
	protected final EntityManager em;
	
	public GenericDaoImpl(Class<E> entityClass, EntityManager em) {
		this.entityClass = entityClass;
		this.em = em;
	}
	
	public void save(E entity) {
		if (!em.getTransaction().isActive())em.getTransaction().begin();
		em.persist(entity);
		if (em.getTransaction().isActive())em.getTransaction().commit();
	}

	public void update(E entity) {
		if (!em.getTransaction().isActive())em.getTransaction().begin();
		em.merge(entity);
		if (em.getTransaction().isActive())em.getTransaction().commit();
	}

	public void delete(E entity) {
		if (!em.getTransaction().isActive())em.getTransaction().begin();
		em.remove(entity);
		if (em.getTransaction().isActive())em.getTransaction().commit();
	}

	public E findOne(ID id) {
		E entity = em.find(entityClass, id);
		return entity;
	}

	public List<E> findAll() {
		return em.createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();
	}

}
