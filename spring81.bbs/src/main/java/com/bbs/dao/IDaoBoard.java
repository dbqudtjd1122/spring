package com.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbs.model.ModelArticle;
import com.bbs.model.ModelAttachfile;
import com.bbs.model.ModelBoard;
import com.bbs.model.ModelComments;

public interface IDaoBoard {

    /*
     * 특정 게시판의 총 게시물 갯수 구하기
     */
    public abstract int getBoardTotalRecord(HashMap<String, String> hashmap);
    
    /*
     * 게시판이름 구하기
     */
    public abstract String getBoardName(String boardcd);

    /*
     * 게시판 모델 객체 구하기
     */
    public abstract ModelBoard getBoardOne(String boardcd);
    
    /*
     * 게시판종류 리스트 구하기
     */
    public abstract List<ModelBoard> getBoardList();
    
    /*
     * 게시판종류 리스트 구하기
     */
    public abstract Map<String, ModelBoard> getBoardListResultMap();
    
    /*
     * 게시판  추가
     */
    public abstract int insertBoard(ModelBoard board);
    
    /*
     * 게시판  수정
     */
    public abstract int updateBoard(ModelBoard updateBoard, ModelBoard searchBoard);
    
    /*
     * 게시판  삭제
     */
    public abstract int deleteBoard(ModelBoard board);
    
    /*
     * 
     */
    public abstract List<ModelBoard> getBoardSearch(ModelBoard board);
    
    /*
     * 
     */
    public abstract List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end);
    
    /*
     * 
     */
    public abstract int insertBoardList(List<ModelBoard> list);
    
    
    
    
    

    /*
     * 특정 게시판의 총 게시물 갯수 구하기
     */
    public abstract int getArticleTotalRecord(String boardcd, String searchWord);

    /*
     * 게시판 목록
     */
    public abstract List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end);

    /*
     * 게시글 상세보기
     */
    public abstract ModelArticle getArticle(int articleno);

    /*
     * 새로운 게시글  추가
     */
    public abstract int insertArticle(ModelArticle article);

    /*
     * 게시글 수정
     */
    public abstract int updateArticle(ModelArticle updateValue, ModelArticle searchValue);

    /*
     * 게시글 삭제
     */
    public abstract int deleteArticle(ModelArticle article);

    /*
     * 조회수 증가
     */
    public abstract int increaseHit(int articleno);
    
    /*
     * 다음글 보기 articleno,boardcd,searchWord->HahMap 에 담는다
     */
    public abstract ModelArticle getNextArticle(Map<String, Object> hashmap);

    /*
     * 이전글 보기 articleno,boardcd,searchWord->HahMap 에 담는다
     */
    public abstract ModelArticle getPrevArticle(Map<String, Object> hashmap);

    /*
     * 첨부파일
     */
    public abstract ModelAttachfile getAttachFile(int attachfileno);
    
    /*
     * 게시글의 첨부파일 리스트
     */
    public abstract List<ModelAttachfile> getAttachFileList(int articleno);

    /*
     * 새로운 첨부파일 추가 
     */
    public abstract int insertAttachFile(ModelAttachfile attachFile);

    /*
     * 첨부파일 삭제
     */
    public abstract int deleteAttachFile(ModelAttachfile attachFile);
    
    /*
     * 덧글쓰기
     */
    public abstract int insertComment(ModelComments comment);

    /*
     * 덧글수정
     */
    public abstract int updateComment(ModelComments updateValue, ModelComments searchValue);

    /*
     * 덧글삭제
     */
    public abstract int deleteComment(ModelComments comment);

    /*
     * 덧글가져오기
     */
    public abstract ModelComments getComment(int commentno);

    /*
     * 게시글의 덧글리스트 구하기
     */
    public abstract List<ModelComments> getCommentList(int articleno);

}