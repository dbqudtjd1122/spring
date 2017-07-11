<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 반복문 >> for</title>
</head>
<body>
    <h3>JSTL 반복문 >> for</h3>
    <c:forEach var="cnt" begin="2" end="20" step="2">
        <font size="${cnt/2}"> ${cnt/2} 야호~~</font> <br />
    </c:forEach>
</body>
</html>