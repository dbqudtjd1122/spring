package com.spring81.bbs;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.service.IServiceBoard;

public class TestServiceBoard {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    static ApplicationContext context = null;
    static IServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service =context.getBean("serviceboard", IServiceBoard.class);
    }
    
    @Test
    public void testGetBoardName() {
        String result = service.getBoardName("free");
        
        assertEquals("자유게시판", result);
    }
    
    @Test
    public void testGetBoardOne() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetBoardTotalRecord() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetBoardList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetBoardListResultMap() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBoard() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateBoard() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteBoard() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetBoardSearch() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetBoardPaging() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBoardList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetArticleTotalRecord() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetArticleList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetArticle() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertArticle() {
        ModelArticle article = new ModelArticle();
        article.setBoardcd("free");
        
        int result = service.insertArticle(article);
        assertNotEquals(result, 1);
        assertNotEquals(result, 0);
        assertNotEquals(result, -1);
    }
    
    @Test
    public void testUpdateArticle() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteArticle() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testIncreaseHit() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetNextArticle() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPrevArticle() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetAttachFile() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetAttachFileList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertAttachFile() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteAttachFile() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetComment() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetCommentList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertComment() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateComment() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteComment() {
        fail("Not yet implemented");
    }
    @Test
    public void testGetMaxArticleno() {
        int result = service.getMaxArticleno();
        assertNotEquals(result, 1);
        assertNotEquals(result, 0);
        assertNotEquals(result, -1);
    }
}
