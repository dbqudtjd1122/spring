package com.bbs;

import static org.junit.Assert.*;


import org.junit.*;

import com.bbs.commons.PagingHelper;

public class TestPagingHelper {
 
    @Test
    public void paging() {
        
        //총레코드수:1000 
        //현재 페이지:1
        //페이지당 레코드 출력갯수:10
        //페이지 블락당 출력할 페이지 수:10
        int totalRecord = 1000;
        int curPage = 1;
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        assertEquals(1000, paging.getListNo());
        assertEquals(0   , paging.getPrevLink());    //
        assertEquals(91  , paging.getStartRecord());
        assertEquals(100 , paging.getEndRecord());
        assertEquals(12  , paging.getNextLink());
        assertEquals(100 , paging.getTotalPage());
        assertEquals(0   , paging.getPrevLink());
        assertEquals(1   , paging.getFirstPage());
        assertEquals(11  , paging.getLastPage());
    }
    
    @Test
    public void paging2() {       

        //총레코드수:3511 
        //현재 페이지:25
        //페이지당 레코드 출력갯수:9
        //페이지 블락당 출력할 페이지 수:15
        
        int totalRecord = 3511;
        int curPage = 25;
        int numberPerPage =9;
        int pagePerBlock =15;
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage, numberPerPage, pagePerBlock);

        paging.setNumberPerPage(numberPerPage);      //페이지 출력할 페이지 수
        paging.setPagePerBlock(pagePerBlock);        //페이지당 보여질 에코드 수
        
        assertEquals(0  , paging.getPrevLink());     //이전페이지 값
        assertEquals(91 , paging.getStartRecord());  //현제 출력페이지의 시작 레코드값           
        assertEquals(100, paging.getEndRecord());    //현제 출력체이지의 마지막 레코드값
        assertEquals(12 , paging.getNextLink());     //Last페이지의 다음 페이지 수            
        assertEquals(0  , paging.getPrevLink());     //First페이지의 이전 페이지 수
        assertEquals(100, paging.getTotalPage());    //총 출력 페이지수
        assertEquals(1  , paging.getFirstPage());    //화면에 보여지는 처음 페이지 수    
        assertEquals(11 , paging.getLastPage());     //화면에 보여지는 마지막 페이지 수        
    }
    
}
