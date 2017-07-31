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
    private static IServiceBoard serviceboard  = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        serviceboard =context.getBean("serviceboard", IServiceBoard.class);
    }
    
    @Test
    public void testGetBoardName() {
        String result = serviceboard.getBoardName("free");
        
        assertEquals("자유게시판", result);
    }
    
    @Test
    public void testGetBoardOne() {
        IServiceBoard serviceboard = new ServiceBoard(  );        
        ModelBoard result = serviceboard.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
        assertEquals(result.getBoardcd(), "free"      );
        assertEquals(result.getUseYN()  , true        );
    }

    @Test
    public void testGetBoardTotalRecord() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetBoardList() {       
        List<ModelBoard> result = serviceboard.getBoardList();
        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getBoardcd(), "qna");
    }

    @Test
    public void testGetBoardListResultMap() {      
        Map<String, ModelBoard> result = serviceboard.getBoardListResultMap();
        assertEquals(result.size(), 3);
        assertEquals(result.get("free").getBoardnm(), "자유게시판");
    }

    @Test
    public void testInsertBoard()  {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setBoardnm("공지사항");
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
        model.setUseYN(true);
                
        int result = serviceboard.insertBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void testUpdateBoard() {
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
      
        int result = serviceboard.updateBoard(updateBoard, searchBoard);
        assertEquals(result, 1);
    }

    @Test
    public void testDeleteBoard() {
        ModelBoard model = new ModelBoard();
        model.setBoardcd("notice");
        model.setUseYN(true);
       
        int result = serviceboard.deleteBoard(model);
        assertEquals(result, 1);
    }

    @Test
    public void testGetBoardSearch() {
        ModelBoard model = null;
        
        model = new ModelBoard();        
        model.setBoardcd("a");        
    
        List<ModelBoard> result = serviceboard.getBoardSearch(model);        
        assertEquals(result.size(), 2);
        
        model = new ModelBoard();
        model.setBoardnm("자료실");        
     
        result = serviceboard.getBoardSearch(model);        
        assertEquals(result.size(), 1);
    }

    @Test
    public void testGetBoardPaging() { 
        String boardcd    = "";  
        String searchWord = "";
        int    start = 2;
        int    end   = 7;
        List<ModelBoard> result = serviceboard.getBoardPaging(boardcd, searchWord, start, end);
        assertEquals(result.size(), 2);
        
    }

    @Test
    public void testInsertBoardList() {
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
       
        int result = serviceboard.insertBoardList(list);
        assertEquals(result, 1);
    }

    @Test
    public void testGetArticleTotalRecord() {
        String boardcd    = "free";  
        String searchWord = "article";
        int result = serviceboard.getArticleTotalRecord(boardcd, searchWord);
        assertEquals(result, 14);
    }

    @Test
    public void testGetArticleList() { 
        String boardcd    = "free";  
        String searchWord = "article";
        int    start = 2;
        int    end   = 7;
        List<ModelArticle> result = serviceboard.getArticleList(boardcd, searchWord, start, end);
        assertEquals(result.size(), 6);
    }

    @Test
    public void testGetArticle() {  
        ModelArticle result = serviceboard.getArticle(1);
        assertEquals(result.getTitle(), "article test 01");
    }

    @Test
    public void testInsertArticle() {
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
       
        int result = serviceboard.insertArticle(model);
        
        if( result > 0)
            assertTrue(true);
        else 
            assertTrue(false);
    }

    @Test
    public void testUpdateArticle() {       
        
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
               
        int result = serviceboard.updateArticle(updateValue, searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void testDeleteArticle() {
        ModelArticle searchValue = new ModelArticle();     
        searchValue.setBoardcd("free");
        searchValue.setContent("tesr update cyt");
        searchValue.setEmail("sjydevil@gamil.com");
               
        int result = serviceboard.deleteArticle(searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void testIncreaseHit() {
        int articleno  = 1;
        
        ModelArticle beforeArticle = serviceboard.getArticle(articleno);        
        serviceboard.increaseHit(articleno);        
        ModelArticle afterArticle = serviceboard.getArticle(articleno);

        assertSame(beforeArticle.getHit()+2, afterArticle.getHit());
    }

    @Test
    public void testGetNextArticle() {
        ModelArticle result = serviceboard.getNextArticle(1, "free", "test");
        assertSame(result.getArticleno(), 2);
    }

    @Test
    public void testGetPrevArticle() {
        ModelArticle result = serviceboard.getPrevArticle(2, "free", "test");
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void testGetAttachFile() {
        ModelAttachfile result = serviceboard.getAttachFile( 2 );
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void testGetAttachFileList() {
        List<ModelAttachfile> result = serviceboard.getAttachFileList(1);
        assertSame(result.size(), 7);
    }
    @Test
    public void testInsertAttachFile() {
        ModelAttachfile model = new ModelAttachfile();
        model.setArticleno(2);
        model.setFilename("insert Attach File test");
        model.setFilesize(2008L);
        model.setFiletype("txt");
        model.setUseYN(true);        
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
              
        int result = serviceboard.insertAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void testDeleteAttachFile() {
        ModelAttachfile model = new ModelAttachfile();
        model.setAttachfileno(3);
        model.setUseYN(true);        
               
        int result = serviceboard.deleteAttachFile(model);
        assertEquals(result, 1);
    }

    @Test
    public void testGetComment() {
        ModelComments result = serviceboard.getComment( 1 );
        assertSame(result.getArticleno(), 1);
    }

    @Test
    public void testGetCommentList() {
        List<ModelComments> result = serviceboard.getCommentList( 1 );
        assertSame(result.size(), 1);
    }

    @Test
    public void testInsertComment() {
        ModelComments model = new ModelComments();
        model.setArticleno(1); 
        model.setEmail("sjydevil@gmail.com");
        model.setMemo("insert comment");
        model.setRegdate(new Date()); 
        model.setInsertDT(new Date());
        model.setInsertUID("insertUID");
        model.setUpdateDT(new Date());
        model.setUpdateUID("updateUID");
               
        int result = serviceboard.insertComment(model);
        assertEquals(result, 1);
    }

    @Test
    public void testUpdateComment() {    
        
        ModelComments updateValue = new ModelComments(); 
        updateValue.setMemo("update Comment test");
        updateValue.setRegdate( new Date() );
        updateValue.setUseYN(true);
        updateValue.setUpdateDT(new Date());
        updateValue.setUpdateUID("updateUID");
        
        ModelComments searchValue = new ModelComments();     
        searchValue.setCommentno(2);
        searchValue.setArticleno(1);
        
        int result = serviceboard.updateComment(updateValue, searchValue);
        assertEquals(result, 1);
    }

    @Test
    public void testDeleteComment() {
        ModelComments searchValue = new ModelComments();     
        searchValue.setCommentno(2);
        searchValue.setArticleno(1);
        searchValue.setUseYN(true);
        searchValue.setEmail("sjydevil@gmail.com");
                
        int result = serviceboard.deleteComment(searchValue);
        assertEquals(result, 1);
    }
    
    @Test
    public void testUpdateArticleGood_up() {
        int articleno = 1;
        int count = +1;

        ModelArticle articleBefore = serviceboard.getArticle(articleno);        
        serviceboard.updateArticleCountGood(articleno, count);        
        ModelArticle articleAfter = serviceboard.getArticle(articleno);
        
        assertSame(articleBefore.getCountgood() + 1 , articleAfter.getCountgood());
    }
    
    @Test
    public void testUpdateArticleGood_dn() {
        int articleno = 1;
        int count = -1;

        ModelArticle articleBefore = serviceboard.getArticle(articleno);        
        serviceboard.updateArticleCountGood(articleno, count);        
        ModelArticle articleAfter = serviceboard.getArticle(articleno);
        
        assertSame(articleBefore.getCountgood() - 1 , articleAfter.getCountgood());
    }
    
    @Test
    public void testUpdateArticleBad_up() {
        int articleno = 1;
        int count = +1;

        ModelArticle articleBefore = serviceboard.getArticle(articleno);        
        serviceboard.updateArticleCountBad(articleno,count);        
        ModelArticle articleAfter = serviceboard.getArticle(articleno);
        
        assertSame(articleBefore.getCountbad() + 1 , articleAfter.getCountbad());
    }
    
    @Test
    public void testUpdaterticleBad_dn() {
        int articleno = 1;
        int count = -1;

        ModelArticle articleBefore = serviceboard.getArticle(articleno);        
        serviceboard.updateArticleCountBad(articleno,count);        
        ModelArticle articleAfter = serviceboard.getArticle(articleno);
        
        assertSame(articleBefore.getCountbad() -1 , articleAfter.getCountbad());
    }
    
    

    @Test
    public void testUpdateArticleRecommend() {
        ModelArticleRecommend re1, re2 = null;
        int result =-1;
        
        ModelArticleRecommend recommend = new ModelArticleRecommend();
        recommend.setArticleno(2);
        recommend.setUserid("222");

        // insert 테스트
        result = serviceboard.updateRecommend(recommend);    
        assertTrue( result >=1 );
        
        re1 = serviceboard.getRecommendOne(recommend); 
        assertNotNull( re1 );
        
        // update 테스트 : good = 1;
        recommend.setGood(true);
        result = serviceboard.updateRecommend(recommend);    
        re2 = serviceboard.getRecommendOne(recommend);
        assertTrue( re2.getGood() );
        
        // update 테스트 : good = 0;
        recommend.setGood(false);
        result = serviceboard.updateRecommend(recommend);    
        re2 = serviceboard.getRecommendOne(recommend);
        assertFalse(re2.getGood() );
        
        // update 테스트 : bad = 1;
        recommend.setBad(true);
        result = serviceboard.updateRecommend(recommend);    
        re2 = serviceboard.getRecommendOne(recommend);
        assertTrue(re2.getBad() );

        // update 테스트 : bad = 0;
        recommend.setBad(false);
        result = serviceboard.updateRecommend(recommend);    
        re2 = serviceboard.getRecommendOne(recommend);
        assertFalse( re2.getBad() );
    }


    @Test
    public void testUpdateGoodBadCount() {
        ModelArticleRecommend re1, re2 = null;
        int result =-1;
        int articleno = 2;
        
        ModelArticleRecommend recommend = new ModelArticleRecommend();
        recommend.setArticleno( articleno );
        recommend.setUserid("222");
        
        // deleteRecommend
        serviceboard.deleteRecommend(recommend);
        
        // updateRecommend 테스트 : good = 1, bad = 0;
        recommend.setGood(true);
        recommend.setBad(false);
        result = serviceboard.updateRecommend(recommend);   
        re2 = serviceboard.getRecommendOne(recommend);
        assertTrue ( re2.getGood() );
        assertFalse( re2.getBad()  );
        
        //
        serviceboard.updateArticleGoodBadCount(articleno);
        
        ModelArticle article = serviceboard.getArticle(articleno);
        assertSame(article.getCountgood(), 1);
        assertSame(article.getCountbad() , 0);
        
    }
}
