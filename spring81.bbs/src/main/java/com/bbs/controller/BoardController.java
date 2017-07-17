package com.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bbs.commons.*;
import com.bbs.model.*;
import com.bbs.service.*;

@Controller
@RequestMapping("/board")
public class BoardController  {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    
    @Autowired
    @Qualifier("serviceboard")
	private IServiceBoard boardsrv; 
    public IServiceBoard getBoardsrv() { return boardsrv; } 
    public void setBoardsrv(IServiceBoard boardsrv) { this.boardsrv = boardsrv; } 
	
    public BoardController() {
        super();
    }

    /**
	 * http://localhost/board/boardlist
	 */
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
    public String boardlist(Model model)  {

        logger.info("BoardController.boardlist");
		
		List<ModelBoard> list = boardsrv.getBoardList();
        
        model.addAttribute("list", list);

        return "board/boardlist";
    }
	
    /**
     * http://localhost/board/boardview?boardcd=qna
     */
    @RequestMapping(value = "/boardview", method = RequestMethod.GET)
    public String boardview( 
		  @RequestParam(value="boardcd", required = false, defaultValue = "free") String boardcd 
        , @RequestParam(value="boardnm", required = false, defaultValue = ""    ) String boardnm
		, HttpServletRequest request
		, Model model ) {

        logger.info("BoardController.boardview");

        boardcd = request.getParameter("boardcd");

        if( StringUtils.isEmpty(boardcd) ) boardcd = "free";

        // DB 처리
        ModelBoard board =  boardsrv.getBoardOne(boardcd);
        
        // 모델 바인딩
        model.addAttribute("boardNm", board.getBoardnm() );
        model.addAttribute("board"  ,  board );

        return "board/boardview";
    }

    
    @RequestMapping(value="/boardview/{boardcd}", method=RequestMethod.GET)
    public String boardviewPath( 
		  @PathVariable(value="boardcd")  String boardcd 
		, Model model) {

        logger.info("BoardController.boardview"); 
                
        // DB 처리
		ModelBoard board =  boardsrv.getBoardOne(boardcd);
        
        // 모델 바인딩        
        model.addAttribute("boardNm", board.getBoardnm() );
        model.addAttribute("board"  , board );

        return "board/boardview";
    }
    

    /**
     * http://localhost/board/boardmodify?boardcd=qna
     */
    @RequestMapping(value = "/boardmodify", method = RequestMethod.GET)
    public String boardmodify(
	    	  HttpServletRequest request
            , @RequestParam(value="boardcd")  String boardcd
            , Model model) {

        logger.info("BoardController.boardmodify");

        boardcd = request.getParameter("boardcd");        
        if( StringUtils.isEmpty(boardcd) ) boardcd = "free";
        
        String actionurl = request.getRequestURL().toString();

        // DB 처리  
        ModelBoard board = boardsrv.getBoardOne(boardcd);
                
        model.addAttribute("boardnm"   , board.getBoardnm() );
        model.addAttribute("actionurl" , actionurl );
        model.addAttribute("model"     , board );

        return "board/boardmodify";
    }
    
    /**
     * http://localhost/board/boardmodify?boardcd=qna
     */
    @RequestMapping(value = "/boardmodify", method = RequestMethod.POST)
    public String boardmodify( 
		  HttpServletRequest request
		, @ModelAttribute ModelBoard board
		, Model model )  {

        logger.info("BoardController.boardmodify");

        ModelBoard updateBoard = new ModelBoard();
        updateBoard.setBoardnm(  board.getBoardnm()  );
        updateBoard.setUseYN  (  board.getUseYN() == null ? false:  board.getUseYN()  );
        
        ModelBoard searchBoard = new ModelBoard();
        searchBoard.setBoardcd(  board.getBoardcd()  );
                
        // 디비 업데이트
        int result = boardsrv.updateBoard(updateBoard, searchBoard);
        
        if( result > 0 ) {
            // http://localhost/board/boardlist 가 출력되게. redirect 를 이용 
            return "redirect:/board/boardlist";       
        }
        else {
            // http://localhost/board/boardmodify?boardcd=qna
            return "redirect:/board/boardmodify?boardcd=" + board.getBoardcd() ;  
        }
    }
    

