<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>
    <h2> <c:out value="${serverTime}" /></h2>    
    <hr />    
    <p>  ${serverTime} </p>        
</body>
</html>
