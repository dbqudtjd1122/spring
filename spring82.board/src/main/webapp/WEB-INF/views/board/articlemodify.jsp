<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 수정하기 폼" />
    <meta name="Description" content="게시판 수정하기 폼" />
    
    <title>${boardnm }</title>
    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <script src="/resources/js/jquery/jquery-3.1.1.js"></script>
    <script src="/resources/js/ajaxsetup.js"></script>
    <script src="/resources/js/MyApp.board.js"></script>
    <script>      
        $(document).ready(function(e){            
            $('.golist').click(function(e) {
                window.location.href = "/board/articlelist/${boardcd}?curPage=${curPage}&searchWord=${searchWord}";
            });
            
            $('.goview').click(function(e) {
                window.location.href =  "/board/articleview/${boardcd}/${articleno}?curPage=${curPage}&searchWord=${searchWord}";
            });
            
            $("#articlesubmit").click(function(e){

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
			<%@ include file="../inc/header.jsp"%>
		</div>

		<div id="main-menu">
			<%@ include file="../inc/main-menu.jsp"%>
		</div>

		<div id="container">
			<div id="content" style="min-height: 800px;">
				

				<!-- 본문 시작 -->
				<h1>${boardnm }</h1>
				<div id="bbs">
					<h2>수정</h2>
					<form id="modifyForm" action="articlemodify" method="post" enctype="multipart/form-data">
						<p style="margin: 0; padding: 0;">
							<input type="hidden" name="articleno"  value="${articleno }" />
							<input type="hidden" name="boardcd"    value="${boardcd }" />
							<input type="hidden" name="curPage"    value="${curPage }" />
							<input type="hidden" name="searchWord" value="${searchWord }" />
						</p>
						<table id="write-form">
							<tr>
								<td>제목</td>
								<td><input type="text" name="title" size="50" class="req_input"
									value="${thisArticle.title }" /></td>
							</tr>
                            <tr>
                                <td>이메일</td>
                                <td><input type="text" name="email" size="50" class="req_input"
                                    value="${thisArticle.email }" /></td>
                            </tr>
							<tr>
								<td colspan="2">
                                    <textarea name="content" rows="17" class="req_input" >${thisArticle.content }</textarea>
								</td>
							</tr>        
                            <tr>
                                <td>첨부 파일 목록</td>
                                <td id="attachfile">
                                    <c:forEach var="file" items="${attachFileList }" varStatus="status">
                                        <span>
                                           ${file.filename }
                                           <a href="javascript:deleteAttachFile('${file.attachfileno }')" attachfileno="${file.attachfileno }">x</a>
                                           <br />
                                       </span>
                                    </c:forEach>
                                </td>
                            </tr>
							<tr>
								<td>파일첨부</td>
								<td><input type="file" name="uploadfile" /></td>
							</tr>
						</table>
						<div style="text-align: center; padding-bottom: 15px;">
							<input type="button" value="전송"     id="articlesubmit"/> 
							<input type="button" value="상세보기" class="goview" /> 
							<input type="button" value="목록"     class="golist" />
						</div>
					</form>

				</div>
				<!-- bbs 끝 -->
				<!--  본문 끝 -->
			</div>
			<!-- content 끝 -->
		</div>
		<!--  container 끝 -->

		<div id="sidebar">
			<%@ include file="bbs-menu.jsp"%>
		</div>

		<div id="extra">
			<%@ include file="../inc/extra.jsp"%>
		</div>

		<div id="footer">
			<%@ include file="../inc/footer.jsp"%>
		</div>

	</div>

</body>
</html>