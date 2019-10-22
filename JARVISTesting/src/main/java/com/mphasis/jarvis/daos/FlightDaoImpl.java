package com.mphasis.jarvis.daos;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.jarvis.entities.Flight;
import com.mphasis.jarvis.entities.Location;
import com.mphasis.jarvis.entities.Route;
import com.mphasis.jarvis.entities.Schedule;
@Repository
public class FlightDaoImpl implements FlightDao{
	@Autowired
	SessionFactory sessionFactory;
	public List<Flight> getAllFlight() {
		Session session=sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
         query.from(Flight.class);
         List<Flight> flight = session.createQuery(query).getResultList();
         session.close();
        return flight;
		
	}

	public void deleteFlight(String flightId){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Flight flight= (Flight)session.get(Flight.class,flightId);
		session.delete(flight);
		session.getTransaction().commit();
		session.close();
	}

	public void updateFlight(Flight flight) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(flight);
		session.getTransaction().commit();
		session.close();
	}

	public void addFlight(Flight flight) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(flight);
		session.getTransaction().commit();
	}

	public Flight getFlightById(String flightId){
		Session session=sessionFactory.openSession();
		Flight flight= (Flight)session.get(Flight.class,flightId);
		return flight;
	}

	@Override
	public List<Flight> getFlightByRoute(String routeId) {
		Session session=sessionFactory.openSession();
		Route route=session.get(Route.class,routeId);
		
		Criteria cr=session.createCriteria(Route.class);
		Criterion sr=Restrictions.eq("route",route);
		
		Criteria cr2=session.createCriteria(Flight.class);
		cr2.add(Restrictions.eq("route",route));
		
		return cr2.list();
		}

	@Override
	public List<Flight> getFilghtBySourceAndDestination(String sourceId, String destinationId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Location source= session.get(Location.class, sourceId);
		Location destination= session.get(Location.class, destinationId);
		
		Criteria cr=session.createCriteria(Route.class);
		Criterion sr=Restrictions.eq("source",source);
		Criterion de=Restrictions.eq("destination",destination);
		cr.add(Restrictions.and(sr,de));
		Route route=(Route) cr.uniqueResult();
		
		Criteria cr2=session.createCriteria(Flight.class);
		cr2.add(Restrictions.eq("route",route));
	     
			return cr2.list();
	}

	@Override
	public List<Flight> getFilghtBySourceAndDestinationAndSchedule(String sourceId, String destinationId,
			String sdate) {
		Session session=sessionFactory.openSession();
		Location source= session.get(Location.class, sourceId);
		Location destination= session.get(Location.class, destinationId);
		
		Criteria cr=session.createCriteria(Route.class);
		Criterion sr=Restrictions.eq("source",source);
		Criterion de=Restrictions.eq("destination",destination);
		cr.add(Restrictions.and(sr,de));
		Route route=(Route) cr.uniqueResult();
		System.out.println("route" +route.getRouteId());
		Criteria cr1=session.createCriteria(Schedule.class);
		cr1.add(Restrictions.eq("scheduleDate",sdate));
		List<Schedule> schedueles=cr1.list();
		System.out.println("scheuldes");
			// schedueles.forEach((s)->System.out.println(s.getScheduleId()));
			 Criteria cr2=session.createCriteria(Flight.class);
			 cr2.add(Restrictions.and(Restrictions.eq("route",route), Restrictions.in("schedule", schedueles)));
		List<Flight> flights= cr2.list();
		return flights;
	}

	@Override
	public void updateFlightSeatById(String flightId) {


		Session session=sessionFactory.openSession();    
		session.beginTransaction();     
		Flight flight=session.load(Flight.class,flightId);    
		int seatleft=flight.getAvailableSeat();
		int newSeat= seatleft-1;
		flight.setAvailableSeat(newSeat);
		session.update(flight);    
		session.getTransaction().commit();      
		session.close();   
	}
	@Override
	public void incrementFlightSeatById(String flightId) {


		Session session=sessionFactory.openSession();    
		session.beginTransaction();     
		Flight flight=session.load(Flight.class,flightId);    
		int seatleft=flight.getAvailableSeat();
		int newSeat= seatleft+1;
		flight.setAvailableSeat(newSeat);
		session.update(flight);    
		session.getTransaction().commit();      
		session.close();   
	}

}
