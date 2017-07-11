<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jstl과 멀티 체크박스</title>
</head>
<body>
    
    <h3>jstl과 멀티 체크박스</h3>
    <hr>

    <c:forEach items="${itemList}" var="itemrow">
        <input  type="checkbox" name="${itemrow.code}" <c:if test="${itemrow.checked}"> checked="checked" </c:if>  />${itemrow.value}
    </c:forEach>
</body>
</html>