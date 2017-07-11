<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" /> 
    <title>CKEditor</title>
    <style> </style>
    <script src="/resources/js/ckeditor/ckeditor.js"></script>
    <script>
        window.onload = function() { 
            CKEDITOR.replace( 'editor1' );
                        
            var btn1 = document.getElementById("btn1");
            btn1.onclick = function(e){
                 var data = CKEDITOR.instances.editor1.getData();
        
                alert(data);
            };
            
            var btn2 = document.getElementById("btn2");
            btn2.onclick = function(e){
                 var data = CKEDITOR.instances.inputArticleContents.getData();
        
                alert(data);
            };
        };
    </script>
    
</head>
<body> 
    <h3>id를 이용한 CKEditor 붙이기</h3>
    <div id="editor1" name="editor1name" >
        ${msg }
    </div>
    <input id="btn1" type="button" value="확인" />
    <hr /> 
    
    <h3>class를 이용한 CKEditor 붙이기</h3>
    <form id="writeform" action="/ckeditor" method="post" enctype="application/x-www-form-urlencoded">
        <textarea name="inputArticleContents" class="ckeditor" rows="5" cols="50">
            ${msg }
        </textarea>
        <input id="btn2" type="submit" value="확인" />
    </form>
</body>
</html>    