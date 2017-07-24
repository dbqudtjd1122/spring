package com.spring81.bbs;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring81.bbs.commons.PagingHelper;

public class TestPagingHelper {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
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
}
