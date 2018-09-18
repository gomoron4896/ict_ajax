<%@page import="com.ict.ajax.Emp"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.ict.ajax.Depart"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("params");
	System.out.println(param);
	Gson gson = new Gson();
	Depart dept = gson.fromJson(param, Depart.class);
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oxy", "rltjq4896");

	PreparedStatement ps = con.prepareStatement("select * from emp where empname like '%' || ? || '%'");
	ps.setString(1, dept.getDiname());
	ResultSet rs = ps.executeQuery();
	ResultSetMetaData rsmt = rs.getMetaData();
	List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
	while (rs.next()) {
		Map<String, String> rsMap = new HashMap<String, String>();
		for (int i = 1; i <= rsmt.getColumnCount(); i++) {
			rsMap.put(rsmt.getColumnName(i), rs.getObject(i) + "");
		}
		rsList.add(rsMap);
	}
	rs.close();
	ps.close();
	con.close();
	System.out.println(rsList);
	String json = gson.toJson(rsList);
	out.print(json);
%>