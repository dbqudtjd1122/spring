/**
 * 
 */

$( document ).ajaxStart(function() { // 통신이 시작되기 전에 이 함수를 타게 된다.
    $('body').prepend('<img src="/resources/images/loading.gif">');
});
$( document ).ajaxComplete(function( event,request, settings ) { // 통신이 실패하든 성공하든 종료되면 이 함수를 타게 된다.
    $('body img[src$="loading.gif"]').remove();
});
$( document ).ajaxError(function(xhr, textStatus, error) {
    // 통신이 실패했을 때 이 함수를 타게 된다.
    var msg ='';
    msg += "code:"    + xhr.status         + "\n";
    msg += "message:" + xhr.responseText   + "\n";
    msg += "status:"  + textStatus         + "\n";
    msg += "error  : "+ error              + "\n";

    console.log(msg);
});  