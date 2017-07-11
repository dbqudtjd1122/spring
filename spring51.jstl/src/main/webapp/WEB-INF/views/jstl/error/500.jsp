<%@ page language="java" isErrorPage="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>500 error</title>
    <style type="text/css">
        body.er_body  {background:url(/images/er_bg.png) repeat-x left top;}
        .e_content    {width:100%; position:relative; font-family:'Malgun Gothic', '맑은고딕';padding-top:50px; }
        .e_content h1 {font-size:20px; margin-left:50px;}
        .e_content p  {font-size:18px;  margin-left:50px;}
    </style>
</head>
<body class="er_body">
	<div class="e_content">
		<h1>퍼미션 지정을 못했거나 일시적인 서버문제입니다</h1>
		<p>계속적인 문제가 발생된다면 관리자에게 문의해 주세요. <br/>
        연락처 000-0000-0000</p>
		<font color="#FFFFFF"><%=exception%></font>
	</div>
</body>
</html>