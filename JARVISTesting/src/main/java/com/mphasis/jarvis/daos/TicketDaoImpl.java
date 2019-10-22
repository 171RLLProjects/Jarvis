package com.mphasis.jarvis.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.jarvis.entities.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertTicket(Ticket ticket){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(ticket);
		session.getTransaction().commit();
	}

	

	@Override
	public void cancelTicket(String ticketId) {
		String Stat = "cancel";
		Session session=sessionFactory.openSession();   
		session.beginTransaction();     
		Ticket ticket=session.get(Ticket.class, ticketId);    
		ticket.setTicketStatus(Stat);   
		session.update(ticket);     
		session.getTransaction().commit();      
		session.close();       
	}



	@Override
	public Ticket getTicketById(String ticketId) {
		Session session=sessionFactory.openSession();      
		Ticket ticket=session.get(Ticket.class, ticketId);    
		return ticket;
	}	
	}

