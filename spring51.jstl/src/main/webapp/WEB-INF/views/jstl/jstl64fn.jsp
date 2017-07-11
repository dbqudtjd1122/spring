<%@ page language="java"  contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" session="true"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>Using JSTL Functions</title>
</head>
<body>
    <p>String (1) : ${ fn:split(string1, '@')}</p>
    <hr >
    
    <c:set var="string2" value="${fn:split(string1, '@')}" />
    <p>String (2) : ${string2[0]}</p>
    <hr >
    
    <c:set var="string3" value="${fn:split(user.code, '@')}" />
    <p>String (3) : ${string3[0]}</p>

</body>
</html>