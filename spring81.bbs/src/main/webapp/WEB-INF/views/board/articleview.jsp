<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 상세보기" />
    <meta name="Description" content="게시판 상세보기" />
    
    <title>${boardnm }</title>
    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <script src="/resources/js/jquery/jquery-3.1.1.js"></script>
    <script src="/resources/js/ajaxsetup.js"></script>
    <script src="/resources/js/MyApp.board.js"></script>
    <script>
        function commentModifyShowHide(commentno) {
            $('div[commentno="'+ commentno +'"]  div.modify-comment').toggle(); 
        }

        $(document).ready(function(e){
            
            $('#paging > span[class!="bbs-strong"], .golist').click(function(e) {
                var pageno = $(this).attr('pageno');
                if( pageno === '' || pageno === undefined || pageno === null )
                	pageno = 1;
                
                window.location.href = "/board/articlelist/${boardcd}?curPage=" + pageno + "&searchWord=${searchWord}";
            });
            $('.gowrite').click(function(e) {
                window.location.href = "/board/articlewrite/${boardcd}?curPage=${curPage}&searchWord=${searchWord}";                
            });
            $('.goview').click(function(e) {
                var articleno = $(this).attr('articleno');
                window.location.href = "/board/articleview/${boardcd}/" + articleno + "?curPage=${curPage}&searchWord=${searchWord}";               
            });
            $('#gomodify').click(function(e) {
                window.location.href = "/board/articlemodify/${boardcd}/${articleno}?curPage=${curPage}&searchWord=${searchWord}";                
            });

            $('#godelete').click(function(e) {
                // POST로 "/board/articledelete" 호출하기                
                var chk = confirm('정말로 삭제하시겠습니까?');
                if (chk == true) {
                	var boardcd   = $(this).attr('boardcd'  );
                	var articleno = $(this).attr('articleno');
                	
//                 	$.ajax({
//                 	    url : '/board/articledelete'
//                 	    , data: {'boardcd': boardcd, 'articleno': articleno }   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
//                 	    , type: 'post'       // get, post
//                 	    , timeout: 30000    // 30초
//                 	    , dataType: 'json'  // text, html, xml, json, jsonp, script
//                 	}).done( function(data, textStatus, xhr ){
//                 	    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
//                 	    if( data === 1) // 삭제 성공
//                 	    	window.location.href = "/board/articlelist/${boardcd}?curPage=1&searchWord=${searchWord}";
//                 	    else  // 삭제 실패
//                 	    	alert('삭제 실패');
//                 	});
                	
                	sendPost( '/board/articledelete', 
                			{'boardcd': boardcd, 'articleno':articleno, 'curPage':${curPage}, 'searchWord':${searchWord} } );
                }
            });         
            
            $( '#addComment input[type="button"]' ).click(function(e){
                var textarea  = $('#addComment textarea');
                var memo      = $(textarea).val();
                var articleno = $(textarea).attr('articleno'); 

                return commentadd( articleno, memo );
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
            <h1>${boardnm }</h1>
            <div id="bbs">
            	<table>
                	<tr>
                		<th style="width: 50px;">TITLE</th>
                		<th style="text-align: left;color: #555;">${thisArticle.title }</th>
                		<th style="width: 50px;">DATE</th>
                		<th style="width: 130px;color: #555;"><fmt:formatDate pattern="yyyy-MM-dd" value="${thisArticle.regdate }" /></th>
                	</tr>	
            	</table>
            
            	<div id="gul-content">
            		<h6>작성자 ${thisArticle.email }, 조회수 ${thisArticle.hit }</h6>
            		<p>${thisArticle.content }</p>
            		<p id="file-list" style="text-align: right;">
            			<c:forEach var="file" items="${attachFileList }" varStatus="status">
                			<a href="javascript:download('${file.tempfilename }', '${file.filename }')">${file.filename }</a>
            			<br />
            			</c:forEach>	
            		</p>		
            	</div>
            	
            	<!--  댓글 목록 시작 -->
                <div id="commentlist">
                	<c:forEach var="comment" items="${commentList }" varStatus="status">	
                        <%@ include file="articleview-commentlistbody.jsp" %>
                	</c:forEach>
                </div>
            	<!--  댓글 목록 끝 -->
                
            	<div id="addComment">
            		<div>
            			<textarea name="memo" rows="7" cols="50" articleno="${articleno}" ></textarea>
            		</div>
            		<div style="text-align: right;">
            			<input type="button" value="댓글남기기" />
            		</div>
            	</div>
            	
            	<div id="next-prev">
            		<c:if test="${nextArticle != null }">
            			<p>다음글 : <span articleno="${nextArticle.articleno }" class="goview">${nextArticle.title }</span></p>
            		</c:if>
            		<c:if test="${prevArticle != null }">
            			<p>이전글 : <span articleno="${prevArticle.articleno }" class="goview">${prevArticle.title }</span></p>
            		</c:if>
            	</div>
            	
            	<div id="view-menu">
            		<div class="fl">
            			<input type="button" value="수정" id="gomodify" />
            			<input type="button" value="삭제" id="godelete" articleno="${articleno }"  boardcd="${boardcd }" />
            		</div>
            		
            		<div class="fr">
            		<c:if test="${nextArticle != null }">		
            			<input type="button" value="다음글" articleno="${nextArticle.articleno }" class="goview" />
            		</c:if>
            		<c:if test="${prevArticle != null }">			
            			<input type="button" value="이전글" articleno="${prevArticle.articleno }" class="goview" />
            		</c:if>
            			<input type="button" value="목록"   class="golist" pageno="${curPage }" />
            			<input type="button" value="새글쓰기" class="gowrite" />
            		</div>
            	</div>
            
                <%@ include file="articlelist-table.jsp" %>   
            	
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