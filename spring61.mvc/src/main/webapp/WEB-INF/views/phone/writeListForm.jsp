<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" /> 
    <style>
        table, td, th { border: 1px solid green; }        
        th { background-color: green; color: white; }
    </style>
</head>
<body>
    <form action="writelist" method="post" enctype="application/x-www-form-urlencoded">
        <input type="text" name="phoneItems[0].name" placeholder="폰 이름1" required="required" size="50"><br> 
        <input type="text" name="phoneItems[0].manufacturer" placeholder="폰 제조사1" required="required" size="50"><br> 
        <input type="text" name="phoneItems[0].price" placeholder="폰 가격1" required="required" size="50"><br>
        <hr>

        <input type="text" name="phoneItems[1].name" placeholder="폰 이름2" required="required" size="50"><br> 
        <input type="text" name="phoneItems[1].manufacturer" placeholder="폰 제조사2" required="required" size="50"><br>
        <input type="text" name="phoneItems[1].price" placeholder="폰 가격2" required="required" size="50"><br>
        <hr>
        
        <input type="submit" value="작성"><input type="reset" value="취소">
    </form>
</body>
</html>