<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ict.ajax.Person"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Gson gson = new Gson();
Person person = gson.fromJson(request.getReader(), Person.class);
List<Person> pList = new ArrayList<Person>();

for(int i = 1; i<=10 ; i++) {
	Person p = new Person();
	p.setId("id" + i);
	p.setPwd("pwd" + i);
	p.setName("name" + i);
	p.setTrans(((i%2)+1) +"");
	pList.add(p);
}
out.print(gson.toJson(pList));
%>