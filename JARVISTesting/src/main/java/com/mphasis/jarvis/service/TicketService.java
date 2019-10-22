package com.mphasis.jarvis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.jarvis.entities.Ticket;
@Service
public interface TicketService {
	public void insertTicket(Ticket ticket);
	 public Ticket getTicketById(String ticketId);
	 public void cancelTicket(String ticketId);

}
