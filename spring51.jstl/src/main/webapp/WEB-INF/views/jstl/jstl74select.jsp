<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jstl과 select box</title>
</head>
<body>
    
    <h3>jstl과 select box</h3>
    <hr>
    
    <c:set var="phonenum" value="011-1111-2222" />
        
    <c:set var="phonearr" value="${fn:split(phonenum,'-') }" />

    <select name="roleName">
        <c:forEach items="${roleNames}" var="role">
            <option value="${role}"  ${role == phonearr[0] ? 'selected' : ''}>${role}</option>
        </c:forEach>
    </select>
    
    <select name="roleName">
        <option value="010"  ${'010' == selectedRole ? 'selected' : ''}>010</option>
        <option value="011"  ${'011' == selectedRole ? 'selected' : ''}>011</option>
        <option value="016"  ${'016' == selectedRole ? 'selected' : ''}>016</option>
        <option value="017"  ${'017' == selectedRole ? 'selected' : ''}>017</option>
        <option value="018"  ${'018' == selectedRole ? 'selected' : ''}>018</option>
        <option value="019"  ${'019' == selectedRole ? 'selected' : ''}>019</option>
    </select>
</body>
</html>