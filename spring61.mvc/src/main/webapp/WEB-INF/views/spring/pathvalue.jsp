<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <p> name  : ${ name } </p>     
    <c:if test=${ phone != null } >
    <p> phone : ${ phone } </p>   
    </c:if> 
      
</body>
</html>
