package com.mphasis.jarvis.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.jarvis.entities.Route;

@Repository
public class RouteDaoImpl implements RouteDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addRoute(Route route){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(route);
		session.getTransaction().commit();
		session.close();
	}

	public void updateRoute(Route route)  {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(route);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteRoute(String routeId){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Route route=session.get(Route.class, routeId);
		session.delete(route);
		session.getTransaction().commit();
		session.close();
	}

	public List<Route> getAll(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Route> query = builder.createQuery(Route.class);
		query.from(Route.class);
		List<Route> route = session.createQuery(query).getResultList();
		session.close();
		return route;
	}

	public Route getRouteByID(String routeId){
		Session session=sessionFactory.openSession();
		Route route=session.get(Route.class, routeId);
		return route;
	}

}
