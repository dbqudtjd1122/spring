/**
 * 
 */

var MyApp = {};

var download = function download(filename) {
	var form = document.getElementById("downForm");
	form.filename.value = filename;
	form.submit();
};
 
var deleteAttachFile = function deleteAttachFile(attachfileno) {
	var chk = confirm("정말로 삭제하시겠습니까?");
	if (chk==true) {

	    $.ajax({
	        url : '/board/attachfiledelete',
	        data: { 'attachfileno': attachfileno },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
	        type: 'post',       // get, post
	        timeout: 30000,     // 30초
	        dataType: 'html',   // text, html, xml, json, jsonp, script
	    }).done( function(data, textStatus, xhr ){
	        // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
	        if(data === "1" ){
	           $('#attachfile  a[attachfileno="' + attachfileno + '"]').parent().remove();
	        }
	        else {
	            alert( '댓글 삭제 실패');
	        }
	    });
	    
	    return false;
	}
};

var commentadd = function commentadd(articleno, memo) {

    $.ajax({
        url : '/board/commentadd',
        data: { 'articleno': articleno, 'memo': memo },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
        type: 'post',       // get, post
        timeout: 30000,     // 30초
        dataType: 'html',   // text, html, xml, json, jsonp, script
    }).done( function(data, textStatus, xhr ){
        // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
        if(data != null ){
            $('#commentlist').append( data );
            $('#addComment textarea').val('');
        }
        else {
            alert( '댓글 추가 실패');
        }
    });
    
    return false;
}

var commentupdate = function commentupdate(commentno) {
    var textarea = $('div[commentno="' + commentno + '"] textarea');
    
    $.ajax({
        url : '/board/commentupdate',
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

var commentdelete = function commentdelete(commentno) {
    var chk = confirm("정말로 삭제하시겠습니까?");
    if (chk==true) {

        $.ajax({
            url : '/board/commentdelete',
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