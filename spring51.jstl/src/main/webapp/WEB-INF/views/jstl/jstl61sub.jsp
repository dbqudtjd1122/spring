<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSTL scope</title>
</head>
<body>
    
    <h3>JSTL scope</h3>
    <hr>
    상품코드 : ${code}<br>
    상품명   : ${name}<br>
    가격     : ${price}원<br>
    브라우저 : ${browser}<br>
    
    <hr>
    <c:out value="<B>${code }</B>"></c:out><br>
    <c:out value="<B>${code }</B>" escapeXml="false"></c:out><br>
    
    <!-- 선언이 안된 변수값에 Dafault 값 주기 -->
    <c:out value="${str }" default="No Data"></c:out><br>
    <c:out value="${name }" default="No Data"></c:out> <!--출력 -->

</body>
</html>