<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> <a href="/rest/currentversion"              target="_blank"> /rest/currentversion </a></p>
<p> <a href="/rest/login?id=test1id&pw=test1pw" target="_blank"> /rest/login?id=test1id&pw=test1pw" </a></p>
<p> <a href="/rest/personlist"                  target="_blank"> /rest/personlist </a></p>
<p> <a href="/rest/insertperson?id=test11id&pw=test11pw&name=test11name&email=test11email" > /rest/insertperson </a></p>
</body>
</html>
