package ua.dao.implementation;

//import java.util.List;

import javax.persistence.EntityManager;

import ua.dao.ItemDao;
import ua.entity.Smartphone;

public class ItemDaoImpl extends GenericDaoImpl<Smartphone, Integer> implements ItemDao{

	public ItemDaoImpl(EntityManager em) {
		super(Smartphone.class, em);
	}
	
//	@Override
//	public List<Smartphone> findAll() {
//		List<Smartphone> entitys = em.createQuery("SELECT x FROM Smartphone x")
//				.getResultList();
//		return entitys;
//	}
}
