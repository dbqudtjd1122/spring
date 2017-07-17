<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 상세보기" />
    <meta name="Description" content="게시판 상세보기" />
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <title>${boardNm }</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
        $(document).ready( function(e){
        	$('.boardlist').click( function(e){
        		window.location = "/board/boardlist";
        	});
            $('.boardwrite').click( function(e){
                window.location = "/board/boardwrite";
            });
            $('.boardmodify').click( function(e){
                window.location = "/board/boardmodify/${board.boardcd}" ;
            });
            $('.boarddelete').click( function(e){
                //window.location = "/board/boarddelete/${board.boardcd}" ;
                

                $.ajax({
                    url : '/board/boarddelete/${board.boardcd}',
                    data: null,        // 사용하는 경우에는 { data1:'test1', data2:'test2' }
                    type: 'post',       // get, post
                    timeout: 30000,    // 30초
                    dataType: 'text',  // text, html, xml, json, jsonp, script
                    beforeSend : function() {
                        // 통신이 시작되기 전에 이 함수를 타게 된다.
                        //$('#message1').html('<img src="./loading.gif">');
                    }
                }).done( function(data, textStatus, xhr ){
                    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                	window.location = "/board/boardlist";
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
                    //$('#message1 > img').remove();
                });
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
            <h1>Board View</h1>
            <div id="bbs">
                <table>
                    <tr>
                        <th style="text-align: left; width: 100px;">Borad Name</th>
                        <th style="text-align: left; color: #555;">${board.boardnm }</th>
                    </tr>
                    <tr>
                        <th style="text-align: left; width: 100px;">Board Code</th>
                        <th style="text-align: left; color: #555;">${board.boardcd }</th>
                    </tr>
                    <tr>
                        <th style="text-align: left; width: 100px;">Use YN</th>
                        <th style="text-align: left; color: #555;"><input type="checkbox" name="UseYN" readonly="readonly" <c:if test="${board.useYN}">checked="checked"</c:if> /> </th>
                    </tr>   
                </table>
            </div>

            <div style="text-align: left; padding-bottom: 15px;"> 
                <input type="button" class="boardlist"   value="목록" />
                <input type="button" class="boardwrite"  value="추가" />
                <input type="button" class="boardmodify" value="수정" />
                <input type="button" class="boarddelete" value="삭제" />
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