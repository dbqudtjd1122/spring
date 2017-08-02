package com.spring81.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelArticleRecommend;
import com.spring81.bbs.model.ModelAttachfile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;

public interface IDaoBoard {

    /*
     * 특정 게시판의 총 게시물 갯수 구하기
     */
    int getBoardTotalRecord(String boardcd, String searchWord);
    
    /*
     * 게시판이름 구하기
     */
    String getBoardName(String boardcd);

    /*
     * 게시판 모델 객체 구하기
     */
    ModelBoard getBoardOne(String boardcd);
    
    /*
     * 게시판종류 리스트 구하기
     */
    List<ModelBoard> getBoardList();
    
    /*
     * 게시판종류 리스트 구하기
     */
    Map<String, ModelBoard> getBoardListResultMap();
    
    /*
     * 게시판  추가
     */
    int insertBoard(ModelBoard board);
    
    /*
     * 게시판  수정
     */
    int updateBoard(ModelBoard updateBoard, ModelBoard searchBoard);
    
    /*
     * 게시판  삭제
     */
    int deleteBoard(ModelBoard board);
    
    /*
     * 
     */
    List<ModelBoard> getBoardSearch(ModelBoard board);
    
    /*
     * 
     */
    List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end);
    
    /*
     * 
     */
    int insertBoardList(List<ModelBoard> list);
    
    
    
    
    

    /*
     * 특정 게시판의 총 게시물 갯수 구하기
     */
    int getArticleTotalRecord(String boardcd, String searchWord);

    /*
     * 게시판 목록
     */
    List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end);

    /*
     * 게시글 상세보기
     */
    ModelArticle getArticle(int articleno);

    /*
     * 새로운 게시글  추가
     */
    int insertArticle(ModelArticle article);

    /*
     * 게시글 수정
     */
    int updateArticle(ModelArticle updateValue, ModelArticle searchValue);

    /*
     * 게시글 삭제
     */
    int deleteArticle(ModelArticle article);

    /*
     * 조회수 증가
     */
    int increaseHit(int articleno);
    
    /*
     * 다음글 보기 articleno,boardcd,searchWord->HahMap 에 담는다
     */
    ModelArticle getNextArticle(int articleno, String boardcd, String searchWord);

    /*
     * 이전글 보기 articleno,boardcd,searchWord->HahMap 에 담는다
     */
    ModelArticle getPrevArticle(int articleno, String boardcd, String searchWord);

    /*
     * 첨부파일
     */
    ModelAttachfile getAttachFile(int attachfileno);
    
    /*
     * 게시글의 첨부파일 리스트
     */
    List<ModelAttachfile> getAttachFileList(int articleno);

    /*
     * 새로운 첨부파일 추가 
     */
    int insertAttachFile(ModelAttachfile attachFile);

    /*
     * 첨부파일 삭제
     */
    int deleteAttachFile(ModelAttachfile attachFile);
    
    /*
     * 덧글쓰기
     */
    int insertComment(ModelComments comment);

    /*
     * 덧글수정
     */
    int updateComment(ModelComments updateValue, ModelComments searchValue);

    /*
     * 덧글삭제
     */
    int deleteComment(ModelComments comment);

    /*
     * 덧글가져오기
     */
    ModelComments getComment(int commentno);

    /*
     * 게시글의 덧글리스트 구하기
     */
    List<ModelComments> getCommentList(int articleno);

    /*
     * 
     */
    int updateRecommend(ModelArticleRecommend recommend);

    /*
     * 
     */
    int deleteRecommend(ModelArticleRecommend recommend);

    /*
     * 
     */    
    ModelArticleRecommend getRecommendOne(ModelArticleRecommend recommend);

    /*
     * 
     */    
    int updateArticleGoodBadCount(int articleno);
    
    
    
    
}