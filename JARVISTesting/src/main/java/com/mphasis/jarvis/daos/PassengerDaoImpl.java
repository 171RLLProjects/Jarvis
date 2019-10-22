package com.mphasis.jarvis.daos;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.jarvis.entities.Passenger;

@Repository
public class PassengerDaoImpl implements PassengerDao{
@Autowired
	SessionFactory sessionFactory;
	public void registerPassenger(Passenger passenger){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(passenger);
		session.getTransaction().commit();
		session.close();
	}

	public List<Passenger> getAllPassenger() {
	    Session session=sessionFactory.openSession();
	        Transaction transaction = null;
	        transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Passenger> query = builder.createQuery(Passenger.class);
	         query.from(Passenger.class);
	         List<Passenger> passenger = session.createQuery(query).getResultList();
	         session.close();
	        return passenger;
	}

	@Override
	public void cancelPassenger(String passengerId) {
		
		String Stat="cancel";
		Session session=sessionFactory.openSession();   
		session.beginTransaction();     
		Passenger passenger=session.get(Passenger.class, passengerId);    
		passenger.setPassengerStatus(Stat);
		session.update(passenger);     
		session.getTransaction().commit();      
		session.close();     
		
	}	
	
	
	@Override
	public Passenger getPassengerById(String passengerId) {

		 Session session=sessionFactory.openSession();
	     Passenger passenger= session.get(Passenger.class, passengerId);
	        return passenger;
     
		
	}
	
}
