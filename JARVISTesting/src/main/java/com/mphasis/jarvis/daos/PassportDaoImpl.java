package com.mphasis.jarvis.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.jarvis.entities.Admin;
import com.mphasis.jarvis.entities.Passport;


@Repository
public class PassportDaoImpl implements PassportDao {
	@Autowired
	SessionFactory sessionFactory;
	public void add(Passport passport) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(passport);
		session.getTransaction().commit();
		session.close();

	}

	

	public Passport getPassportById(String passportId) {

		Session session=sessionFactory.openSession();
		Passport passport=(Passport) session.createCriteria(Passport.class).add(Restrictions.eq("passportId", passportId)).uniqueResult();
		return passport;
	}

	@Override
	public List<Passport> getAll() {
		Session session=sessionFactory.openSession();

		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Passport> query = builder.createQuery(Passport.class);
		query.from(Passport.class);
		List<Passport> passport = session.createQuery(query).getResultList();
		session.close();
		return passport;
	}

}
