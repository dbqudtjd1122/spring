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
    <script src="/resources/js/jquery-3.1.1.js"></script>

    <script type="text/javascript">    

    	function download(filename) {
    		var form = document.getElementById("downForm");
    		form.filename.value = filename;
    		form.submit();
    	}
    	 
    	function deleteAttachFile(attachfileno) {
    		var chk = confirm("정말로 삭제하시겠습니까?");
    		if (chk==true) {
    			var form = document.getElementById("deleteAttachFileForm");
    			form.attachfileno.value = attachfileno;
    			form.submit();
    		}
    	}
    
    	function goModify() {
    		var form = document.getElementById("modifyForm");
    		form.submit();
    	}
    	
    	function goDelete() {
    		var chk = confirm('정말로 삭제하시겠습니까?');
    		if (chk == true) {
    			var form = document.getElementById("deleteForm");
    			form.submit();
    		}
    	} 
        $(document).ready(function(e){
            
            $('#paging > span[class!="bbs-strong"]').click(function(e) {
                var page = $(this).attr('articleno');
                window.location.href = "/board/articlelist/${boardcd}?curPage=" + page + "&searchWord=${searchWord}";
            });
        
            function goView(articleno) {
                window.location.href = "/board/articleview/${boardcd}?curPage=${curPage}&searchWord=${searchWord}";
            }
        
            $('#list-menu > input[type="button"]').click(function(e) {
                window.location.href = "/board/articlewrite/${boardcd}?curPage=${curPage}&searchWord=${searchWord}";                
            });
            
            $( document ).ajaxStart(function() { // 통신이 시작되기 전에 이 함수를 타게 된다.
                $('body').prepend('<img src="/resources/images/loading.gif">');
            });
            $( document ).ajaxComplete(function( event,request, settings ) { // 통신이 실패하든 성공하든 종료되면 이 함수를 타게 된다.
                $('body img[src$="loading.gif"]').remove();
            });
            $( document ).ajaxError(function() {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                var msg ='';
                msg += "code:"    + xhr.status         + "\n";
                msg += "message:" + xhr.responseText   + "\n";
                msg += "status:"  + textStatus         + "\n";
                msg += "error  : "+ error              + "\n";
    
                console.log(msg);
            });            
            
            
            $( '#addComment input[type="button"]' ).click(function(e){
                var textarea  = $('#addCommentForm textarea');
                var memo      = $(textarea).val();
                var articleno = $(textarea).attr('articleno');              

                $.ajax({
                    url : '/board/commentaddajax',
                    data: { 'articleno': articleno, 'memo': memo },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
                    type: 'post',       // get, post
                    timeout: 30000,     // 30초
                    dataType: 'html',   // text, html, xml, json, jsonp, script
                }).done( function(data, textStatus, xhr ){
                    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                    if(data != null ){
                        $('#commentlist').append( data );
                        $(textarea).val('');
                    }
                    else {
                        alert( '댓글 삭제 실패');
                    }
                });
                
                return false;
            });
        });
        
        function commentModifyShowHide(commentno) {
            $('div[commentno="'+ commentno +'"]  div.modify-comment').toggle(); 
        }
        
        function commentupdate(commentno) {
            var textarea = $('div[commentno="' + commentno + '"] textarea');
            
            $.ajax({
                url : '/board/commentupdateajax',
                data: { 'commentno': commentno, 'memo' : $(textarea).val() },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
                type: 'post',       // get, post
                timeout: 30000,     // 30초
                dataType: 'html',   // text, html, xml, json, jsonp, script
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if(data == 1 ){
                    $('#comment'+commentno).text( $(textarea).val() );
                    commentModifyShowHide(commentno);
                }
                else {
                    alert( '댓글 수정 실패');
                }
            });
            
            return false;
        }
        
        function commentdelete(commentno) {
            var chk = confirm("정말로 삭제하시겠습니까?");
            if (chk==true) {
    
                $.ajax({
                    url : '/board/commentdeleteajax',
                    data: { 'commentno': commentno },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
                    type: 'post',       // get, post
                    timeout: 30000,    // 30초
                    dataType: 'json',  // text, html, xml, json, jsonp, script
                }).done( function(data, textStatus, xhr ){
                    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                    if(data > 0){
                        $('div[commentno="' + commentno +'"]').remove();
                    }
                    else {
                        alert( '댓글 삭제 실패');
                    }
                });
                
                return false;
            }
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
			<div id="url-navi">BBS</div>
            
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
                			<a href="javascript:download('${file.filename }')">${file.filename }</a>
                			<a href="javascript:deleteAttachFile('${file.attachfileno }')">x</a>
            			<br />
            			</c:forEach>	
            		</p>		
            	</div>
            	
            	<!--  덧글 반복 시작 -->
                <div id="commentlist">
                	<c:forEach var="comment" items="${commentList }" varStatus="status">	
                        <%@ include file="articleview-commentlistbody.jsp" %>
                	</c:forEach>
                </div>
            	<!--  덧글 반복 끝 -->
                
            	<div id="addComment">
            		<div>
            			<textarea name="memo" rows="7" cols="50" articleno="${articleno}" ></textarea>
            		</div>
            		<div style="text-align: right;">
            			<input type="button" value="덧글남기기" />
            		</div>
            	</div>
            	
            	<div id="next-prev">
            		<c:if test="${nextArticle != null }">
            			<p>다음글 : <a href="javascript:goView('${nextArticle.articleno }')">${nextArticle.title }</a></p>
            		</c:if>
            		<c:if test="${prevArticle != null }">
            			<p>이전글 : <a href="javascript:goView('${prevArticle.articleno }')">${prevArticle.title }</a></p>
            		</c:if>
            	</div>
            	
            	<div id="view-menu">
            		<div class="fl">
            			<input type="button" value="수정" onclick="goModify();" />
            			<input type="button" value="삭제" onclick="goDelete()" />
            		</div>
            		
            		<div class="fr">
            		<c:if test="${nextArticle != null }">		
            			<input type="button" value="다음글" onclick="goView('${nextArticle.articleno }')" />
            		</c:if>
            		<c:if test="${prevArticle != null }">			
            			<input type="button" value="이전글" onclick="goView('${prevArticle.articleno }')" />
            		</c:if>
            			<input type="button" value="목록" onclick="goList('${curPage }')" />
            			<input type="button" value="새글쓰기" onclick="goWrite()" />
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

<div id="form-group" style="display: none;">
	<form id="downForm" action="/download" method="post">
		<p>
			<input type="hidden" name="filename" />
		</p>
	</form>
	<form id="modifyForm" action="./articlemodify" method="get">
		<p>
			<input type="hidden" name="articleno" value="${articleno }" />
			<input type="hidden" name="boardcd" value="${boardcd }" />
			<input type="hidden" name="curPage" value="${curPage }" />
			<input type="hidden" name="searchWord" value="${searchWord }" />
		</p>
	</form>
	<form id="deleteForm" action="./articledelete" method="post">	
		<p>
			<input type="hidden" name="articleno" value="${articleno }" />
			<input type="hidden" name="boardcd" value="${boardcd }" />
			<input type="hidden" name="curPage" value="${curPage }" />
			<input type="hidden" name="searchWord" value="${searchWord }" />
		</p>
	</form>
	<form id="deleteCommentForm" action="./commentdel" method="post">
		<p>
			<input type="hidden" name="commentno" />
			<input type="hidden" name="articleno" value="${articleno }" />
			<input type="hidden" name="boardcd" value="${boardcd }" />
			<input type="hidden" name="curPage" value="${curPage }" />
			<input type="hidden" name="searchWord" value="${searchWord }" />
		</p>
	</form>	
	<form id="deleteAttachFileForm" action="./attachFileDel" method="post">
		<p>
			<input type="hidden" name="attachfileno" />
			<input type="hidden" name="articleno" value="${articleno }" />
			<input type="hidden" name="boardcd" value="${boardcd }" />
			<input type="hidden" name="curPage" value="${curPage }" />
			<input type="hidden" name="searchWord" value="${searchWord }" />
		</p>
	</form>	
</div>

</body>
</html>