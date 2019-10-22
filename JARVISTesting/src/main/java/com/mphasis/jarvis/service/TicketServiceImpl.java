package com.mphasis.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.jarvis.daos.TicketDao;
import com.mphasis.jarvis.entities.Ticket;
import com.mphasis.jarvis.exceptions.BusinessException;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketDao ticketDao;
	@Override
	public void insertTicket(Ticket ticket) {
		ticketDao.insertTicket(ticket);

	}

	@Override
	public void cancelTicket(String ticketId) {
		ticketDao.cancelTicket(ticketId);

	}

	@Override
	public Ticket getTicketById(String ticketId) {

		return ticketDao.getTicketById(ticketId);
	}
}


