package ua.dao;

import java.util.List;

public interface GenericDao<E, ID> {

	void save(E entity);
	
	void update(E entity);
	
	void delete(E entity);
	
	E findOne(ID id);
	
	List<E> findAll();
}
