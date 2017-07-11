<%@ page language="java" 
         contentType="text/html; charset=UTF-8" 
         pageEncoding="UTF-8" 
         session="true"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:choose>
  <c:when test="${not empty errorMessage}">
    <c:set var="error" scope="session" value="${errorMessage}" />
    <jsp:forward page="error/404.jsp" />
  </c:when>
  <c:otherwise>
    <c:redirect url="/jstl/jstl12" />
  </c:otherwise>
</c:choose>