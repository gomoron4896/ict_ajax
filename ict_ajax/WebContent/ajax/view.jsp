<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String num = request.getParameter("tmnum");
%>
<html>
<head>
<meta content="charset=UTF-8">
<title>Insert title here</title>
<script src="/json/AjaxUtil.js"></script>
</head>
<body>
	<table border="1">
		<tbody>
			<tr>
				<th>영화명 :</th>
				<td data-col="tmname"></td>
			</tr>
			<tr>
				<th>개봉일 :</th>
				<td data-col="tmstartdat"></td>
			</tr>
			<tr>
				<th>종료일 :</th>
				<td data-col="tmenddat"></td>
			</tr>
			<tr>
				<th>가격 :</th>
				<td data-col="tmprice"></td>
			</tr>
		</tbody>
	</table>
	<script>
		var tmnum = <%=num%>

		window.onload = function() {
			var conf = {
				url : '/json/ticket/view'
				, method : 'GET'
				, params : {
					tmnum : tmnum
				}
				, cb : callback
			};
			var au = new AjaxUtil(conf);
			au.send();
			function callback(res) {
				var ress = JSON.parse(res);
				var cols = document.querySelectorAll('td[data-col]');
				for(var col of cols) {
					var attr = col.getAttribute('data-col')
					col.insertAdjacentHTML('afterbegin', ress[attr]);
				}
				//document.querySelector('td[data-col=tmname]').insertAdjacentHTML('afterbegin',ress.tmname);
				//document.querySelector('td[data-col=tmstartdat]').insertAdjacentHTML('afterbegin',ress.tmstartdat);
				//document.querySelector('td[data-col=tmenddat]').insertAdjacentHTML('afterbegin',ress.tmenddat);
				//document.querySelector('td[data-col=tmprice]').insertAdjacentHTML('afterbegin',ress.tmprice);
			}
		}
	</script>
</body>
</html>