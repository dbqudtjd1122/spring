<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="http://krdic.naver.com/detail.nhn" var="url">
       <c:param name="where" value="nextearch"></c:param>
       <c:param name="query" value="우주소녀"></c:param>
       <c:param name="sm" value="top_hty"></c:param>
       <c:param name="fbm" value="1"></c:param> 
</c:url>

<c:redirect url="${url }"></c:redirect>


