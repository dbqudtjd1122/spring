package com.spring81.bbs.service;

import com.spring81.bbs.commons.EnumGoodBad;
import com.spring81.bbs.dao.IDaoBoard;
import com.spring81.bbs.model.ModelArticle;

public interface IServiceBoard extends IDaoBoard {
    /* 상세보기를 할때마다 조회수를 1 증가
     * 하단에 목록에서 조회수를 제대로 보기위해서는
     * 목록 레코드를 페치하기 전에 조회수를 먼저 증가시켜야 한다.
     * 사용자 IP 와 시간을 고려해서 조회수를 증가하도록...
     */
    ModelArticle transUpdateHitAndGetArticle(int articleno);
    
    /* artilcedelet 시 transaction 으로 처리하기 위한 메서드
     * 
     * 1. TB_BBS_Comments 테이블에서 있는 comment 정보 삭제.
     * 2. 업로드 폴더에서 관련된 첨부 파일 삭제.
     * 3. TB_BBS_AttachFile 테이블에서 있는 attachfile 정보 삭제.
     * 4. TB_BBS_Article 테이블에서 artilce 정보 삭제
     */
    int transDeleteArticle(String boardcd, int articleno);
    
    
    /* aritcle에서 :좋아요"나 "나빠요"를 클릭했을 때 처리하는 메서드
     * 
     * 1 --> 좋아요(good) --> up
     * 1 --> 좋아요(good) --> down
     * 1 --> 나빠요(bad ) --> up
     * 1 --> 나빠요(bad ) --> down
     * 
     * TB_Bbbs_Recommend 테이블에 insert or update : merge 와 같다.             
     * TB_Bbbs_Article 테이블에서 countgood 컬럼과 countbad 컬럼 값을 업데이트한다.
     */
    int transRecommendArticle( int articleno, String userid , EnumGoodBad codeGB, boolean updown );

}
