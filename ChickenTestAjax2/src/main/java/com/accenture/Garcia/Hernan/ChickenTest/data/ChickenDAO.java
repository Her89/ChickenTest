package com.accenture.Garcia.Hernan.ChickenTest.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.Garcia.Hernan.ChickenTest.model.Chicken;
import com.accenture.Garcia.Hernan.ChickenTest.model.Chicken;
import com.accenture.Garcia.Hernan.ChickenTest.model.Chicken;

public class ChickenDAO {

	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Chicken getChicken(Long id) {
		Session session = sessionFactory.openSession();
		Chicken chicken = (Chicken) session.load(Chicken.class, id);
		session.close();
		return chicken;
	}

	
	public List<Chicken> listChicken() {
		Session session = sessionFactory.openSession();
		List<Chicken> chickenList = session.createQuery("from Chicken ").getResultList();
		
		session.close();
		return chickenList;
	}
	
	@Transactional
	public void addChicken(Chicken chicken) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(chicken);
		tx.commit();
		session.close();
	}

	@Transactional
	public void updateChicken(Chicken chicken) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(chicken);
		tx.commit();
		session.close();		
	}


	@Transactional
	public void deleteChicken(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Chicken chicken = (Chicken) session.load(Chicken.class, id);
		session.delete(chicken);
		tx.commit();
		session.close();		
	}

	
	
}
