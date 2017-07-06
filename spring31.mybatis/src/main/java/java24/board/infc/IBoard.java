package java24.board.infc;

import java.util.HashMap;
import java.util.List;

import java24.board.model.ModelArticle;
import java24.board.model.ModelAttachfile;
import java24.board.model.ModelBoard;
import java24.board.model.ModelComments;

public interface IBoard {
    
    /**
     * 
     * Board의 boardcd(data,free,qna)<- 스트링타입,primary key<br>
     *  boardcd로 boardnm(게시판) 조회
     */
    String getBoardName(String boardcd);
    
    /**
     * 
     * boardcd로 boardcd(게시판타입),boardnm(게시판),UseYN(사용여부) 조회
     */
    ModelBoard  getBoardOne(String boardcd);
    
    /**
     * Board테이블의 모든 컬럼을<br>
     * boardnm기준 정렬 값 반환 
     */
    List<ModelBoard> getBoardList();
    
    /**
     *  Board테이블 모든컬럼 값 반환 
     */
    List<ModelBoard> getBoardListResultMap();
    
    /**
     * 
     * Board테이블에 값을 insert용
     */
    
    Integer insertBoard(ModelBoard board);
    
    /**
     * Board테이블에 update <br>
     * 키이름: searchValue,updateValue
     * 값: 따로 지정값
     */
    Integer updateBoard(ModelBoard searchValue, ModelBoard updateValue);
    
    /**
     * Board테이블에서 delete<br>
     * if 조건 3개<br>
     * 1. boardcd 값이 NULL이 아니고 '' 공백이 아닐때 boardcd로 조회문 추가<br>
     * 2. boardnm 값이 위와같을 때 boardnm로 조회문 추가<br>
     * 3. UseYN 값이 NULL이 아닐때 UseYN 조회 추가<br>
     * 3개 조건식이 다 아니면 1=1 조건으로 전부 삭제<br>
     */
    Integer deleteBoard(ModelBoard board);

    /**
     * Board테이블에서 boardcd,boardnm,UseYN 값 반환 <br>
     * if 조건 2개<br>
     * 1. boardcd가 NULL이 아니고 ''이 아닐 때 boardcd like '%#boardcd%' 추가<br>
     * 2. boardnm이 위와같을 때 boardnm LIKE '%#{boardnm}%' 추가<br>
     * 둘다 아닐시 1=1 조건으로 반환
     */    
    
    List<ModelBoard>  getBoardSearch(ModelBoard board);
    /**
     * Board테이블에서 boardcd,boardnm,UseYN 값 반환 <br>
     * 매개변수로 hashmap이 사용되며 hash맵에 4개의 변수 사용 <br>
     * boardcd,searchWord(게시판이름),start(시작페이지),end(끝페이지) <br>
     * if 조건 2개<br>
     * 1. boardcd가 NULL이 아니고 ''이 아닐때 boardcd= #{boardcd} 쿼리 추가<br>
     * 2. boardnm이 위와 같을때 boardnm like searchWord 쿼리 추가<br>
     * 둘다 아닐시 1=1 조건 검색, boardcd,boardnm,UseYN 그룹묶음,boardcd 내림차순정렬<br>
     * 마지막으로 start,end 범위 조회
     */    
    
