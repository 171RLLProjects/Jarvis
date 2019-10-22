package com.mphasis.jarvis.daos;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.entities.FlightClass;
import com.mphasis.jarvis.entities.Location;
import com.mphasis.jarvis.entities.Route;

@Repository
public class FlightClassDaoImpl implements FlightClassDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<FlightClass> getAllFlightClass() {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FlightClass> query = builder.createQuery(FlightClass.class);
		query.from(FlightClass.class);
		List<FlightClass> flightClasses = session.createQuery(query).getResultList();
		session.close();
		return flightClasses;
	}

	@Override
	public void deleteFlightClass(String flightClassId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		FlightClass flightClass= (FlightClass)session.get(FlightClass.class,flightClassId);
		session.delete(flightClass);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateFlightClass(FlightClass flightClass) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(flightClass);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void addFlightClass(FlightClass flightClass) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(flightClass);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public FlightClass getFlightClassById(int flightClassId) {
		Session session=sessionFactory.openSession();
		FlightClass flightClass= (FlightClass)session.get(FlightClass.class,flightClassId);
		return flightClass;	
	}

	@Override
	public List<FlightClass> getFlightClassByFlightId(String flightId) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Flight.class);
		//List<Flight> flight=(List<Flight>) cr.add(Restrictions.in("flightId",flightId));
		Flight flight=(Flight) cr.add(Restrictions.eq("flightId",flightId)).uniqueResult();
		Criteria cr2=session.createCriteria(FlightClass.class);
		cr2.add(Restrictions.in("flight",flight));
		return cr2.list();
	}


	@Override
	public void updateFlightClassSeatbyName(String flightId,String flightClass) {

		Session session=sessionFactory.openSession();    
		session.beginTransaction(); 
		
		Flight fl=session.get(Flight.class, flightId);
		Criteria cr=session.createCriteria(FlightClass.class);
		cr.add(Restrictions.eq("flightClass", flightClass)).list();
		cr.add(Restrictions.in("flight", fl));
		FlightClass flightClasses=(FlightClass) cr.uniqueResult();
		int seatleft=flightClasses.getNumberOfSeats();
		int newSeat= seatleft-1;
		flightClasses.setNumberOfSeats(newSeat);
		session.update(flightClasses);    
		session.getTransaction().commit();      
		session.close();  
	}
	@Override
	public void incrementFlightClassSeatbyName(String flightId,String flightClass) {

		Session session=sessionFactory.openSession();    
		session.beginTransaction(); 
		
		Flight fl=session.get(Flight.class, flightId);
		Criteria cr=session.createCriteria(FlightClass.class);
		Criterion cr1=Restrictions.eq("flight", fl);
		Criterion cr2=Restrictions.eq("flightClass", flightClass);
		cr.add(Restrictions.and(cr1,cr2));
		FlightClass flightClasses= (FlightClass) cr.uniqueResult();
	
			int seatleft=flightClasses.getNumberOfSeats();
		int newSeat= seatleft+1;
		flightClasses.setNumberOfSeats(newSeat);
		session.update(flightClasses);    
		session.getTransaction().commit();      
		session.close();  
	}


}


