<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <h3> @ModelAttribute를 이용한 로그인 처리 정보 </h3>
    <label> 이름 : ${ info.name } </label>
    <br>
    <label> 폰 : ${ info.phone } </label>
</body>
</html>
