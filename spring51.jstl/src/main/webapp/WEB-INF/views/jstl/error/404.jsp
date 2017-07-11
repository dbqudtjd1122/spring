<%@ page language="java" isErrorPage="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>404 error</title>
    <style type="text/css">
        body.er_body  {background:url(/images/er_bg.png) repeat-x left top;}
        .e_content    {width:100%; position:relative; font-family:'Malgun Gothic', '맑은고딕';padding-top:50px; }
        .e_content h1 {font-size:20px; margin-left:50px;}
        .e_content p  {font-size:18px;  margin-left:50px;}
    </style>
</head>
<body class="er_body">
	<div class="e_content">
		<h1>요청하신 파일을 찾을 수 없거나, 서버에서 제거되었습니다.</h1>
		<p>URL을 확인해 주세요. <br/>
        정상적인 링크를 통해 접속했는데, 이 메세지가 표시될 경우, <br />
        관리자에게 문의해 주세요.</p>	 
        <font color="#FFFFFF">
            <c:out value='${sessionScope.error}'/>
        </font>	
	</div>
</body>
</html>