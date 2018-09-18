<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="com.ict.ajax.common.ParseFiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String tempPath = System.getProperty("java.io.tmpdir");
	String savePath = "D:/dev/workspace_t/ict_ajax/WebContent/files";
	File tmpDir = new File(tempPath);
	DiskFileItemFactory dFactory = new DiskFileItemFactory();
	dFactory.setRepository(tmpDir);
	
	ServletFileUpload sfu = new ServletFileUpload();
	sfu.setFileItemFactory(dFactory);
	sfu.setFileSizeMax(1024*1024*100);
	sfu.setSizeMax(1024*1024*200);
	List<FileItem> fList = 	sfu.parseRequest(request);
	for(int i = 0; i<fList.size() ; i++) {
		FileItem fi = fList.get(i);
		if(fi.isFormField()) {
			String name = fi.getFieldName();
			String value = fi.getString("utf-8");
			out.println(name + " : " + value + "<br>");
		} else {
			String name = fi.getFieldName();
			String value = fi.getName();
			if(value.equals("")) continue;
			savePath = savePath + File.separator + value;
			File save = new File(savePath);
			fi.write(save);
			out.println(name + " : " + value + "<br>");
		}
	}
%>