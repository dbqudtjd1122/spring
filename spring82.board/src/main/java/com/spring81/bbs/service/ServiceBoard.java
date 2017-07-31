package com.spring81.bbs.service;

import java.util.*;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.spring81.bbs.commons.WebConstants;
import com.spring81.bbs.dao.*;
import com.spring81.bbs.model.*;

@Service("serviceboard")
public class ServiceBoard implements IServiceBoard {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
    
    @Autowired
    @Qualifier("daoboard")
    private IDaoBoard daoboard;

    @Override
    public String getBoardName(String boardcd) {
        
        String result = null;
        try {
            result = daoboard.getBoardName(boardcd);
        } catch (Exception e) {
            logger.error("getBoardName " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard result = null;
        try {
            result = daoboard.getBoardOne(boardcd);
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ModelBoard> getBoardList() {
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardList();
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        Map<String, ModelBoard> result = null;
        try {
            result = daoboard.getBoardListResultMap();
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) {
        
        int result = -1;
        try {
            result = daoboard.insertBoard(board);
        } catch (Exception e) {
            logger.error("insertBoard " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateBoard(ModelBoard updateBoard, ModelBoard searchBoard) {
        
        int result = -1;
        try {
            result = daoboard.updateBoard(updateBoard, searchBoard);
        } catch (Exception e) {
            logger.error("updateBoard" + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        int result = -1;
        try {
            result = daoboard.deleteBoard(board);
        } catch (Exception e) {
            logger.error("deleteBoard" + e.getMessage());
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardSearch(board);
        } catch (Exception e) {
            logger.error("getBoardOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end) {
        
        List<ModelBoard> result = null;
        try {
            result = daoboard.getBoardPaging(boardcd, searchWord, start, end);
        } catch (Exception e) {
            logger.error("getBoardPaging  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int result = -1;
        try {
            result = daoboard.insertBoardList(list);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertBoardList" + e.getMessage() );
            //session.rollback();
        }
        
        return result;
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        int result = 0;
        try {
            result = daoboard.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            logger.error("getArticleTotalRecord  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
        
        List<ModelArticle> result = null;
        try {
            result = daoboard.getArticleList(boardcd, searchWord, start, end);
        } catch (Exception e) {
            logger.error("getArticleList  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getArticle(int articleno) {
        ModelArticle result = null;
        try {
            result = daoboard.getArticle ( articleno );
        } catch (Exception e) {
            logger.error("getArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        int result = -1;
        try {
            result = daoboard.insertArticle(article);
        } catch (Exception e) {
            logger.error("insertArticle " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue) {
        
        int result = -1;
        try {
            result = daoboard.updateArticle(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("updateArticle " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        int result = -1;
        try {
                     daoboard.deleteAttachFile(new ModelAttachfile( article.getArticleno() ) );
                     daoboard.deleteComment(new ModelComments( article.getArticleno() ) );
            result = daoboard.deleteArticle(article);
        } catch (Exception e) {
            logger.error("deleteArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int increaseHit(int articleno) {
        int result = -1;
        try {
            result = daoboard.increaseHit(articleno);
        } catch (Exception e) {
            logger.error("increaseHit  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getNextArticle(int articleno, String boardcd, String searchWord) {
        
        ModelArticle result = null;
        try {
            result = daoboard.getNextArticle( articleno, boardcd, searchWord );
        } catch (Exception e) {
            logger.error("getNextArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle getPrevArticle(int articleno, String boardcd, String searchWord) {
        
        ModelArticle result = null;
        try {
            result = daoboard.getPrevArticle( articleno, boardcd, searchWord );
        } catch (Exception e) {
            logger.error("getPrevArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelAttachfile getAttachFile(int attachfileno) {
        ModelAttachfile result = null;
        try {
            result = daoboard.getAttachFile( attachfileno );
        } catch (Exception e) {
            logger.error("getAttachFile  " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public List<ModelAttachfile> getAttachFileList(int articleno) {
        List<ModelAttachfile> result = null;
        try {
            result = daoboard.getAttachFileList( articleno );
        } catch (Exception e) {
            logger.error("getAttachFileList  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        int result = -1;
        try {
            result = daoboard.insertAttachFile(attachFile);
        } catch (Exception e) {
            logger.error("insertAttachFile " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteAttachFile(ModelAttachfile attachFile) {
        int result = -1;
        try {
            result = daoboard.deleteAttachFile(attachFile);
        } catch (Exception e) {
            logger.error("deleteAttachFile " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelComments getComment(int commentno) {
        ModelComments result = null;
        try {
            result = daoboard.getComment( commentno );
        } catch (Exception e) {
            logger.error("getComment  " + e.getMessage() );
        }
        
        return result;
    }


    @Override
    public List<ModelComments> getCommentList(int articleno) {
        List<ModelComments>  result = null;
        try {
            result = daoboard.getCommentList( articleno );
        } catch (Exception e) {
            logger.error("getCommentList  " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comment) {
        int result = -1;
        try {
            result = daoboard.insertComment(comment);
        } catch (Exception e) {
            logger.error("insertComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        int result = -1;
        try {
            result = daoboard.updateComment( updateValue, searchValue );
        } catch (Exception e) {
            logger.error("updateComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteComment(ModelComments comment) {
        int result = -1;
        try {
            result = daoboard.deleteComment( comment );
        } catch (Exception e) {
            logger.error("deleteComment " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticle transUpdateHitAndGetArticle(int articleno) {
        ModelArticle result = null;
        try {

            // 상세보기를 할때마다 조회수를 1 증가
            // 하단에 목록에서 조회수를 제대로 보기위해서는
            // 목록 레코드를 페치하기 전에 조회수를 먼저 증가시켜야 한다.
            // 사용자 IP 와 시간을 고려해서 조회수를 증가하도록...
            
                     daoboard.increaseHit( articleno );
            result = daoboard.getArticle ( articleno );
        } catch (Exception e) {
            logger.error("getArticle  " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int transDeleteArticle(String boardcd, int articleno) {
        // artilcedelet 시.
        // 1. TB_BBS_Comments 테이블에서 있는 comment 정보 삭제.
        // 2. 업로드 폴더에서 관련된 첨부 파일 삭제.
        // 3. TB_BBS_AttachFile 테이블에서 있는 attachfile 정보 삭제.
        // 4. TB_BBS_Article 테이블에서 artilce 정보 삭제
        
        int result = -1;

        // 1. TB_BBS_Comments 테이블에서 있는 comment 정보 삭제
        ModelComments comment = new ModelComments( articleno );
        result = daoboard.deleteComment(comment );
        
        // 2. 업로드 폴더에서 관련된 첨부 파일 삭제.
        List<ModelAttachfile> files = daoboard.getAttachFileList(articleno);
        for (int i = 0; i < files.size(); i++) {
            ModelAttachfile attachfile = files.get(i);
            
            String path = WebConstants.UPLOAD_PATH + attachfile.getTempfilename();
            java.io.File   file = new java.io.File( path );
            
            if( file.exists() ) {
                file.delete();           
            }
        }
        
        // 3. TB_BBS_AttachFile 테이블에서 있는 attachfile 정보 삭제.
        ModelAttachfile attachFile = new ModelAttachfile();
        attachFile.setArticleno(articleno);
        daoboard.deleteAttachFile(attachFile);
        

        // 4. TB_BBS_Article 테이블에서 artilce 정보 삭제
        ModelArticle article = new ModelArticle();
        article.setArticleno(articleno);                
        result = daoboard.deleteArticle(article);        
        
        return result;
    }

    @Override
    public int updateArticleCountGood(int articleno, int count) {
        int result = -1;
        try {
            result = daoboard.updateArticleCountGood( articleno, count );
        } catch (Exception e) {
            logger.error("updateArticleCountGood " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateArticleCountBad(int articleno, int count) {
        int result = -1;
        try {
            result = daoboard.updateArticleCountBad( articleno, count );
        } catch (Exception e) {
            logger.error("updateArticleCountBad " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateRecommend(ModelArticleRecommend recommend) {
        int result = -1;
        try {
            result = daoboard.updateRecommend( recommend);
        } catch (Exception e) {
            logger.error("updateRecommend " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int deleteRecommend(ModelArticleRecommend recommend) {
        int result = -1;
        try {
            result = daoboard.deleteRecommend( recommend);
        } catch (Exception e) {
            logger.error("deleteRecommend " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public ModelArticleRecommend getRecommendOne( ModelArticleRecommend recommend) {
        ModelArticleRecommend result = null;
        try {
            result = daoboard.getRecommendOne( recommend);
        } catch (Exception e) {
            logger.error("getRecommendOne " + e.getMessage() );
        }
        
        return result;
    }

    @Override
    public int updateArticleGoodBadCount(int articleno) {
        int result = -1;
        try {
            result = daoboard.updateArticleGoodBadCount( articleno );
        } catch (Exception e) {
            logger.error("updateArticleGoodBadCount " + e.getMessage() );
        }
        
        return result;
    }
}
