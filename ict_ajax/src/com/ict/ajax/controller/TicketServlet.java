package com.ict.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ict.ajax.service.impl.TicketServiceImpl;
import com.ict.ajax.vo.Ticket;

@WebServlet(
		urlPatterns = "/ticket/*"
		)
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private TicketServiceImpl ts = new TicketServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param = req.getParameter("params");
		System.out.println(param);
		Ticket ti = null;
		if (param != null && !param.equals("")) {
			ti = gson.fromJson(param, Ticket.class);
		}
		System.out.println(ti);
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		if (cmd.equals("list")) {
			doWrite(res, ts.getTicketList(ti));
		} else if (cmd.equals("view")) {
			doWrite(res, ts.getTicket(ti));
		} else {
			res.sendError(404);
		}

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Ticket ti = gson.fromJson(req.getReader(), Ticket.class);
		System.out.println(ti);
		int rCnt = ts.putTicket(ti);
		Map<String, Integer> rMap = new HashMap<String, Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(res, rMap);
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Ticket ti = gson.fromJson(req.getReader(), Ticket.class);
		int rCnt = ts.modTicket(ti);
		Map<String, Integer> rMap = new HashMap<String, Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(res, rMap);
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Ticket ti = gson.fromJson(req.getReader(), Ticket.class);
		int rCnt = ts.removeTicket(ti);
		Map<String, Integer> rMap = new HashMap<String, Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(res, rMap);
	}

	protected void doWrite(HttpServletResponse res, Object obj) throws ServletException, IOException {
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(gson.toJson(obj));
	}

}
