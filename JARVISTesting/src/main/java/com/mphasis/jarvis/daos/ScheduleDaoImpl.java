package com.mphasis.jarvis.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.jarvis.entities.Schedule;
@Repository
public class ScheduleDaoImpl implements ScheduleDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addSchedule(Schedule schedule) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(schedule);
		session.getTransaction().commit();
		session.close();
	}

	public void updateSchedule(Schedule schedule) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(schedule);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteSchedule(String scheduleId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Schedule schedule=session.get(Schedule.class, scheduleId);
		session.delete(schedule);
		session.getTransaction().commit();
		session.close();
	}

	public List<Schedule> getAll() {
		Session session=sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Schedule> query = builder.createQuery(Schedule.class);
		query.from(Schedule.class);
		List<Schedule> schedule = session.createQuery(query).getResultList();
		session.close();
		return schedule;
	}

	public Schedule getScheduleByID(String scheduleId) {
		Session session=sessionFactory.openSession();
		Schedule schedule=session.get(Schedule.class, scheduleId);
		return schedule;
	}
	
	
	
	

}
