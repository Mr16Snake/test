package ua.dao.implementation;

import javax.persistence.EntityManager;

import ua.dao.ScreenDao;
import ua.entity.ScreenSize;

public class ScreenDaoImpl extends GenericDaoImpl<ScreenSize, Integer> implements ScreenDao{

	public ScreenDaoImpl(EntityManager em) {
		super(ScreenSize.class, em);
	}

}
