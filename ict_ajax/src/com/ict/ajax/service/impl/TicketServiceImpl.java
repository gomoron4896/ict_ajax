package com.ict.ajax.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.ict.ajax.dao.TicketDAO;
import com.ict.ajax.dao.impl.TicketDAOImpl;
import com.ict.ajax.service.TicketService;
import com.ict.ajax.vo.Ticket;

public class TicketServiceImpl implements TicketService {
	private TicketDAO td = new TicketDAOImpl();
	
	@Override
	public Map<String,Object> getTicketList(Ticket ti) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("list", td.selectTicketList(ti));
		rMap.put("page", 10);
		return rMap;
	}

	@Override
	public Ticket getTicket(Ticket ti) {
		return td.selectTicket(ti);
	}

	@Override
	public int putTicket(Ticket ti) {
	
		return td.insertTicketList(ti);
	}

	@Override
	public int modTicket(Ticket ti) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeTicket(Ticket ti) {
		// TODO Auto-generated method stub
		return 0;
	}

}
