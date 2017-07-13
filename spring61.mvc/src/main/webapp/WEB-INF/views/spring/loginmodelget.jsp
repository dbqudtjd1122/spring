<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <form action="/spring/loginmodel" method="post"
                      enctype="application/x-www-form-urlencoded"> 
        <label for="name">이름 : <input type="text" name="name" /></label> <br>
        <label for="phone">폰 :  <input type="text" name="phone" /></label> <br>
        <input type="submit" value="전송" />
    </form>
</body>
</html>
