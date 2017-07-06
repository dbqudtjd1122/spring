package java24.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java24.board.dao.DaoBoard;
import java24.board.infc.IBoard;
import java24.board.model.ModelArticle;
import java24.board.model.ModelAttachfile;
import java24.board.model.ModelBoard;
import java24.board.model.ModelComments;

import java.util.List;


@Service("serviceboard")
public class ServiceBoard implements IBoard{
    private static Logger log = LoggerFactory.getLogger(ServiceBoard.class);
    

    @Autowired
    @Qualifier("daoboard")
    private DaoBoard dao;


    @Override
    public String getBoardName(String boardcd) {
        String result = "" ;
        try {
            result = dao.getBoardName(boardcd);
        } catch (Exception e) {
            log.error("getBoardName"+e.getMessage());

        }

        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        
        ModelBoard result = null;
        try {
            result = dao.getBoardOne(boardcd);
        } catch (Exception e) {
            log.error("getBoardOne"+e.getMessage());

        }
        return result;
    }

    @Override
    public List<ModelBoard> getBoardList() {
        
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardList();
        } catch (Exception e) {
            log.error("SelectAll"+e.getMessage());

        }


        return result;
    }

    @Override
    public List<ModelBoard> getBoardListResultMap() {
      
        return null;
    }

    @Override
    public Integer insertBoard(ModelBoard board) {
        
        int result = -1 ; 
        
        try {
            result = dao.insertBoard(board);
        } catch (Exception e) {
            log.error("insertBoard"+e.getMessage());

        }
        
        return result;
    }

    @Override
    public Integer updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
        
        int result = -1 ; 
        
        try {
            result = dao.updateBoard(searchValue,updateValue);
        } catch (Exception e) {
            log.error("updateBoard"+e.getMessage());
        }
        
        return result;
    }

    @Override
    public Integer deleteBoard(ModelBoard board) {
        
        int result = -1 ; 
        
        try {
            result = dao.deleteBoard(board);
        } catch (Exception e) {
            log.error("deleteBoard"+e.getMessage());
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        
        List<ModelBoard> result = null;
        
        try {
            result = dao.getBoardSearch(board);
        } catch (Exception e) {
            log.error("getBoardSearch"+e.getMessage());

        }


        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end) {
        List<ModelBoard> result = null;
        
        try {
            result = dao.getBoardPaging(boardcd, searchWord,  start,  end);
        } catch (Exception e) {
            log.error("getBoardPaging"+e.getMessage());

        }
        
        return result;
    }

    @Override
    public Integer insertBoardList(List<ModelBoard> list) {
        int result=-1;
        try {
            result = dao.insertBoardList(list);
        } catch (Exception e) {
            log.error("insertBoardList"+e.getMessage());

        }
        
        return result;
    }

    @Override
    public Integer getArticleTotalRecord(String boardcd, String searchWord) {
        int result = -1 ; 
        try {
            result = dao.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            log.error("getArticleTotalRecord"+e.getMessage());

        }
        
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticleList(boardcd, searchWord,  start,  end);
        } catch (Exception e) {
            log.error("getArticleList"+e.getMessage());

        }


        return result;
    }

    @Override
    public ModelArticle getArticle(Integer articleno) {
        ModelArticle result = null;
        try {
            result = dao.getArticle(articleno);
        } catch (Exception e) {
            log.error("getArticle"+e.getMessage());

        }
        return result;
    }

    @Override
    public Integer insertArticle(ModelArticle article) {
        
        return null;
    }

    @Override
    public Integer updateArticle(ModelArticle searchValue,
            ModelArticle updateValue) {
       int result = 0 ;
        return null;
    }

    @Override
    public Integer deleteArticle(ModelArticle article) {
        
        return null;
    }

    @Override
    public Integer increaseHit(Integer articleno) {
        
        return null;
    }

    @Override
    public ModelArticle getNextArticle(String boardcd, int articleno, String searchWord) {
        ModelArticle result = null;
        try {
            result = dao.getNextArticle(boardcd, articleno, searchWord);
        } catch (Exception e) {
            log.error("getNextArticle"+e.getMessage());

        }
        return result;
    }

    @Override
    public ModelArticle getPrevArticle(String boardcd, int articleno, String searchWord) {
        
        return null;
    }

    @Override
    public ModelAttachfile getAttachFile(int attachfileno) {
        
        ModelAttachfile result = null;
        try {
            result = dao.getAttachFile(attachfileno);
        } catch (Exception e) {
            log.error("getAttachFile"+e.getMessage());

        }
        return result;
    }

    @Override
    public List<ModelAttachfile> getAttachFileList(int articleno) {
        
        return null;
    }

    @Override
    public Integer insertAttachFile(ModelAttachfile Attachfile) {
        
        return null;
    }

    @Override
    public Integer deleteAttachFile(ModelAttachfile Attachfile) {
        
        return null;
    }

    @Override
    public ModelComments getComment(Integer commentno) {
        ModelComments result = null;
        try {
            result = dao.getComment(commentno);
        } catch (Exception e) {
            log.error("getComment"+e.getMessage());

        }
        return result;
    }

    @Override
    public List<ModelComments> getCommentList(Integer articleno) {
        
        
        List<ModelComments> result = null;
        try {
            result = dao.getCommentList(articleno);
        } catch (Exception e) {
            log.error("getCommentList"+e.getMessage());

        }


        return result;
    }

    @Override
    public Integer insertComment(ModelComments comments) {
        int result = -1 ; 
        
        try {
            result = dao.insertComment(comments);
        } catch (Exception e) {
            log.error("insertComment"+e.getMessage());

        }
        
        return result;
    }

    @Override
    public Integer updateComment(ModelComments searchValue,
            ModelComments updateValue) {
        
        return null;
    }

    @Override
    public Integer deleteComment(ModelComments comments) {
        
        return null;
    }

 
    
    
}
