<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>File Upload</title>
</head>

<body>
    <p>upload ok!!</p>
    <ol>
        <!--  아래 files는 컨트롤러에서 직접 넘겨준 모델명 -->
        <c:forEach var="file" items="${files}">
            <li>${file}</li>
        </c:forEach>        
        
        <!-- 컨트롤러에서 @ModelAttribute로 선언된 객체는 자동으로 view로 전달  -->
        <br />
        <br />Uload Path : ${uploadForm.upDir}
    </ol>
</body>
</html>