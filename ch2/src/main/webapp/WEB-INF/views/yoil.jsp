<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
	<title>YoilTellerMVC</title>
</head>
<body>
	<h1> year = <%=request.getParameter("year") %></h1>
	<h1>${MyDate.year}년 ${MyDate.month}월 ${MyDate.day}일은 ${yoil}요일입니다.</h1>
</body>
</html>
