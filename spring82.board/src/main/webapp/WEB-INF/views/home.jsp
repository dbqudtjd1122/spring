<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>   
    <p>  The time on the server is ${serverTime}. </p>
    <hr />
    
    <h2>board 게시판 만들기</h2>  
    
    <ol>
        <li><a href="./board/boardlist"  target="_blank">./board/boardlist </a></li>
        <li><a href="./board/boardview?boardcd=qna" target="_blank">./board/boardview?boardcd=qna </a></li>
        <li><a href="./board/boardview" target="_blank">./board/boardview  == ./board/boardview?boardcd=free</a></li>
        <li><a href="./board/boardview/qna" target="_blank">./board/boardview/qna</a></li>
        <li><a href="./board/boardlist" target="_blank">./board/boardlist</a>에 <a href="/board/boardview" target="_blank">./board/boardview</a> 연결하기</li>
        <li><span> <a href="/board/boardlist" target="_blank">./board/boardlist</a>에서 tr을 클릭하면 boardview 가 열리게 하시오 </span>
            <xmp>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>    
        $(document).ready( function(e){
            
            //boardlist에서 해당 게시글을 클릭하면 boardview 가 열리게 하시오
            $('div#bbs > table > tbody > tr').click( function(e){
                var boardcd = $(this).attr('boardcd');
                //window.location='/board/boardview?boardcd=' + boardcd ;
                window.location='/board/boardview/' + boardcd ;
            });
        });
    </script> 
            </xmp>        
        </li>
        <li><a href="/board/boardmodify?boardcd=qna" target="_blank">./board/boardmodify?boardcd=qna</a></li>
        <li><a href="/board/boardmodify/qna" target="_blank">./board/boardmodify/qna</a></li>
        <li><a href="/board/boardview" target="_blank">./board/boardview</a>에 ./board/boardmodify 연결하기 </li>
        <li><a href="/board/boardwrite" target="_blank">./board/boardwrite</a></li>
        <li><a href="/board/boardlist" target="_blank">./board/boardlist</a>와 <a href="/board/boardview" target="_blank">./board/boardview</a> 에 <a href="/board/boardwrite" target="_blank">boardwrite</a> 연결하기</li>
        <li><a href="/board/boardview" target="_blank">./board/boardview</a>에 ./board/boarddelete 연결하기
            <ul>
                <li>delete 는 반드시 post 방식으로 처리해야 함. get으로 하면 안됨.</li>
                <li>ajax를 이용하는 POST 방식</li>
                <li>form 을 이용하는 POST 방식</li>
            </ul>
        </li>
        <li>jsp 파일에 layout include 하기
            <ul> 
                <li> boardlist.jsp      </li>
                <li> boardmodify.jsp    </li>
                <li> boardview.jsp      </li>
                <li> boardwrite.jsp     </li>
            </ul>
            <xmp>

<div id="wrap">

    <div id="header">
        < %@ include file="../inc/header.jsp" % >
    </div>

    <div id="main-menu">
        < %@ include file="../inc/main-menu.jsp" % >
    </div> 

    <div id="container">
    </div>
        
    <div id="sidebar">
        < %@ include file="bbs-menu.jsp" % >
    </div>
    
    <div id="extra">
        < %@ include file="../inc/extra.jsp" % >
    </div>

    <div id="footer">
        < %@ include file="../inc/footer.jsp" % >
    </div> 
    
