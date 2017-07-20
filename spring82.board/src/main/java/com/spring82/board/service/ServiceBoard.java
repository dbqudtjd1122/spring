package com.spring82.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring82.board.model.ModelArticle;
import com.spring82.board.model.ModelAttachfile;
import com.spring82.board.model.ModelBoard;
import com.spring82.board.model.ModelComments;

public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public String getBoardName(String boardcd) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelBoard> getBoardListResultMap() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer insertBoard(ModelBoard board) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer deleteBoard(ModelBoard board) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            int start, int end) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer insertBoardList(List<ModelBoard> list) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer getArticleTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            int start, int end) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ModelArticle getArticle(Integer articleno) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer insertArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer updateArticle(ModelArticle searchValue,
            ModelArticle updateValue) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer deleteArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer increaseHit(Integer articleno) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ModelArticle getNextArticle(String boardcd, int articleno,
            String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ModelArticle getPrevArticle(String boardcd, int articleno,
            String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelAttachfile> getAttachFileList(int articleno) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer insertAttachFile(ModelAttachfile Attachfile) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer deleteAttachFile(ModelAttachfile Attachfile) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ModelComments getComment(Integer commentNo) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelComments> getCommentList(Integer articleno) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer insertComment(ModelComments comments) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer updateComment(ModelComments searchValue,
            ModelComments updateValue) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer deleteComment(ModelComments comments) {
        // TODO Auto-generated method stub
        return null;
    }
}
