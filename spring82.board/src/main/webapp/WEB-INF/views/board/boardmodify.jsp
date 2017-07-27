<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="수정하기 폼" />
    <meta name="Description" content="수정하기 폼" />
    <title>${boardnm }</title>
    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <script src="/resources/js/jquery/jquery-3.1.1.js"></script>
    <script src="/resources/js/ajaxsetup.js"></script>
    <script>    
        $(document).ready( function(e){
        	
        	$("#boardlist").click(function(e){
                window.location='/board/boardlist' ;
        	});
            $("#boardview").click(function(e){
                window.location='/board/boardview/${board.boardcd}' ;
            });
            $("#boardsubmit").click(function(e){

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

                   // submit 호출 : form 의 action 이 실행됨.
                   $('#modifyForm').submit();
           });

           $('.req_input').keyup( function (e) {
               if( $(this).val() !== '') {
                   $(this).next().remove();
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
                <div id="bbs">
                    <h2>수정</h2>
                    <form id="modifyForm" action="/board/boardmodify" method="post" enctype="application/x-www-form-urlencoded">
                        <div>                        
                            <p style="margin: 0; padding: 0;">
                                Borad Code :
                                <input type="text" id="boardcd"  name="boardcd"  value="${board.boardcd}" readonly="readonly" class="req_input" />
                            </p>
                        </div>
                        
                        <div>
                            <p style="margin: 0; padding: 0;">
                                Board Name : 
                                <input type="text" id="boardnm"  name="boardnm" value="${board.boardnm}"  class="req_input" />
                            </p>
                        </div>
                        
                        <div>
                            <p style="margin: 0; padding: 0;">
                                Use YN : 
                                <input type="checkbox" id="UseYN" name="UseYN" <c:if test="${board.useYN}">checked="checked"</c:if> />
                            </p>
                        </div>

                        <div style="text-align: left; padding-bottom: 15px;">
                            <input type="button" value="전송"     id="boardsubmit"/> 
                            <input type="button" value="상세보기" id="boardview" /> 
                            <input type="button" value="목록"     id="boardlist" />
                            <input type="reset"  value="취소" />
                        </div>
                    </form>
                </div>
                <!--  본문 끝 -->

            </div>
            <!-- content 끝 -->
            
        </div>
        <!--  container 끝 -->

        <div id="sidebar">
            <%@ include file="bbs-menu.jsp" %>
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