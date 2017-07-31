package com.spring81.bbs;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.spring81.bbs.commons.PagingHelper;

public class TestPagingHelper {
  
    @Test
    public void paging1() {
        // 페이징 처리 필요한 정보 2개
        // 1. 전체 레코드수
        // 2. 현재 페이지수. 
        // 3. 페이지당 블락수.
        
        
        // 총레코드수 : 1000개
        // 현재 페이시수: 5개
        // 페이지당 레코드 : 10개
        // 페이지 블락당 출력 페이지 수: 10개
        int totalRecord  = 1000;
        int curPage = 52;
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        assertEquals( paging.getEndRecord()     , 520                                      );
        assertEquals( paging.getFirstPage()     , 51                                       );
        assertEquals( paging.getLastPage()      , 60                                       );
        assertEquals( paging.getListNo()        , totalRecord                              );
        assertEquals( paging.getNextLink()      , 61                                       );
        assertEquals( paging.getNumberPerPage() , 10                                       );
        assertEquals( paging.getPageLinks()     , new int[]{51,52,53,54,55,56,57,58,59,60} );
        assertEquals( paging.getPagePerBlock()  , 10                                       );
        assertEquals( paging.getPrevLink()      , 50                                       );
        assertEquals( paging.getStartRecord()   , 511                                      );
        assertEquals( paging.getTotalFirstPage(), 1                                        );
        assertEquals( paging.getTotalLastPage() , 101                                      );
        assertEquals( paging.getTotalPage()     , 100                                      );
    }
    
    @Test
    public void paging2() {
        
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
    public void paging3() {       

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
