<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>file  upload demo</title>    
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script>
        $(document).ready( function(e){
            
            $('#joinOk').click( function(e){

                $.ajax({
                    url : '/restservice/login',
                    data: { id: $('#id').val(), pw:$('#pw').val() },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
                    type: 'post',       // get, post
                    timeout: 30000,    // 30초
                    dataType: 'json',  // text, html, xml, json, jsonp, script
                    beforeSend : function() {
                        // 통신이 시작되기 전에 이 함수를 타게 된다.
                        $('#container').append('<img src="./loading.gif">');
                    }
                }).done( function(data, textStatus, xhr ){
                    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                    if(!data){
                        alert("존재하지 않는 ID입니다");
                        return false;
                    }
                    
                    var html = '';
                    html += '<div>';
                    html += '<p>이름 : '+data.name+'</p>';
                    html += '<p>아이디 : '+data.id+'</p>';
                    html += '<p>이메일 : '+data.email+'</p>';
                    html += '<p>비밀번호 : '+data.password+'</p>';
                    html += '</div>';
                    
                    $("#container").after(html);
                }).fail( function(xhr, textStatus, error ) {
                    // 통신이 실패했을 때 이 함수를 타게 된다.
                    var msg ='';
                    msg += "code:"    + xhr.status         + "\n";
                    msg += "message:" + xhr.responseText   + "\n";
                    msg += "status:"  + textStatus         + "\n";
                    msg += "error  : "+ error              + "\n";
                    alert( msg );
                    console.log(msg);
                }).always( function(data, textStatus, xhr ) {
                    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
                    $('#container > img').remove();
                });

            });
        });
    </script>
</head>
<body>
    <h3>Spring Rest Service</h3>

    <div id="container">
        <input type="text" id="id" name="id" placeholder="아이디" required="required" value="" /> <br />
        <input type="text" id="pw" name="pw" placeholder="이름" required="required" value="" /> <br />
        <input type="button" id="joinOk" value="확인" />
        <input type="button" id="joinOk" value="회원가입" />     
    </div>   
</body>
</html>