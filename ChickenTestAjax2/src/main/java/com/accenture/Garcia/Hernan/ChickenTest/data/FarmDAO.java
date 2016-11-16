package com.accenture.Garcia.Hernan.ChickenTest.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.Garcia.Hernan.ChickenTest.model.Farm;


public class FarmDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Farm getFarm(Long id) {
		Session session = sessionFactory.openSession();
		Farm farm = (Farm) session.load(Farm.class, id);
		session.close();
		return farm;
	}

	
	public List<Farm> listFarm() {
		Session session = sessionFactory.openSession();
		List<Farm> farmList = session.createQuery("from Farm").getResultList();
		session.close();
		return farmList;
	}

	@Transactional
	public void addFarm(Farm farm) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(farm);
		tx.commit();
		session.close();
	}

	@Transactional
	public void updateFarm(Farm farm) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(farm);
		tx.commit();
		session.close();		
	}

	@Transactional
	public void deleteFarm(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Farm farm = (Farm) session.load(Farm.class, id);
		session.delete(farm);
		tx.commit();
		session.close();		
	}

	
	
	
}
