package com.ict.ajax.service;

import java.util.List;
import java.util.Map;

import com.ict.ajax.vo.Ticket;

public interface TicketService {
	
	public Map<String,Object> getTicketList(Ticket ti);
	public Ticket getTicket(Ticket ti);
	public int putTicket(Ticket ti);
	public int modTicket(Ticket ti);
	public int removeTicket(Ticket ti);

}