    /**
     * http://localhost/board/boardmodify/qna
     */
    @RequestMapping(value = "/boardmodify/{boardcd}", method = RequestMethod.GET)
    public String boardmodifyPath(
              HttpServletRequest request
            , @PathVariable(value="boardcd")  String boardcd
            , Model model) {

        logger.info("BoardController.boardmodifyPath");
        
        String actionurl = request.getRequestURL().toString();

        // DB 처리  
        ModelBoard board = boardsrv.getBoardOne(boardcd);
                
        model.addAttribute("boardnm"   , board.getBoardnm() );
        model.addAttribute("actionurl" , actionurl );
        model.addAttribute("model"     , board );

        return "board/boardmodify";
    }
    

    /**
     * http://localhost/board/boardview/qna
     */
    @RequestMapping(value = "/boardmodify/{boardcd}", method = RequestMethod.POST)
    public String boardmodifyPath( 
          HttpServletRequest request
        , @PathVariable(value="boardcd")  String boardcd
        , @ModelAttribute("board") ModelBoard board
        , Model model )  {

        logger.info("BoardController.boardmodifyPath");

        ModelBoard updateBoard = new ModelBoard();
        updateBoard.setBoardnm(  board.getBoardnm()  );
        updateBoard.setUseYN  (  board.getUseYN() == null ? false:  board.getUseYN()  );
        
        ModelBoard searchBoard = new ModelBoard();
        searchBoard.setBoardcd(  board.getBoardcd()  );
                
        // 디비 업데이트
        int result = boardsrv.updateBoard(updateBoard, searchBoard);
        
        if( result > 0 ) {
            // http://localhost/board/boardlist 가 출력되게. redirect 를 이용 
            return "redirect:/board/boardlist";       
        }
        else {
            // http://localhost/board/boardmodify?boardcd=qna
            return "redirect:/board/boardmodify/" + board.getBoardcd() ;  
        }
    }
    

    /**
     * http://localhost/board/boardwrite
     */
    @RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
    public String boardwrite(Model model)  {

        logger.info("BoardController.boardwrite");

        return "board/boardwrite";
    }
    @RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
    public String boardwrite(@ModelAttribute ModelBoard board, Model model)  {

        logger.info("BoardController.boardwrite");
        
        // DB 처리
        boardsrv.insertBoard(board);

        // http://localhost/board/boardlist 가 출력되게. redirect 를 이용 
        return "redirect:/board/boardlist";
        //return "redirect:/board/boardlist?boardcd=" + board.getBoardcd();
    }
    

    @RequestMapping(value = "/boarddelete/{boardcd}", method = { RequestMethod.POST } )
    public String boarddelete(  @PathVariable(value="boardcd") String boardcd,  Model model)  {

        logger.info("BoardController.boarddelete");
        
        ModelBoard board = new ModelBoard();
        board.setBoardcd(boardcd);
        
        // DB 처리
        int result = boardsrv.deleteBoard(board);

        if( result > 0 ) {
            // http://localhost/board/boardlist 가 출력되게. redirect 를 이용 
            return "redirect:/board/boardlist";       
        }
        else {
            // http://localhost/board/boardview/qna
            return "redirect:/board/boardview/" + boardcd ;  
        }
    }
    


