package ua.dao.implementation;

import javax.persistence.EntityManager;

import ua.dao.BrandDao;
import ua.entity.Brand;

public class BrandDaoImpl extends GenericDaoImpl<Brand, Integer> implements BrandDao{

	public BrandDaoImpl(EntityManager em) {
		super(Brand.class, em);
	}

}