</div>            
            </xmp>
        </li>
    </ol>    
    <hr />
    
    
    <h2>article 게시판 만들기</h2>  
    <ul>
        ※ 번호순으로 액션 메서드 작성<br>
        free는 boardcd 값을, 17은 arcticleno 값을, curPage는 현재 페이지값, searchWord는 검색 단어를  의미한다.    
        <li><a href="/board/articlelist/free"  target="_blank">/board/articlelist/free</a> </li>
        <li><a href="/board/articleview/free/17?curPage=1&searchWord="    target="_blank">/board/articleview/free/17?curPage=1&amp;searchWord=</a></li>
        <li><a href="/board/articlewrite/free?curPage=1&searchWord="      target="_blank">/board/articlewrite/free?curPage=1&amp;searchWord=</a></li>
        <li><a href="/board/articlemodify/free/17?&curPage=1&searchWord=" target="_blank">/board/articlemodify/free/17?curPage=1&amp;searchWord=</a></li>
        <li><a href="/board/articledelete/free/17?curPage=1&searchWord="  target="_blank">/board/articledelete/free/17?curPage=1&amp;searchWord=</a></li>
    </ul>
    <hr />
    
    
    <h2> 첨부 파일</h2>  
    <ul>    
        <li><a href="/board/articlemodify/free/1"  target="_blank">첨부 파일 삭제 테스트</a> </li>
    </ul>
    <hr />
    
    <h2> RestController </h2>
    댓글용 rest 서비스 만들기
        <ol>
            <li>./board/commentadd    만들기 (POST) </li>
            <li>./board/commentupdate 만들기 (POST) </li>
            <li>./board/commentdelete 만들기 (POST) </li>
        </ol>
    <hr />    
    
    <h2> UploadController, DownloadController 만들기 </h2>
    <a href="./upload/fileupload"    target="_blank">./upload/fileupload </a> <br> 
    <a href="./upload/filedownload"  target="_blank">./upload/filedownload </a> <br>
    <hr />
    
    
    <h2> 테이블의 BLOB,CLOB 컬럼에 이미지 저장하고 가져오기</h2>   
    <a href="./upload/imageupload"   target="_blank">./upload/imageupload </a> <br>
    <a href="./upload/imageview/1"   target="_blank">./upload/imageview/1 </a> <br>
    <hr />
    
    
    <h2> 로그인 처리 </h2>    
    <ol>
        <li> <a href="./user/login"           target="_blank">./user/login           </a> </li>
        <li> <a href="./user/logout"          target="_blank">./user/logout          </a> </li>
        <li> <a href="./user/register"        target="_blank">./user/register        </a> </li>
        <li> <a href="./user/unregister"      target="_blank">./user/unregister      </a> </li>
        <li> <a href="./user/usermodify"      target="_blank">./user/usermodify          </a> </li>
        <li> <a href="./user/changepassword"  target="_blank">./user/changepassword  </a> </li>
    </ol>      
    <hr />
    
    
    <h2> 오류 페이지 설정 </h2>
    <ol>
        <li>web.xml 에 아래 내용 추가</li>
    </ol>
  
    <xmp>
        <!-- 에러 페이지 설정 -->
        <error-page>
            <error-code>403</error-code>
            <location>/WEB-INF/views/common/error.jsp</location>
        </error-page>
    
        <error-page>
            <error-code>404</error-code>
            <location>/WEB-INF/views/common/error/404.jsp</location>
        </error-page>
    
        <error-page>
            <error-code>500</error-code>
            <location>/WEB-INF/views/common/error/500.jsp</location>
        </error-page>  
    </xmp>
    <hr />

    <h2> RestConroller.java 만들기</h2>
    <ol>
        <li>
            <xmp>
@Controller
@RequestMapping("/restservice")
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);
    
    @Autowired
    @Qualifier("serviceboard")    
    private IServiceBoard boardsrv; 

    @Autowired
    private IServiceUser usersrv;
    
    // http://localhost/restservice/ajaxone
    @RequestMapping(value = "/ajaxone", method = RequestMethod.GET)
    public String ajaxone(Model model) {
        logger.info("RestController.ajaxone");
        return "restservice/ajaxone";       
    }
    
    // http://localhost/restservice/jsonview
    @RequestMapping(value = "/jsonview", method = RequestMethod.GET)
    public @ResponseBody ModelBoard AjaxView(@RequestParam("boardcd") String boardcd) {
        return  boardsrv.getBoardOne(boardcd);
    }
    
    // http://localhost/restservice/login
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST} )
    public @ResponseBody ModelUser login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        return usersrv.login(id, pw);
    }
}
            </xmp>
        </li>
        <li>ajaxone.jsp 작성
            <p>
                <a href="./restservice/ajaxone?id=free"    target="_blank">./restservice/ajaxone?id=free    </a> <br />
            </p>
        </li>
        <li>ajaxlist.jsp  작성
            <p>
                <a href="./restservice/ajaxlist?id=free"   target="_blank">./restservice/ajaxlist?id=free   </a> <br />
            </p>
        </li>        
    </ol>
    <hr>
   
</body>
</html>