    /**
     * http://localhost/board/articlelist?boardcd=qna&curPage=1&searchWord=
     */
	@RequestMapping(value="/articlelist", method={RequestMethod.GET, RequestMethod.POST})
    public String articlelist( @RequestParam(value="boardcd"   , required = false, defaultValue = "free") String boardcd
                             , @RequestParam(value="curPage"   , required = false, defaultValue = "1"   ) Integer curPage
                             , @RequestParam(value="searchWord", required = false, defaultValue = ""    ) String searchWord 
                             , Model model) {
	    
        logger.info("BoardController.articlelist");
        
        // 페이지당 출력할 레코드 수
        int numberPerPage = 10;
        
        // 페이징시 나타낼 페이지 수
        int pagePerBlock = 10;
        
        // 전체 게시글 갯수 가져오기
        int totalRecord = boardsrv.getArticleTotalRecord(boardcd, searchWord);
        
        // 페이지 처리
        PagingHelper paging = new PagingHelper(totalRecord, curPage, numberPerPage, pagePerBlock);        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        String boardnm = boardsrv.getBoardName(boardcd);
        model.addAttribute("boardNm", boardnm);		

        model.addAttribute("curPage"   , curPage   ); 
        model.addAttribute("boardcd"   , boardcd   ); 
        model.addAttribute("searchWord", searchWord); 
        
        List<ModelArticle> articleList = boardsrv.getArticleList(boardcd, searchWord, start, end );
        model.addAttribute("articleList", articleList);
		model.addAttribute("no"         , paging.getListNo()    );
        model.addAttribute("prevLink"   , paging.getPrevLink()  );
        model.addAttribute("nextLink"   , paging.getNextLink()  );
        model.addAttribute("prevPage"   , paging.getFirstPage() );
        model.addAttribute("nextPage"   , paging.getLastPage()  );
        model.addAttribute("pageLinks"  , paging.getPageLinks() );      

        return "board/articlelist";
    }
	


    /**
     * http://localhost/board/articlewrite?boardcd=qna&curPage=1&searchWord=
     */
	@RequestMapping(value = "/articlewrite", method = RequestMethod.GET)
    public String articlewrite(Model model
            , @RequestParam(value="boardcd"   , defaultValue="free") String boardcd
            , @RequestParam(value="curPage"   , defaultValue="1"   ) Integer curPage 
            , @RequestParam(value="searchWord", defaultValue=""    ) String searchWord  ) {
        logger.info("BoardController.articlewrite");
    
		//게시판 이름        
		String boardNm = boardsrv.getBoardName(boardcd);
		model.addAttribute("boardNm"   , boardNm);
		
		model.addAttribute("boardcd"   , boardcd);
		model.addAttribute("curPage"   , curPage);
		model.addAttribute("searchWord", searchWord);
		
        return "board/articlewrite";      
    }


    /**
     * http://localhost/board/articlewrite
     */
    
   @RequestMapping(value = "/articlewrite", method = RequestMethod.POST)
    public String articlewrite(Model model
            , @ModelAttribute ModelArticle article
            , MultipartFile upload ) throws IllegalStateException, IOException {
       
        logger.info("BoardController.articlewrite");
        
        // article insert
        int articleno = boardsrv.insertArticle(article);
               
        // 로컬 첨부 파일을 서버로 올리기 위한 코드
        String fileName = upload.getOriginalFilename();
        String filepath = WebConstants.UPLOAD_PATH + "/" + fileName;                 
        File f = new File( filepath );                
        upload.transferTo( f );
        
        // 첨부 파일 insert 처리를 위한 코드
        ModelAttachfile attachfile = new ModelAttachfile();
        attachfile.setFilename( f.getName() );
        attachfile.setFiletype( FilenameUtils.getExtension(fileName) ); // 확장자
        attachfile.setFilesize( (int)f.length() );
        attachfile.setArticleno( articleno );
        boardsrv.insertAttachFile( attachfile );
    		
		return "redirect:/board/articlelist?boardcd=" + article.getBoardcd();
	}

	// http://localhost/board/articleview?articleno=17&boardcd=free&curPage=1&searchWord=
	@RequestMapping(value="/articleview", method=RequestMethod.GET)
	public String articleview(
	          @RequestParam(value="articleno" , defaultValue="") Integer articleno 
			, @RequestParam(value="boardcd"   , defaultValue="") String boardcd 
			, @RequestParam(value="curPage"   , defaultValue="") Integer curPage
			, @RequestParam(value="searchWord", defaultValue="") String searchWord 
			, Model model)  {

		// 검색어가 null 이면 ""으로 변경	
		if (searchWord == null) searchWord = "";

		// 페이지당 레코드 수 지정
		int numPerPage = 10;
		
		// 페이지 링크의 그룹(block)의 크기 지정
		int pagePerBlock = 10;
				
		//상세보기 
		ModelArticle thisArticle = boardsrv.getArticle(articleno);
		List<ModelAttachfile> attachFileList = boardsrv.getAttachFileList(articleno);
		List<ModelComments> commentList = boardsrv.getCommentList(articleno);
		ModelArticle nextArticle = boardsrv.getNextArticle(articleno, boardcd, searchWord);
		ModelArticle prevArticle = boardsrv.getPrevArticle(articleno, boardcd, searchWord);
		
		//목록보기
		int totalRecord = boardsrv.getArticleTotalRecord(boardcd, searchWord);
		PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);

