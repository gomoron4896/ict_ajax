package com.ict.ajax.dao;

import java.util.List;

import com.ict.ajax.vo.Ticket;

public interface TicketDAO {
	
	public List<Ticket> selectTicketList(Ticket ti);
	public Ticket selectTicket(Ticket ti);
	public int insertTicketList(Ticket ti);
	public int updateTicketList(Ticket ti);
	public int deleteTicketList(Ticket ti);
	
	

}
