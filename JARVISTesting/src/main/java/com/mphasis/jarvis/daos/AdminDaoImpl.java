package com.mphasis.jarvis.daos;
import com.mphasis.jarvis.entities.Admin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	SessionFactory sessionFactory;
	public void registerAdmin(Admin admin) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close(); 
	}



	public void updatePassword(Admin admin) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(admin);
		session.getTransaction().commit();
		session.close();
	}


	public Admin getAdminByUser(String adminName) {

		Session session=sessionFactory.openSession();
		Admin admin=(Admin) session.createCriteria(Admin.class).add(Restrictions.eq("adminName", adminName)).uniqueResult();
		return admin;
	}



	@Override
	public Admin login(String adminName, String adminPass) {
		Session session=sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Admin> criteriaQuery=criteriaBuilder.createQuery(Admin.class);
		Root<Admin> root=criteriaQuery.from(Admin.class);
		List<Predicate> predicates=new ArrayList<Predicate>();
		if(adminName !=null) {
			predicates.add(criteriaBuilder.equal(root.get("adminName"), adminName));	
		}
		if(adminPass != null) {
			predicates.add(criteriaBuilder.equal(root.get("adminPass"), adminPass));
		}
		criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
		Admin admin=session.createQuery(criteriaQuery).getSingleResult();
		return admin;
	}

}