		int start = pagingHelper.getStartRecord();
		int end   = pagingHelper.getEndRecord();

		List<ModelArticle> list = boardsrv.getArticleList(boardcd, searchWord, start, end);
		Integer no        = pagingHelper.getListNo();
		Integer prevLink  = pagingHelper.getPrevLink();
		Integer nextLink  = pagingHelper.getNextLink();
		Integer firstPage = pagingHelper.getFirstPage();
		Integer lastPage  = pagingHelper.getLastPage();
		int[] pageLinks   = pagingHelper.getPageLinks();

        String boardNm    = boardsrv.getBoardName(boardcd);
        model.addAttribute("boardNm"        , boardNm   );
        
		model.addAttribute("thisArticle"    , thisArticle    );
		model.addAttribute("attachFileList" , attachFileList );
		model.addAttribute("commentList"    , commentList    );
		model.addAttribute("nextArticle"    , nextArticle    );
		model.addAttribute("prevArticle"    , prevArticle    );

		// 목록을 위한 데이터
		model.addAttribute("list"           , list      );
		model.addAttribute("no"             , no        );
		model.addAttribute("prevLink"       , prevLink  );
		model.addAttribute("nextLink"       , nextLink  );
		model.addAttribute("firstPage"      , firstPage );
		model.addAttribute("lastPage"       , lastPage  );
		model.addAttribute("pageLinks"      , pageLinks );


        model.addAttribute("articleno"      , articleno );
        model.addAttribute("boardcd"        , boardcd   );
        model.addAttribute("curPage"        , curPage   );
        model.addAttribute("searchWord"     , searchWord);
                
