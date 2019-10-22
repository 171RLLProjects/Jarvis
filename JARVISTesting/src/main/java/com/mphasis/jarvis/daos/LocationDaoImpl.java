package com.mphasis.jarvis.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.jarvis.entities.Location;

@Repository
public class LocationDaoImpl implements LocationDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addLocation(Location location) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(location);
		session.getTransaction().commit();
		session.close();

	}

	public void updateLocation(Location location) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(location);
		session.getTransaction().commit();
		session.close();

	}

	public void deleteLocation(String locationId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Location location=session.get(Location.class, locationId);
		session.delete(location);
		session.getTransaction().commit();
		session.close();

	}

	public List<Location> getAll() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Location> query = builder.createQuery(Location.class);
		query.from(Location.class);
		List<Location> location = session.createQuery(query).getResultList();
		session.close();
		return location;
	}

	public Location getLocationByID(String locationId) {
		Session session=sessionFactory.openSession();
		Location location=session.get(Location.class, locationId);
		return location;
	}

}
