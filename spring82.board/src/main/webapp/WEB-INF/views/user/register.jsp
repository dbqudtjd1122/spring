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
    <script src="/resources/js/jquery/jquery-3.1.1.js"></script>
    <script src="/resources/js/ajaxsetup.js"></script>
    <script src="/resources/js/MyApp.board.js"></script>
    <script>
        $(document).ready( function(e){
            $('#checkuserid').click( function(e){
            	var userid = $('#userid').val();
            	$.ajax({
            	      url : '/user/checkuserid'
            	    , data: {'userid' : userid }          // 사용하는 경우에는 { data1:'test1', data2:'test2' }
            	    , type: 'get'       // get, post
            	    , timeout: 30000    // 30초
            	    , dataType: 'json'  // text, html, xml, json, jsonp, script
            	}).done( function(data, textStatus, xhr ){
            	    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            	    if( data === 1 ){
            	    	alert('존재하는 id');
            	    }
            	    else {
                        alert('사용한 가능한 id'); 
                        $('#signUpForm  input').prop('disabled', false);
            	    }
            	});
            });
            
            $("#fafafa").click(function(e){

                var list = $('.req_input');

                for( var i=0; i< list.length; i= i+1){

                    if( $( list[i] ).val() === '' ) {
                        list[i].focus();

                        if( $(list[i]).next().length == 0 ) {
                            $(list[i]).after('<label>입력하세요</label>');
                        }

                        return false;
                    }
                }

                // 패스워드 동일 여부체크
                if( $('input:password[name="passwd"]').val() === $('input:password[name="confirm"]').val() ) {
                    // submit 호출 : form 의 action 이 실행됨.
                    $('#signUpForm').submit();     
                } 
                else {
                    alert('패스워드가 다릅니다.'); 
                    return false;
                }
            });
    
            $('.req_input').keyup( function (e) {
                if( $(this).val() !== '') {
                    $(this).next('label').remove();
                }
            });
        });

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
            <form id="signUpForm" action="/user/register" method="post" >
                <table>
                    <tr>
                        <td style="width: 200px;">사용자 아이디</td>
                        <td style="width: 390px">
                            <input type="text" name="userid" style="width: 70%;" id="userid" class="req_input" />
                            <input type="button" value="아이디 중복 조회" id="checkuserid"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 200px;">이름(Full Name)</td>
                        <td style="width: 390px"><input type="text" name="name" style="width: 99%;" disabled="disabled" class="req_input" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" style="width: 99%;" disabled="disabled" class="req_input" /></td>
                    </tr>
                    <tr>
                        <td>비밀번호(Password)</td>
                        <td><input type="password" name="passwd" style="width: 99%;" disabled="disabled" class="req_input" /></td>
                    </tr>
                    <tr>
                        <td>비밀번호 확인(Confirm)</td>
                        <td><input type="password" name="confirm" style="width: 99%;" disabled="disabled" class="req_input" /></td>
                    </tr>
                    <tr>
                        <td>이동전화(Mobile)</td>
                        <td><input type="text" name="mobile" style="width: 99%;" disabled="disabled" class="req_input" /></td>
                    </tr>
                </table>
                <div style="text-align: center;padding-bottom: 15px;">
                    <input type="button" value="확인" id="fafafa" />
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