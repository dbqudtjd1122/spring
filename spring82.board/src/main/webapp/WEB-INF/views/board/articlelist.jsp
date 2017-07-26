<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 목록" />
    <meta name="Description" content="게시판 목록" />    
    <title>${boardnm }</title>    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
    
    function goView(articleno) {
        window.location.href = "/board/articleview/${boardcd}/" + articleno + "?curPage=${curPage}&searchWord=${searchWord}";
    }
    
    $(document).ready(function(e){
    	
    	$('#paging > span[class!="bbs-strong"]').click(function(e) {
    		var page = $(this).attr('articleno');
    		window.location.href = "/board/articlelist/${boardcd}?curPage=" + page + "&searchWord=${searchWord}";
    	});
    
		$('#list-menu > input[type="button"]').click(function(e) {
            window.location.href = "/board/articlewrite/${boardcd}?curPage=${curPage}&searchWord=${searchWord}";    			
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
			<div id="url-navi">BBS</div>
                
                <!-- 본문 시작 -->			
                <h1>${boardnm }</h1>
                <div id="bbs">
                	<%@ include file="articlelist-table.jsp" %>                	
                </div>
                <!--  본문 끝 -->

		</div><!-- content 끝 -->
	</div><!--  container 끝 -->
	
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