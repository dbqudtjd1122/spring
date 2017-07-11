<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
    <style>

    </style>
</head>
<body>   
    <p>  The time on the server is ${serverTime}. </p>
    <hr />
    
    <dl>
        <dt>ckeditor </dt>
        <dd> <a href="./resources/js/ckeditor/samples/index.html"  target="_blank">샘플 예제 /js/ckeditor/samples/index.html</a> </dd>    
        <dd> <a href="./ckeditor"        target="_blank">연습 예제 1 : JavaScript</a> </dd>
        <dd> <a href="./ckeditor2"       target="_blank">연습 예제 2 : jQuery    </a> </dd>
    </dl>
    
    <hr />
   
    <div id="include_import">        
        <pre>
ckeditor
    FCKEditor이 변경된 이름.
    게시물 작성시 위지위그(WYSIWYG ; What You See IsWhat You Get) 기능을 제공. 
    직접 HTML 코드를 편집할 필요 없이 Microsoft Word를사용하는 것과 같이 
    드래그 및 버튼의 클릭만으로 HTML 코드를 자동으로 편집해주는 기능을 제공합니다. 

    CKEditor는 자바스크립트 기반의 소스이므로 어떤 환경에서도 설치할 수 있습니다.
    
    http://ckeditor.com/에서 CKEditor의 다운로드 받으실 수 있습니다.        
                

1.  다운로드
http://ckeditor.com/download 를 통해서 CKEditor의 최신버전을 다운로드 받으실 수 있습니다.
 

2.  Sample 및 사용방법 숙지를 위한 페이지

&lt;WEB server address&gt;/&lt;installCKEditor path&gt;/sample/index.html 을 통해서 Sample page로 접속할 수 있습니다. 
web폴더 밑에 editor라는 새로운 폴더를 만들어 CKEditor의 압축을 풀었습니다. 
따라서 http://localhost:8080/web/js/ckeditor/_samples/index.html
이러한 경로로 Sample page에 접속할 수 있습니다.


3.   연동방법

1)   기본설정

CKEditor는 Javascript로 구현되므로 기본적으로 추가해줘야 하는 javascript파일을 불러옵니다.
&lt;script src="${JS}/ckeditor/ckeditor.js"&gt;&lt;/script&gt;

 

2) id를 이용한 CKEditor 붙이기.

Textarea에 CKEditor를 붙이는 방법에는 id나 class를 사용하는 방법이 있는데 id 명으로 사용하는 것이 가장 단순하다.
    &lt;script src="${JS}/ckeditor/ckeditor.js"&gt;&lt;/script&gt;
    &lt;script type="text/javascript"&gt;
        window.onload =function() { CKEDITOR.replace( 'EDITOR가 삽입될 textarea의 ID 이름을 입력' ); };
    &lt;/script&gt;

    &lt;div id="editor1" name="inputArticleContents"&gt;&lt;/div&gt;
     
와 같이 사용하면 다음에 소개할 javascript의 부가적인 추가 없이도 사용할 수 있습니다.


3) class를 이용한 CKEditor 붙이기. 
    &lt;script src="${JS}/ckeditor/ckeditor.js" &gt; &lt;/script&gt;
    &lt;textarea name="inputArticleContents" class="ckeditor" rows="20" cols="50"&gt;
    &lt;/textarea&gt; 


4) ${JS}/ckeditor/config.js 파일 설정 방법

전체 Editor에적용되기를 원하는 내용이라면 config 파일에 이런식으로 설정하시면 됩니다.

config.font_defaultLabel = 'Gulim';
config.font_names='Gulim/Gulim;Dotum/Dotum;Batang/Batang;Gungsuh/Gungsuh;Arial/Arial;Tahoma/Tahoma;Verdana/Verdana';
config.fontSize_defaultLabel = '12px';
config.fontSize_sizes='8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;';
config.language = "ko";
config.enterMode =CKEDITOR.ENTER_BR;
config.shiftEnterMode = CKEDITOR.ENTER_P;
config.startupFocus = true;
config.uiColor = '#EEEEEE';
config.toolbar = [['Bold','Italic','Underline','Strike','-','Subscript','Superscript','-','TextColor','BGColor','-',
                   'JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','Link','Unlink','-',
                   'Find','Replace','SelectAll','RemoveFormat','-','Image','Flash','Table','SpecialChar'],
                   '/',['Source','-','ShowBlocks','-','Font','FontSize','Undo','Redo','-','About']];


CKEditor에 대해 추가적으로궁금한 사항을 찾아보고 싶으시다면, 제공되는 API인 
http://docs.cksource.com/ckeditor_api/을 통해 찾아보실 수 있습니당~ 


--------------------------------
출처: http://ojava.tistory.com/1                
        </pre>        
    </div>
</body>
</html>