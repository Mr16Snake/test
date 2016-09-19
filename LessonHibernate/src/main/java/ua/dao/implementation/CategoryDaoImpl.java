package ua.dao.implementation;

import javax.persistence.EntityManager;

import ua.dao.CategoryDao;
import ua.entity.Budget;

public class CategoryDaoImpl extends GenericDaoImpl<Budget, Integer> implements CategoryDao{

	public CategoryDaoImpl(EntityManager em) {
		super(Budget.class, em);
	}
}
