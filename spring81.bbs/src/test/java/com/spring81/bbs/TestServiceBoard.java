package com.spring81.bbs;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring81.bbs.model.*;
import com.spring81.bbs.service.*;

import org.junit.runners.MethodSorters;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    private static ApplicationContext context = null;
    private static IServiceBoard board  = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        board   = context.getBean("serviceboard", IServiceBoard.class); 
    }
    
    @Test
    public void getBoardName() {     
        String result = board.getBoardName("free");
        assertEquals(result, "자유게시판");
    }

    @Test
    public void getBoardOne() {
        IServiceBoard board = new ServiceBoard(  );        
        ModelBoard result = board.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
        assertEquals(result.getBoardcd(), "free"      );
        assertEquals(result.getUseYN()  , true        );
    }

    @Test
    public void getBoardTotalRecord() {
    }

    @Test
    public void getBoardList() {       
        List<ModelBoard> result = board.getBoardList();
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getBoardcd(), "qna");
    }

    @Test
    public void getBoardListResultMap() {      
        Map<String, ModelBoard> result = board.getBoardListResultMap();
        assertEquals(result.size(), 3);
        assertEquals(result.get("free").getBoardnm(), "자유게시판");
    }

    @Test
    public void insertBoard()  {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setBoardnm("공지사항");
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
        model.setUseYN(true);
                
        int result = board.insertBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void updateBoard() {
        ModelBoard updateBoard = new ModelBoard();
        updateBoard.setBoardcd("notice");
        updateBoard.setBoardnm("새로운 공지사항");
        updateBoard.setInsertDT(new Date());
        updateBoard.setInsertUID("insertUID");
        updateBoard.setUpdateDT(new Date());
        updateBoard.setUpdateUID("updateUID");
        updateBoard.setUseYN(true);
        
        ModelBoard searchBoard = new ModelBoard();
        searchBoard.setBoardcd("notice");
      
        int result = board.updateBoard(updateBoard, searchBoard);
        assertEquals(result, 1);
    }

    @Test
    public void deleteBoard() {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setUseYN(true);
       
        int result = board.deleteBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void getBoardSearch() {
        ModelBoard model = null;
        
        model = new ModelBoard();        
        model.setBoardcd("a");        
    
        List<ModelBoard> result = board.getBoardSearch(model);        
        assertEquals(result.size(), 2);
        
        model = new ModelBoard();
        model.setBoardnm("자료실");        
     
        result = board.getBoardSearch(model);        
        assertEquals(result.size(), 1);
    }

    @Test
    public void getBoardPaging() { 
        String boardcd    = "";  
        String searchWord = "";
        int    start = 2;
        int    end   = 7;
        List<ModelBoard> result = board.getBoardPaging(boardcd, searchWord, start, end);
        assertEquals(result.size(), 2);
        
    }

    @Test
    public void insertBoardList() {
        ModelBoard model = null;
        List<ModelBoard> list = new ArrayList<ModelBoard>();
        Date d = new Date();
        String current = new SimpleDateFormat("yyMMddHHmmss").format( d );
        
        for( int i=0; i<10; i=i+1){            
            model = new ModelBoard();
            model.setBoardcd("notice" + current + i );
            model.setBoardnm("공지사항" + current + i );
            model.setUseYN(true);     
            model.setInsertDT( d );
            model.setInsertUID("insertUID" + i);
            model.setUpdateDT( d );
            model.setUpdateUID("updateUID" + i);  
            
            list.add( model );
        }
       
        int result = board.insertBoardList(list);
        assertEquals(result, 1);
    }

    @Test
    public void getArticleTotalRecord() {
        String boardcd    = "free";  
        String searchWord = "article";
        int result = board.getArticleTotalRecord(boardcd, searchWord);
        assertEquals(result, 14);
    }

    @Test
    public void getArticleList() { 
        String boardcd    = "free";  
        String searchWord = "article";
        int    start = 2;
        int    end   = 7;
        List<ModelArticle> result = board.getArticleList(boardcd, searchWord, start, end);
        assertEquals(result.size(), 6);
    }

    @Test
    public void getArticle() {  
        ModelArticle result = board.getArticle(1);
        assertEquals(result.getTitle(), "article test 01");
    }

    @Test
    public void insertArticle() {
        ModelArticle model = new ModelArticle();
        model.setBoardcd("free");
        model.setContent("tesr yd cyt");
        model.setEmail("sjydevil@gamil.com");
        model.setHit(0);
        model.setRegdate( new Date() );
        model.setTitle("insert article test");
        model.setUseYN(true);
        
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
       
        int result = board.insertArticle(model);
        
        if( result > 0)
            assertTrue(true);
        else 
            assertTrue(false);
    }

    @Test
    public void updateArticle() {       
        
        ModelArticle updateValue = new ModelArticle(); 
        updateValue.setContent("tesr update cyt");
        updateValue.setTitle("update article test");
        updateValue.setUseYN(true);
        updateValue.setUpdateDT(new Date());
        updateValue.setUpdateUID("updateUID");
        
        ModelArticle searchValue = new ModelArticle();     
        searchValue.setBoardcd("free");
        searchValue.setContent("tesr update cyt");
        searchValue.setEmail("sjydevil@gamil.com");
               
        int result = board.updateArticle(updateValue, searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void deleteArticle() {
        ModelArticle searchValue = new ModelArticle();     
        searchValue.setBoardcd("free");
        searchValue.setContent("tesr update cyt");
        searchValue.setEmail("sjydevil@gamil.com");
               
        int result = board.deleteArticle(searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void increaseHit() {
        int articleno  = 1;
        
        ModelArticle beforeArticle = board.getArticle(articleno);        
        board.increaseHit(articleno);        
        ModelArticle afterArticle = board.getArticle(articleno);

        assertSame(beforeArticle.getHit()+2, afterArticle.getHit());
    }

    @Test
    public void getNextArticle() {
        ModelArticle result = board.getNextArticle(1, "free", "test");
        assertSame(result.getArticleno(), 2);
    }

    @Test
    public void getPrevArticle() {
        ModelArticle result = board.getPrevArticle(2, "free", "test");
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void getAttachFile() {
        ModelAttachfile result = board.getAttachFile( 2 );
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void getAttachFileList() {
        List<ModelAttachfile> result = board.getAttachFileList(1);
        assertSame(result.size(), 7);
    }
    @Test
    public void insertAttachFile() {
        ModelAttachfile model = new ModelAttachfile();
        model.setArticleno(2);
        model.setFilename("insert Attach File test");
        model.setFilesize(2008);
        model.setFiletype("txt");
        model.setUseYN(true);        
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
              
        int result = board.insertAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void deleteAttachFile() {
        ModelAttachfile model = new ModelAttachfile();
        model.setAttachfileno(3);
        model.setUseYN(true);        
               
        int result = board.deleteAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void insertComment() {
        ModelComments model = new ModelComments();
        model.setArticleno(1); 
        model.setEmail("sjydevil@gmail.com");
        model.setMemo("insert comment");
        model.setRegdate(new Date()); 
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
               
        int result = board.insertComment(model);
        assertEquals(result, 1);
    }

    @Test
    public void updateComment() {    
        
        ModelComments updateValue = new ModelComments(); 
        updateValue.setMemo("update Comment test");
        updateValue.setRegdate( new Date() );
        updateValue.setUseYN(true);
        updateValue.setUpdateDT(new Date());
        updateValue.setUpdateUID("updateUID");
        
        ModelComments searchValue = new ModelComments();     
        searchValue.setCommentno(2);
        searchValue.setArticleno(1);
        
        int result = board.updateComment(updateValue, searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void deleteComment() {
        ModelComments searchValue = new ModelComments();     
        searchValue.setCommentno(2);
        searchValue.setArticleno(1);
        searchValue.setUseYN(true);
        searchValue.setEmail("sjydevil@gmail.com");
                
        int result = board.deleteComment(searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void getComment() {
        ModelComments result = board.getComment( 1 );
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void getCommentList() {
        List<ModelComments> result = board.getCommentList( 1 );
        assertSame(result.size(), 1);
    }
}
