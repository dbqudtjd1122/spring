<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="Keywords" content="회원 가입" />
    <meta name="Description" content="회원 가입" />
    <title>회원 가입</title>
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" />
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script>
        $(document).ready( function(e){
            
            $('#checkuserid').click( function(e){

            	var userid = $('#userid').val();
            	
            	if( userid === "" || userid === null ) {
            		return false;
            	}
            	
                $.ajax({
                    url : '/user/checkuserid',
                    data: { id: $('#userid').val() },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
                    type: 'get',       // get, post
                    timeout: 30000,    // 30초
                    dataType: 'json',  // text, html, xml, json, jsonp, script
                    beforeSend : function() {
                        // 통신이 시작되기 전에 이 함수를 타게 된다.
                        $('#signUpForm').append('<img src="/resources/images/loading.gif">');
                    }
                }).done( function(data, textStatus, xhr ){
                    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.                      
                    if(data === 1){
                        alert("존재하는 ID입니다");
                        
                        return false;
                    }
                    else {
                        alert("사용 가능한 ID입니다");

                        $('#signUpForm input').prop('disabled', false);
                    }
                    
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
                    $('#signUpForm > img').remove();
                });
            });
        });

        function check() {
            //var form = document.getElementById("signUpForm");
            //TODO 유효성 검사
            return true;
        }
    </script>           
</head>
<body>

<div id="wrap">

    <div id="header">
        <%@ include file="../inc/header.jsp" %>
    </div>

    <div id="main-menu">
        <%@ include file="../inc/main-menu.jsp" %>
    </div>

    <div id="container">
        <div id="content" style="min-height: 800px;">

            <!-- 본문 시작 -->
            <div id="url-navi">회원</div>
            
            <h1>회원 가입</h1>
            <form id="signUpForm" action="register" method="post" >
                <table>
                    <tr>
                        <td style="width: 200px;">사용자 아이디</td>
                        <td style="width: 390px">
                            <input type="text" name="userid" style="width: 70%;" id="userid" />
                            <input type="button" value="아이디 중복 조회" id="checkuserid"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 200px;">이름(Full Name)</td>
                        <td style="width: 390px"><input type="text" name="name" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>비밀번호(Password)</td>
                        <td><input type="password" name="passwd" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>비밀번호 확인(Confirm)</td>
                        <td><input type="password" name="confirm" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>이동전화(Mobile)</td>
                        <td><input type="text" name="mobile" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                </table>
                <div style="text-align: center;padding-bottom: 15px;">
                    <input type="submit" value="확인" />
                </div>
            </form>
            <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
    
    <div id="sidebar">
        <%@ include file="notLoginUsers-menu.jsp" %>
    </div>
    
    <div id="extra">
        <%@ include file="../inc/extra.jsp" %>
    </div>

    <div id="footer">
        <%@ include file="../inc/footer.jsp" %>
    </div>

</div>

</body>
</html>