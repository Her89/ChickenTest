package com.accenture.Garcia.Hernan.ChickenTest.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.Garcia.Hernan.ChickenTest.model.Egg;

public class EggDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Egg getEgg(Long id) {
		Session session = sessionFactory.openSession();
		Egg egg = (Egg) session.load(Egg.class, id);
		session.close();
		return egg;
	}

	
	public List<Egg> listEgg() {
		Session session = sessionFactory.openSession();
		List<Egg> eggList = session.createQuery("from Egg ").getResultList();
		
		session.close();
		return eggList;
	}

	@Transactional
	public void addEgg(Egg egg) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(egg);
		tx.commit();
		session.close();
	}

	@Transactional
	public void updateEgg(Egg egg) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(egg);
		tx.commit();
		session.close();		
	}

	@Transactional
	public void deleteEgg(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Egg egg = (Egg) session.load(Egg.class, id);
		session.delete(egg);
		tx.commit();
		session.close();		
	}

}