		return "board/articleview";
	}

    @RequestMapping(value="/articlemodify", method=RequestMethod.GET)
    public String articlemodify(
            @RequestParam(value="articleno" , defaultValue="") Integer articleno 
          , @RequestParam(value="boardcd"   , defaultValue="") String  boardcd 
          , @RequestParam(value="curPage"   , defaultValue="") Integer curPage
          , @RequestParam(value="searchWord", defaultValue="") String  searchWord 
          , Model model) throws Exception {

        ModelArticle thisArticle = boardsrv.getArticle(articleno);
        String boardNm = boardsrv.getBoardName(boardcd);
        
        //수정페이지에서의 보일 게시글 정보
        model.addAttribute("boardNm"    , boardNm    );
        model.addAttribute("thisArticle", thisArticle);
        
        model.addAttribute("articleno"  , articleno  );
        model.addAttribute("boardcd"    , boardcd    );
        model.addAttribute("curPage"    , curPage    );
        model.addAttribute("searchWord" , searchWord );
        
        return "board/articlemodify";
    }
    
    @RequestMapping(value="/articlemodify", method=RequestMethod.POST)
    public String articlemodify(
              @ModelAttribute ModelArticle updatearticle
            , @RequestParam(value="articleno" , defaultValue="") Integer articleno 
            , @RequestParam(value="boardcd"   , defaultValue="") String boardcd 
            , @RequestParam(value="curPage"   , defaultValue="") Integer curPage
            , @RequestParam(value="searchWord", defaultValue="") String searchWord
            , MultipartHttpServletRequest mpRequest) throws Exception {
        
        
        updatearticle.setUseYN(true);    
        updatearticle.setUpdateUID(" articlemodify 수정 필요 ");
        updatearticle.setUpdateDT(new Date() ); 
        

        ModelArticle searcharticle = new ModelArticle();
        searcharticle.setArticleno( updatearticle.getArticleno() );// 게시판 종류 변경
        boardsrv.updateArticle(updatearticle, searcharticle);

        //파일업로드
        Iterator<String> it = mpRequest.getFileNames();
        List<MultipartFile> fileList = new ArrayList<MultipartFile>();
        while (it.hasNext()) {
            MultipartFile multiFile = mpRequest.getFile((String) it.next());
            
            if (multiFile.getSize() > 0) {
                String filename = multiFile.getOriginalFilename();
                multiFile.transferTo(new File(WebConstants.UPLOAD_PATH + "/" + filename));
                fileList.add(multiFile);
            }
        }
        
        //파일데이터 삽입
        int size = fileList.size();
        for (int i = 0; i < size; i++) {
            MultipartFile mpFile = fileList.get(i);
            
            ModelAttachfile attachFile = new ModelAttachfile();
            String filename = mpFile.getOriginalFilename();
            attachFile.setFilename(filename);
            attachFile.setFiletype(mpFile.getContentType());
            attachFile.setFilesize(mpFile.getSize());
            attachFile.setArticleno(articleno);
            boardsrv.insertAttachFile(attachFile);
        }
        
        searchWord = URLEncoder.encode(searchWord,"UTF-8");
        return "redirect:/board/articleview?articleno=" + articleno 
            + "&boardcd=" + boardcd 
            + "&curPage=" + curPage 
            + "&searchWord=" + searchWord;

    }

    @RequestMapping(value="/articledelete", method=RequestMethod.POST)
    public String articledelete(
              @RequestParam(value="articleno" , defaultValue="") Integer articleno 
            , @RequestParam(value="boardcd"   , defaultValue="") String boardcd 
            , @RequestParam(value="curPage"   , defaultValue="") Integer curPage
            , @RequestParam(value="searchWord", defaultValue="") String searchWord ) throws Exception {
        
        ModelArticle article = new ModelArticle();
        article.setArticleno(articleno);        

        boardsrv.deleteArticle(article);

        searchWord = URLEncoder.encode(searchWord, "UTF-8");
        
        return "redirect:/board/articlelist?boardcd=" + boardcd + 
            "&curPage=" + curPage + 
            "&searchWord=" + searchWord;
    }
    
	
	@RequestMapping(value="/commentadd", method=RequestMethod.POST)
	public String commentadd(
              @RequestParam(value="articleno" , defaultValue="") Integer articleno 
            , @RequestParam(value="boardcd"   , defaultValue="") String boardcd 
            , @RequestParam(value="curPage"   , defaultValue="") Integer curPage
            , @RequestParam(value="searchWord", defaultValue="") String searchWord 
			, @RequestParam(value="memo", defaultValue="") String memo) throws Exception {
			
		ModelComments comment = new ModelComments();
		comment.setMemo(memo);
		comment.setArticleno(articleno);

		boardsrv.insertComment(comment);
		
		searchWord = URLEncoder.encode(searchWord,"UTF-8");
		
		return "redirect:/board/articleview?articleno=" + articleno + 
			"&boardcd=" + boardcd + 
			"&curPage=" + curPage + 
			"&searchWord=" + searchWord;
	}

	@RequestMapping(value="/commentupdate", method=RequestMethod.POST)
	public String commentupdate(
            @RequestParam(value="articleno" , defaultValue="") Integer articleno 
          , @RequestParam(value="boardcd"   , defaultValue="") String boardcd 
          , @RequestParam(value="curPage"   , defaultValue="") Integer curPage
          , @RequestParam(value="searchWord", defaultValue="") String searchWord 
          , @RequestParam(value="commentno", defaultValue="") Integer commentno  
		  , @RequestParam(value="memo", defaultValue="") String memo) throws Exception {

		ModelComments updatecomment = boardsrv.getComment(commentno);
		updatecomment.setMemo(memo);
		
		ModelComments searchValue = new ModelComments();
		searchValue.setCommentno(commentno);
        
		
		boardsrv.updateComment(updatecomment, searchValue);
		searchWord = URLEncoder.encode(searchWord, "UTF-8");
		
		return "redirect:/board/articleview?articleno=" + articleno + 
			"&boardcd=" + boardcd + 
			"&curPage=" + curPage + 
			"&searchWord=" + searchWord;
	}
	

	@RequestMapping(value="/commentdel", method=RequestMethod.POST)
	public String commentdelete( 
            @RequestParam(value="articleno" , defaultValue="") Integer articleno 
          , @RequestParam(value="boardcd"   , defaultValue="") String boardcd 
          , @RequestParam(value="curPage"   , defaultValue="") Integer curPage
          , @RequestParam(value="searchWord", defaultValue="") String searchWord 
          , @RequestParam(value="commentno", defaultValue="") Integer commentno  ) throws Exception {
	    
	    ModelComments comment = new ModelComments();
	    comment.setCommentno(commentno);

		boardsrv.deleteComment(comment);
		
		searchWord = URLEncoder.encode(searchWord,"UTF-8");
		
		return "redirect:/board/articleview?articleno=" + articleno + 
			"&boardcd=" + boardcd + 
			"&curPage=" + curPage + 
			"&searchWord=" + searchWord;

	}
	

	@RequestMapping(value="/attachFileDel", method=RequestMethod.POST)
	public String attachFileDel(
            @RequestParam(value="articleno" , defaultValue="") Integer articleno 
          , @RequestParam(value="boardcd"   , defaultValue="") String boardcd 
          , @RequestParam(value="curPage"   , defaultValue="") Integer curPage
          , @RequestParam(value="searchWord", defaultValue="") String searchWord
          , @RequestParam(value="attachfileno", defaultValue="") Integer attachfileno ) throws Exception {
	    
	    ModelAttachfile attachFile = new ModelAttachfile();
	    attachFile.setAttachfileno(attachfileno);
		
		boardsrv.deleteAttachFile(attachFile);
		
		searchWord = URLEncoder.encode(searchWord,"UTF-8");
		
		return "redirect:/board/articleview?articleno=" + articleno + 
			"&boardcd=" + boardcd + 
			"&curPage=" + curPage + 
			"&searchWord=" + searchWord;

	}	
	

	@RequestMapping(value="/download", method=RequestMethod.POST)
	public String download(String filename, Model model) {
		model.addAttribute("filename", filename);
		return "inc/download";
	}

    
    @RequestMapping(value="/commentaddajax", method=RequestMethod.POST)
    public String commentaddajax(
              @RequestParam(value="articleno" , defaultValue="") Integer articleno 
            , @RequestParam(value="memo", defaultValue="") String memo
            , Model model) throws Exception {
            
        ModelComments comment = new ModelComments();
        comment.setMemo(memo);
        comment.setArticleno(articleno);
        
        try {
            int commentno = boardsrv.insertComment(comment);
            comment = boardsrv.getComment(commentno);
            
            model.addAttribute("comment", comment);
        } catch (Exception e) {
            logger.error("commentaddajax" + e.getMessage() );
            throw e;
        }
        
        return "board/articleview-commentlistbody";
    }

    @RequestMapping(value="/commentupdateajax", method=RequestMethod.POST)
    @ResponseBody
    public int commentupdateajax(
            @RequestParam(value="commentno", defaultValue="") Integer commentno  
          , @RequestParam(value="memo", defaultValue="") String memo) throws Exception {

        ModelComments updatecomment = boardsrv.getComment(commentno);
        updatecomment.setMemo(memo);
        updatecomment.setUseYN(true);
        
        ModelComments searchValue = new ModelComments();
        searchValue.setCommentno(commentno);

        int result=0;
        try {
            result = boardsrv.updateComment(updatecomment, searchValue);
        } catch (Exception e) {
            logger.error("commentupdateajax" + e.getMessage() );
            throw e;
        }

        return result;
    }
    

    @RequestMapping(value="/commentdeleteajax", method=RequestMethod.POST)
    @ResponseBody
    public int commentdeleteajax( @RequestParam(value="commentno", defaultValue="") Integer commentno  ) throws Exception {
        
        ModelComments comment = new ModelComments();
        comment.setCommentno(commentno);

        int result = boardsrv.deleteComment(comment);
        
        return result ;
    }   

	
}
