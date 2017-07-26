<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="comments" commentno="${comment.commentno }">
    <h4>${comment.email }</h4>
    <h5><fmt:formatDate pattern="yyyy-MM-dd" value="${comment.regdate }" /></h5>
    <h6>
        <a href="javascript:commentModifyShowHide('${comment.commentno }')">수정</a> 
        |
        <a href="javascript:commentdelete('${comment.commentno }')">삭제</a>
    </h6>

    <p id="comment${comment.commentno}">${comment.memo }</p>
    
    <div class="modify-comment" style="display: none;">
        <div class="fr">
                <a href="javascript:commentupdate( '${comment.commentno }' )">수정하기</a>
                | 
                <a href="javascript:commentModifyShowHide( '${comment.commentno }' )">취소</a>
        </div>
        <div>
            <textarea class="modify-comment-ta" name="memo" rows="7" cols="50">${comment.memo }</textarea>
        </div>
    </div>
</div>

<script>
    function commentModifyShowHide(commentno) {
        $('div[commentno="'+ commentno +'"]  div.modify-comment').toggle(); 
    }
    
    function commentadd(articleno, memo) {

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
