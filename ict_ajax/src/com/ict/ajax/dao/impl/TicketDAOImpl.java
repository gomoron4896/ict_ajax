package com.ict.ajax.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.ajax.common.DBConn;
import com.ict.ajax.dao.TicketDAO;
import com.ict.ajax.vo.Ticket;

public class TicketDAOImpl implements TicketDAO {
	private Connection conn;

	@Override
	public List<Ticket> selectTicketList(Ticket ti) {
		conn = DBConn.getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Ticket> ticketList = new ArrayList<Ticket>();
		String sql = "select * from ticket_movie";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ti = new Ticket();
				ti.setTmnum(rs.getInt("tmnum"));
				ti.setTmname(rs.getString("tmname"));
				ti.setTmprice(rs.getInt("tmprice"));
				ti.setTmstartdat(rs.getString("tmstartdat"));
				ti.setTmenddat(rs.getString("tmenddat"));
				ti.setTmdesc(rs.getString("tmdesc"));
				ti.setTmcnt(rs.getInt("tmcnt"));
				ti.setTmimg(rs.getString("tmimg"));
				ticketList.add(ti);
			}
			rs.close();
			ps.close();
			DBConn.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.closeConn();
		}

		return ticketList;
	}

	@Override
	public Ticket selectTicket(Ticket ti) {
		conn = DBConn.getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Ticket t = null;
		String sql = "select * from ticket_movie where tmnum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ti.getTmnum());
			rs = ps.executeQuery();
			while (rs.next()) {
				t = new Ticket();
				t.setTmnum(rs.getInt("tmnum"));
				t.setTmname(rs.getString("tmname"));
				t.setTmprice(rs.getInt("tmprice"));
				t.setTmstartdat(rs.getString("tmstartdat"));
				t.setTmenddat(rs.getString("tmenddat"));
				t.setTmdesc(rs.getString("tmdesc"));
				t.setTmcnt(rs.getInt("tmcnt"));
				t.setTmimg(rs.getString("tmimg"));
			}
			rs.close();
			ps.close();
			DBConn.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.closeConn();
		}

		return t;
	}

	@Override
	public int insertTicketList(Ticket ti) {
		conn = DBConn.getConn();
		PreparedStatement ps = null;
		int rCnt = -1;
		String sql = "insert into ticket_movie";
		sql += " values(?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ti.getTmnum());
			ps.setString(2, ti.getTmname());
			ps.setInt(3, ti.getTmprice());
			ps.setString(4, ti.getTmstartdat());
			ps.setString(5, ti.getTmenddat());
			ps.setString(6, ti.getTmdesc());
			ps.setInt(7, ti.getTmcnt());
			ps.setString(8, ti.getTmimg());
			rCnt = ps.executeUpdate();
			conn.commit();
			ps.close();
			DBConn.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.rollback();
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConn.closeConn();
		}
		return rCnt;
	}

	@Override
	public int updateTicketList(Ticket ti) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTicketList(Ticket ti) {
		// TODO Auto-generated method stub
		return 0;
	}

}