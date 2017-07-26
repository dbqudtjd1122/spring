package com.spring81.bbs.controller;

import java.io.IOException;
import java.util.List;
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

import com.spring81.bbs.commons.*;
import com.spring81.bbs.model.*;
import com.spring81.bbs.service.*;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	IServiceBoard boardsrv;
	
	@RequestMapping(value = "/board/boardlist", method = RequestMethod.GET)
	public String boardlist( Model model ) {
		logger.info("/board/boardlist");
		
		List<ModelBoard>  result = boardsrv.getBoardList();
		model.addAttribute("list", result);
		
		return "board/boardlist";
	}
    

    /**
     * http://localhost/board/boardwrite
     */
    @RequestMapping(value = "/board/boardwrite", method = RequestMethod.GET)
    public String boardwrite( Model model ) {
        logger.info("/board/boardwrite : get");
                
        return "board/boardwrite";
    }
    @RequestMapping(value = "/board/boardwrite", method = RequestMethod.POST)
    public String boardwrite( Model model
            , @RequestParam(value="boardcd", defaultValue="") String boardcd
            , @RequestParam(value="boardnm", defaultValue="") String boardnm 
            , @RequestParam(value="UseYN"  , defaultValue="") Boolean useYN ) {
        logger.info("/board/boardwrite : post");
        
        // DB insert
        ModelBoard board  = new ModelBoard();
        board.setBoardcd(boardcd);
        board.setBoardnm(boardnm);
        board.setUseYN  (useYN  );
        
        int result =  boardsrv.insertBoard(board);
        
        if( result == 1 ){
            // /board/boardlist 리다이렉트 
            return "redirect:/board/boardlist";
        }
        else {            
            return "board/boardwrite";            
        }
    }
	
    /**
     * http://localhost/board/boardview?boardcd=qna
     */
    @RequestMapping(value = "/board/boardview", method = RequestMethod.GET)
    public String boardview( Model model 
		, @RequestParam(value="boardcd", required = false, defaultValue = "free") String boardcd 
        , @RequestParam(value="boardnm", required = false, defaultValue = ""    ) String boardnm ) {

        logger.info("/board/boardview");

        if( StringUtils.isEmpty(boardcd) ) boardcd = "free";

        // DB 처리
        ModelBoard board =  boardsrv.getBoardOne(boardcd);
        
        // 모델 바인딩
        model.addAttribute("boardnm", board.getBoardnm() );
        model.addAttribute("board"  ,  board );

        return "board/boardview";
    }	

    /**
     * http://localhost/board/boardview/qna
     */
    @RequestMapping(value = "/board/boardview/{boardcd}", method = RequestMethod.GET)
    public String boardview( Model model, @PathVariable(value="boardcd") String boardcd  ) {

        logger.info("/board/boardview/{boardcd}");

        // DB 처리
        ModelBoard board =  boardsrv.getBoardOne(boardcd);
        
        // 모델 바인딩
        model.addAttribute("boardnm", board.getBoardnm() );
        model.addAttribute("board"  ,  board );

        return "board/boardview";
    }

    /**
     * http://localhost/board/boardmodify?boardcd=qna
     */
    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.GET)
    public String boardmodify( Model model
                             , @RequestParam(value="boardcd", defaultValue = "free") String boardcd 
	    	                 , HttpServletRequest request ) {
        logger.info("/board/boardmodify");
        
        // DB 처리
        ModelBoard board =  boardsrv.getBoardOne(boardcd);
        
        // 모델 바인딩
        model.addAttribute("boardnm", board.getBoardnm() );
        model.addAttribute("board"  , board );

        return "board/boardmodify";
    }   
    
    /**
     * http://localhost/board/boardmodify?boardcd=qna
     */
    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.POST)
    public String boardmodify( Model model 
	                         , @ModelAttribute ModelBoard board
		                     , HttpServletRequest request ) {
        logger.info("/board/boardmodify");

        ModelBoard updateBoard = new ModelBoard();
        updateBoard.setBoardnm(  board.getBoardnm()  );
        updateBoard.setUseYN  (  board.getUseYN() == null ? false:  board.getUseYN()  );
        
        // DB 처리
        ModelBoard searchBoard = new ModelBoard();
        searchBoard.setBoardcd( board.getBoardcd() );
        
        int result =  boardsrv.updateBoard(updateBoard, searchBoard);
        
        if( result >= 1 ){
            // /board/boardlist 리다이렉트 
            return "redirect:/board/boardlist";
        }
        else {            
            return "board/boardmodify/" + board.getBoardcd();            
        }
    }
    

    /**
     * http://localhost/board/boardmodify/qna
     */
    @RequestMapping(value = "/board/boardmodify/{boardcd}", method = RequestMethod.GET)
    public String boardmodifypath( Model model 
            , @PathVariable(value="boardcd")  String boardcd
            , HttpServletRequest request) {
        logger.info("/board/boardmodifypath : GET");
        
        // DB 처리
        ModelBoard board =  boardsrv.getBoardOne(boardcd);
        
        // 모델 바인딩
        model.addAttribute("boardnm", board.getBoardnm() );
        model.addAttribute("board"  , board );

        return "board/boardmodify";
    }
    

    /**
     * http://localhost/board/boardview/qna
     */
    @RequestMapping(value = "/board/boardmodify/{boardcd}", method = RequestMethod.POST)
    public String boardmodifypath( 
          HttpServletRequest request
        , @PathVariable(value="boardcd")  String boardcd
        , @ModelAttribute("board") ModelBoard board
        , Model model )  {

        logger.info("/board/boardmodifypath : POST");

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
     * http://localhost/board/boarddelete/qna
     */
    @RequestMapping(value = "/board/boarddelete/{boardcd}", method = RequestMethod.POST)
    public String boarddelete( Model model 
                             , @PathVariable(value="boardcd") String boardcd) {
        logger.info("/board/boarddelete");
        
        ModelBoard board = new ModelBoard(boardcd);
        
        // DB 처리              
        int result =  boardsrv.deleteBoard(board);
        
        if( result > 0 ){
            // /board/boardlist 리다이렉트 
            return "redirect:/board/boardlist";
        }
        else {       
            // /board/boardview 리다이렉트 
            return "redirect:/board/boardview/"+ boardcd;            
        }
    } 
    
    /**
     * http://localhost/board/articlelist/qna?curPage=1&searchWord=
     */
    @RequestMapping(value = "/board/articlelist/{boardcd}", method = RequestMethod.GET)
    public String articlelist( Model model
            , @PathVariable(value="boardcd") String boardcd
            , @RequestParam(value="curPage"   , defaultValue="1") Integer    curPage
            , @RequestParam(value="searchWord", defaultValue="" ) String searchWord) {
        logger.info("/board/articlelist");

        String boardnm          = boardsrv.getBoardName(boardcd);        
        model.addAttribute("boardnm"   , boardnm   );
        model.addAttribute("boardcd"   , boardcd   );
        model.addAttribute("curPage"   , curPage   );
        model.addAttribute("searchWord", searchWord);

        /*
         *  articlelist-table.jsp 와 관련된 처리
         */
        
        // 전체 게시글 갯수 가져오기
        int totalRecord = boardsrv.getArticleTotalRecord(boardcd, searchWord);
        
        // 페이지 처리
        PagingHelper paging = new PagingHelper(totalRecord, curPage);        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticle> list = boardsrv.getArticleList(boardcd, searchWord, start, end);
        model.addAttribute("list"          , list                       );
        model.addAttribute("no"            , paging.getListNo        () );
        model.addAttribute("totalFirstPage", paging.getTotalFirstPage() );
        model.addAttribute("prevLink"      , paging.getPrevLink      () );
        model.addAttribute("pageLinks"     , paging.getPageLinks     () );
        model.addAttribute("nextLink"      , paging.getNextLink      () );
        model.addAttribute("totalLastPage" , paging.getTotalLastPage () );   
        
        return "board/articlelist";
    }

	// http://localhost/board/articleview/free/17?curPage=1&searchWord=    
    @RequestMapping(value = "/board/articleview/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articleview( Model model 
            , @PathVariable(value="boardcd"  )  String  boardcd
            , @PathVariable(value="articleno")  Integer articleno
            , @RequestParam(value="curPage"   , defaultValue="1") Integer curPage
            , @RequestParam(value="searchWord", defaultValue="" ) String  searchWord ) {
        logger.info("/board/articleview");
        
        // boardcd
        // articleno
        // curPage
        // searchWord
        
        //boardnm
        String boardnm = boardsrv.getBoardName(boardcd);
        model.addAttribute("boardnm", boardnm);
        
        //thisArticle
        ModelArticle thisArticle = boardsrv.getArticle(articleno);
        model.addAttribute("thisArticle", thisArticle);
        
        // attachFileList
        List<ModelAttachfile> attachFileList = boardsrv.getAttachFileList(articleno);
        model.addAttribute("attachFileList", attachFileList);
        
        //commentList
        List<ModelComments> commentList = boardsrv.getCommentList(articleno);
        model.addAttribute("commentList", commentList);        
        
        //nextArticle
        ModelArticle nextArticle = boardsrv.getNextArticle(articleno, boardcd, searchWord);
        model.addAttribute("nextArticle", nextArticle);
        
        //prevArticle
        ModelArticle prevArticle = boardsrv.getPrevArticle(articleno, boardcd, searchWord);
        model.addAttribute("prevArticle", prevArticle);

        /*
         *  articlelist-table.jsp 와 관련된 처리
         */
                
        // 전체 게시글 갯수 가져오기
        int totalRecord = boardsrv.getArticleTotalRecord(boardcd, searchWord);
        
        // 페이지 처리
        PagingHelper paging = new PagingHelper(totalRecord, curPage);        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticle> list = boardsrv.getArticleList(boardcd, searchWord, start, end);
        model.addAttribute("list"          , list                       );
        model.addAttribute("no"            , paging.getListNo        () );
        model.addAttribute("totalFirstPage", paging.getTotalFirstPage() );
        model.addAttribute("prevLink"      , paging.getPrevLink      () );
        model.addAttribute("pageLinks"     , paging.getPageLinks     () );
        model.addAttribute("nextLink"      , paging.getNextLink      () );
        model.addAttribute("totalLastPage" , paging.getTotalLastPage () );  
        


        model.addAttribute("articleno"      , articleno );
        model.addAttribute("boardcd"        , boardcd   );
        model.addAttribute("curPage"        , curPage   );
        model.addAttribute("searchWord"     , searchWord);
                
		return "board/articleview";
	}
	

    /**
     * http://localhost/board/articlewirte/qna
     */
    @RequestMapping(value = "/board/articlewrite/{boardcd}", method = RequestMethod.GET)
    public String articlewrite( Model model 
            , @PathVariable(value="boardcd")  String boardcd
            , @RequestParam(value="curPage"   , defaultValue="1") Integer curPage
            , @RequestParam(value="searchWord", defaultValue="" ) String  searchWord ) {
        logger.info("/board/articlewrite : GET");
        
        String boardnm = boardsrv.getBoardName(boardcd);      
        // articleno 존재하지 않음.
        
        model.addAttribute("boardnm"   , boardnm);
        model.addAttribute("boardcd"   , boardcd);
        model.addAttribute("curPage"   , curPage);
        model.addAttribute("searchWord", searchWord);        

        return "board/articlewrite";
    }
    
    /**
     * http://localhost/board/articlewirte/qna
     */
    @RequestMapping(value = "/board/articlewrite", method = RequestMethod.POST)
    public String articlewrite( Model model 
            , @ModelAttribute ModelArticle article
            , MultipartFile uploadfile ) throws IllegalStateException, IOException  {
        logger.info("/board/articlewrite : POST");
        int result = -1;

        // 1. article 테이블에 insert.
        int articleno = boardsrv.insertArticle(article); // articleno 는 inserted 된 pk값 
        articleno = boardsrv.getMaxArticleno(); 

        // 2. 로컬 첨부 파일을 서버로 올리기 위한 코드
        if( !uploadfile.getOriginalFilename().isEmpty() ){
            String fileName = uploadfile.getOriginalFilename();
            String filepath = WebConstants.UPLOAD_PATH + "/" + fileName;                 
            java.io.File f = new java.io.File( filepath );                
            uploadfile.transferTo( f );       
                           
            // 첨부 파일을 attachfiel 테이블에 insert.
            ModelAttachfile attachfile = new ModelAttachfile();
            attachfile.setFilename( f.getName() );  // 파일명
            attachfile.setFiletype( FilenameUtils.getExtension(fileName) ); //확장자
            attachfile.setFilesize( (int)f.length() );
            attachfile.setArticleno( articleno );
            result = boardsrv.insertAttachFile( attachfile );            
        }

        if( result > 0 ){
            // /board/boardlist 리다이렉트 
            return "redirect:/board/boardlist/"+ article.getBoardcd(); 
        }
        else {       
            // /board/boardview 리다이렉트 
            return "redirect:/board/boardwrite/"+ article.getBoardcd();            
        }
    }

    /**
     * http://localhost/board/articlemodify/qna
     */
    @RequestMapping(value = "/board/articlemodify/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articlemodify( Model model 
            , @PathVariable(value="boardcd"  )  String boardcd
            , @PathVariable(value="articleno")  Integer articleno
            , @RequestParam(value="curPage"   , defaultValue="1") Integer curPage
            , @RequestParam(value="searchWord", defaultValue="" ) String  searchWord ) {
        logger.info("/board/articlewrite : GET");
        
        String boardnm = boardsrv.getBoardName(boardcd);      
        ModelArticle thisArticle = boardsrv.getArticle(articleno);
        
        model.addAttribute("boardnm"    , boardnm);
        model.addAttribute("boardcd"    , boardcd);
        model.addAttribute("articleno"  , articleno);
        model.addAttribute("curPage"    , curPage);
        model.addAttribute("searchWord" , searchWord); 
        model.addAttribute("thisArticle", thisArticle);         

        return "board/articlemodify";
    }
}
