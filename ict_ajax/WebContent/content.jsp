<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String method = request.getMethod();
%>
<div>
	저는 JSP파일에서 생성된 HTML입니다.<%=method %>
</div>
