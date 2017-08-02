<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ page session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>captcha 테스트</title>
</head>
<body>
    <h3>captcha 테스트</h3>
    
    <form action="./write" id="writeForm" method="post">
        <fieldset>
            <legend class="screen_out">게시글 작성 폼</legend>
     
            <div class="box captcha">
                <div class="loading"></div>
                <!-- // .loading -->
     
                <label for="captcha">자동 방지 코드</label>
                <input type="text" id="captcha" name="captcha" autocomplete="off" required />
                <img src="/captcha" alt="캡차 이미지" title="클릭시 새로고침" />
            </div>
            <!-- // .box.captcha -->
     
            <div class="box btn">
                <button type="reset"  class="btn write">취소</button>
                <button type="submit" class="btn write">전송</button>
            </div>
        </fieldset>
    </form>
    
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        var $captchaLoader = $("#writeForm .box.captcha .loading");
        var $captchaImg = $("#writeForm .box.captcha img");
     
        // captcha 새로고침
        $captchaImg.click(function() {
            $captchaLoader.show();
            $(this).attr("src", "/captcha?ran=" + Math.random());
            $captchaLoader.fadeOut(500);
        });
    </script>

</body>
</html>

