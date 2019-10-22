package com.mphasis.jarvis.daos;

import java.util.List;

import com.mphasis.jarvis.entities.Ticket;

public interface TicketDao {
	public void insertTicket(Ticket ticket);
	 public Ticket getTicketById(String ticketId);
	 public void cancelTicket(String ticketId);
}