    List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end);
    
    /**
     * Board테이블에 추가할 item.(boardcd,boardnm,UseYN)을 리스트에 추가<br>
     * 추가된 리스트를 불러온뒤 항목수 만큼 값을 Board테이블에 추가.
     */
    Integer insertBoardList(List<ModelBoard> list);
    
    /**
     * Article 테이블의 모든컬럼을 카운트<br>
     * 기본조건 boardcd=boardcd<br>
     * if문 1개
     * searchWord != NULL, !='' 이면 아래 조건 추가<br>
     * AND (title LIKE '%searchWord%'<br>
     * OR content LIKE '%searchWord%') 추가
     */
    Integer getArticleTotalRecord(String boardcd, String searchWord);
    
    /**
     * Article테이블에서 키워드를 조회<br>
     * start,end 까지 키워드를 테이블내에서 조회하고 데이터 반환
     */
    List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end);
    
    /**
     * Article테이블에서 articleno 조회
     */
    ModelArticle getArticle(Integer articleno);
    
    /**
     * Article테이블 insert
     */
    Integer insertArticle(ModelArticle article);
    
    /**
     * Article테이블 update<br>
     * hashmap 키워드 searchValue,updateValue 두개 사용<br>
     * if 조건 5개<br>
     * boardcd,articleno,title,email,UseYN <-5개 조건 값이 있는것으로 조회
     */
    Integer updateArticle(ModelArticle searchValue, ModelArticle updateValue);
    
    /**
     * Article테이블 delete<br>
     * if 조건 4개<br>
     * articleno,boardcd,email,UseYN 으로 조회 삭제
     */
    Integer deleteArticle(ModelArticle article);
    
    /**
     * Article테이블 조회횟수 증가<br>
     * articleno=articleno 조건으로 hit 증가
     */
    Integer increaseHit(Integer articleno);
    
    /**
     * hashmap을 인자로 받고 <br>
     * boardcd,articleno,searchWord 사용
     * 자세한건 모르겠음.
     */
    ModelArticle getNextArticle(String boardcd, int articleno, String searchWord);
    
    /**
     * hashmap을 인자로 받고 <br>
     * boardcd,articleno,searchWord 사용
     * 자세한건 모르겠음.
     */
    ModelArticle getPrevArticle(String boardcd, int articleno, String searchWord);
    
    /**
     * 
     * 
     */
    ModelAttachfile getAttachFile(int attachFileNo);
    
    /**
     * 
     * 
     */
    List<ModelAttachfile> getAttachFileList(int articleno);
    
    /**
     * 
     * @param AttachFile의 filename(어태치파일) <- String <br>  UseYN(aa@aa.co.kr) <- int <br> articleno(1)  <- int <br>  UseYN(1) <- int  <br>
              commentno에 속하는 컬럼 삭제
     * @return Integer
     */
    Integer insertAttachFile(ModelAttachfile Attachfile);
    
    /**
     * 
     * @param comments의 attachfileno(1,2,3,4,5,6,7)<- int,primary key<br> filename(어태치파일) <- String <br>  UseYN(aa@aa.co.kr) <- int <br> articleno(1)  <- int <br>  UseYN(1) <- int  <br>
              commentno에 속하는 컬럼 삭제
     * @return Integer
     */
    Integer deleteAttachFile(ModelAttachfile Attachfile );
    
    
    /**
     * @param comments의 commentno(1)<- int <br> articleno(1) <- int <br>  email(aa@aa.co.kr) <- String <br> memo("comment test") <- String <br>  regdate("2017-05-29 15:27:21") <- Date <br> InsertUID("1") <- String <br> InsertDT("") <- Date <br> UpdateUID("") <- String <br> UpdateDT("") <- Date <br>
              commentno에 속하는 컬럼 조회
     * @return ModelAttachfile
     */
    ModelComments getComment(Integer commentNo);
   
    /**
     * @param comments의 commentno(1)<- int <br> articleno(1) <- int <br>  email(aa@aa.co.kr)  <- String <br> memo("comment test")  <br>  regdate("2017-05-29 15:27:21") <- Date  <br> InsertUID("1") <- String  <br> InsertDT("") <- Date  <br> UpdateUID("") <- String <br> UpdateDT("") <- Date <br>
              commentno에 속하는 컬럼 조회
     * @return List
     */
    List<ModelComments> getCommentList(Integer articleno);
    
    /**
     * 
     * @param comments의 articleno(1)<- int <br> articleno(1) < <br>  email(aa@aa.co.kr)  <br> memo("")  <br>  regdate("")  <br> InsertUID("")  <br> InsertDT("")  <br> UpdateUID("")  <br> UpdateDT("")  <br>
              commentno에 속하는 컬럼 insert
     * @return Integer
     */
    Integer insertComment(ModelComments comments);
  
    /**
     * @param searchValue의 commentno(1) <- int,primary key <br>  updateValue
     *                 에 속하는 컬럼 update
     * @return Integer
     */
    Integer updateComment(ModelComments searchValue, ModelComments updateValue);
   
    /**
     * 
     * @param comments의 commentno(1)<- int,primary key<br> articleno(1) <- int < <br>  email(aa@aa.co.kr)  <br> articleno(1)  <- String <br>  UseYN(1) <- int <br>
              commentno에 속하는 컬럼 삭제
     * @return Integer
     */
    Integer deleteComment(ModelComments comments);
   
}
