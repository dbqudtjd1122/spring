<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" /> 
    <title>CKEditor</title>
    <style> </style>
    <script src="./resources/js/ckeditor/ckeditor.js"></script>
    <script src="./resources/js/jquery/jquery-3.1.0.js"></script>
    <script type="text/javascript">
    
        $(document).ready( function(e){
            CKEDITOR.replace( 'editor1' );

            $('#btn1').click(function(e) {
                var data = CKEDITOR.instances.editor1.getData();
                $('#editor1').text( data );
                $(this).cs
                $(this).parent().submit();
            });
            
            $('#writeform').submit(function(e) {
                var data = CKEDITOR.instances.inputArticleContents.getData();
                $('.ckeditor').text( data );
                
                return true;
            });
        });
    </script>
    
</head>
<body> 
    <h3>id를 이용한 CKEditor 붙이기</h3>
    <form action="ckeditor" method="post" enctype="application/x-www-form-urlencoded">
        <textarea id="editor1"  name="inputArticleContents" rows="20" cols="50">
            ${msg }
        </textarea>
        <input id="btn1" type="button" value="확인" />
    </form>
    <hr /> 
    
    <h3>class를 이용한 CKEditor 붙이기</h3>
    <form id="writeform" action="ckeditor" method="post" enctype="application/x-www-form-urlencoded">
        <textarea name="inputArticleContents" class="ckeditor" rows="20" cols="50">
            ${msg }
        </textarea>
        <input id="btn2" type="submit" value="확인" />
    </form>
</body>
</html>    