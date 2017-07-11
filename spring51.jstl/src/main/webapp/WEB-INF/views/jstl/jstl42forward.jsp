<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="code" value="80012" scope="request"></c:set>
<c:set var="name" value="온습도계" scope="request"></c:set>
<c:set var="price" value="15000" scope="request"></c:set>
<c:set var="browser" value="${header['User-Agent'] }" scope="request"></c:set>

<jsp:forward page="jstl03.jsp"/>