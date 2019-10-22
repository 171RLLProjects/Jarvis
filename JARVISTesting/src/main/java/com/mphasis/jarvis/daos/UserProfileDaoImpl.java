package com.mphasis.jarvis.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.jarvis.entities.UserProfile;



@Repository
public class UserProfileDaoImpl implements UserProfileDao{
	@Autowired
	SessionFactory sessionFactory;
	public UserProfile login(String userName, String userPass) {
		Session session=sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<UserProfile> criteriaQuery=criteriaBuilder.createQuery(UserProfile.class);
        Root<UserProfile> root=criteriaQuery.from(UserProfile.class);
        List<Predicate> predicates=new ArrayList<Predicate>();
        if(userName !=null) {
            predicates.add(criteriaBuilder.equal(root.get("userName"), userName));   
        }
        if(userPass != null) {
            predicates.add(criteriaBuilder.equal(root.get("userPass"), userPass));
        }
        criteriaQuery.select(root).where(predicates.toArray(new Predicate[] {}));
        UserProfile userProfile=session.createQuery(criteriaQuery).getSingleResult();
        return userProfile;
	}
	 
	public UserProfile getUserById(String userId){
		Session session=sessionFactory.openSession();
		UserProfile userProfile= (UserProfile)session.get(UserProfile.class,userId);
		return userProfile;
	}

	public void updatePassword(UserProfile userProfile){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(userProfile);
		session.getTransaction().commit();
		session.close();
	}

	public void registerUser(UserProfile userProfile){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String userId=(String) session.save(userProfile);
		session.getTransaction().commit();
		session.close();
	}

	public List<UserProfile> getAllUser(){
		Session session=sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<UserProfile> query = builder.createQuery(UserProfile.class);
         query.from(UserProfile.class);
         List<UserProfile> userProfiles = session.createQuery(query).getResultList();
         session.close();
        return userProfiles;
	}

	public void deleteUser(String userId){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserProfile userProfile= (UserProfile)session.get(UserProfile.class,userId);
		session.delete(userProfile);
		session.getTransaction().commit();
		session.close();
	}

	public void updateUser(UserProfile userProfile){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(userProfile);
		session.getTransaction().commit();
		session.close();
	}

	
	
}
