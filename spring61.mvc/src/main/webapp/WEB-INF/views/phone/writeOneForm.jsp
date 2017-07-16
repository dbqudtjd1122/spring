<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <style>
        table, td, th { border: 1px solid green; }        
        th { background-color: green; color: white; }
    </style>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script>
    </script>
</head>
<body>
    <form action="" method="post" enctype="multipart/form-data">
        <input type="text" name="name"  size="50" placeholder="폰 이름" required="required" /> <br> 
        <input type="text" name="manufacturer" size="50" placeholder="폰 제조사" required="required"/> <br> 
        <input type="text" name="price" size="50" placeholder="폰 가격" required="required" /> <br> 
        
        <input type="button" id="writeone1" value="작성1" />
        <input type="button" id="writeone2" value="작성2" />
        <input type="button" id="writeone3" value="작성3" />
        <input type="button" id="writeone4" value="작성4" />
    </form>
</body>
</html>
