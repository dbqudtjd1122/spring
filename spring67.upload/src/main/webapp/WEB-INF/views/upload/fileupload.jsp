<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>file  upload demo</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        <!-- jquery로 파일 첨부 input 태그 추가 -->
        $(document).ready(function() {
    
            //add more file components if Add is clicked
            $('#addFile').click(function() {
    
                var fileIndex = $('#fileview tr').children().length;
                $('#fileview').append(
                '<tr><td>' +
                '   <input type="file" name="files['+ fileIndex +']" />' +
                '</td></tr>');
            });
        });
    </script>
</head>
<body>
    <h3>Spring Single File Upload</h3>
    <form:form method="post" action="./fileuploadone" modelAttribute="uploadForm" enctype="multipart/form-data"> 

        Upload Directory : 
        <input type="text" name="upDir" value="c:/upload/" />
        <br />
        <br /> 
        <input type="file"  name="file" />
        <br />
        <input type="submit" id="uploadone"   value="Upload One" />
    </form:form>
    
    <hr>

    <h3>Spring Multi File Upload</h3>
    <form:form method="post" action="./fileuploadmulti" modelAttribute="uploadForm" enctype="multipart/form-data"> 

        Upload Directory : 
        <input type="text" name="upDir" value="c:/upload/" />
        <br />
        <br /> 
        <input type="button" id="addFile" value="File Add" />

        <table id="fileview">
            <tr>
                <td><input type="file"  name="files[0]" /></td>
            </tr>
        </table> 
        <br />
        <input type="submit" id="uploadmulti" value="Upload Multi" />
    </form:form>
    
    <hr>

    <h3>Drag &amp; Drop Multi File Upload</h3>
    <form:form method="post" action="" modelAttribute="uploadForm" enctype="multipart/form-data">
    
    </form:form>
</body>
</html>