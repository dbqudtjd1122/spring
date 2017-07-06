package java24.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java24.board.infc.IBoard;
import java24.board.model.ModelArticle;
import java24.board.model.ModelAttachfile;
import java24.board.model.ModelBoard;
import java24.board.model.ModelComments;

@Repository("daoboard")
public class DaoBoard implements IBoard{

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

	@Override
	public String getBoardName(String boardcd) {
		String result = "";
        result = session.selectOne("mapper.mapperBoard.getBoardName",boardcd);
        return result;
	}

	@Override
	public ModelBoard getBoardOne(String boardcd) {
		ModelBoard result = null;
        result = session.selectOne("mapper.mapperBoard.getBoardOne",boardcd);
        return result;
	}

	@Override
	public List<ModelBoard> getBoardList() {
	    List<ModelBoard> result = null;  
        result = session.selectList("mapper.mapperBoard.getBoardList");
        return result;
	}

	@Override
	public List<ModelBoard> getBoardListResultMap() {
		
		return null;
	}

	@Override
	public Integer insertBoard(ModelBoard board) {
	        int result = -1 ;
	       result = session.insert("mapper.mapperBoard.insertBoard", board);
	        return result;
	}

	@Override
	public Integer updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
	    Map<String, ModelBoard> map = new HashMap<String, ModelBoard>();
        map.put("searchValue", searchValue);
        map.put("updateValue", updateValue);
        
        int result = -1 ;
        result = session.update("mapper.mapperBoard.updateBoard", map);
        return result;
	}

	@Override
	public Integer deleteBoard(ModelBoard board) {
	    int result = -1 ;
        result = session.delete("mapper.mapperBoard.deleteBoard", board);
        return result;
	}

	@Override
	public List<ModelBoard> getBoardSearch(ModelBoard board) {
	    List<ModelBoard> result = null;  
        result = session.selectList("mapper.mapperBoard.getBoardSearch");
        return result;
	}

	@Override
	public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end) {
	    Map<String, Object> map = new HashMap();
	    
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        
        List<ModelBoard> result = null;  
        result = session.selectList("mapper.mapperBoard.getBoardPaging", map);
        return result;
	}

	@Override
	public Integer insertBoardList(List<ModelBoard> list) {
	    int result=-1;
	    
	    result = session.insert("mapper.mapperBoard.insertBoardList", list);
        
		return result;
	}

	@Override
	public Integer getArticleTotalRecord(String boardcd, String searchWord) {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        int result = -1 ; 
        result = session.selectOne("mapper.mapperBoard.getArticleTotalRecord", map);
		return result;
	}

	@Override
	public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
		Map<String, Object> map = new HashMap();
		map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
		
		
		List<ModelArticle> result = session.selectList("mapper.mapperBoard.getArticleList", map);  
		
		
		return result;
	}

	@Override
	public ModelArticle getArticle(Integer articleno) {
	    ModelArticle result = null;
        
        result = session.selectOne("mapper.mapperBoard.getArticle",articleno);
        return result;
	}

	@Override
	public Integer insertArticle(ModelArticle article) {
	    int result = -1 ;
        result = session.insert("mapper.mapperBoard.insertArticle", article);
         return result;
	}

	@Override
	public Integer updateArticle(ModelArticle searchValue, ModelArticle updateValue) {
	    Map<String, ModelArticle> map = new HashMap<String, ModelArticle>();
        map.put("searchValue", searchValue);
        map.put("updateValue", updateValue);
        
        int result = -1 ;
        result = session.update("mapper.mapperBoard.updateArticle", map);
         return result;
	}

	@Override
	public Integer deleteArticle(ModelArticle article) {
	    int result = -1 ;
        result = session.delete("mapper.mapperBoard.deleteBoard", article);
         return result;
	}

	@Override
	public Integer increaseHit(Integer articleno) {
	    int result = -1 ;
        result = session.update("mapper.mapperBoard.increaseHit", articleno);
         return result;
	}

	@Override
	public ModelArticle getNextArticle(String boardcd, int articleno, String searchWord) {
	    ModelArticle result = null;
	    Map<String, Object> map = new HashMap();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
       
        result = session.selectOne("mapper.mapperBoard.getNextArticle",map);
        return result;
	}

	@Override
	public ModelArticle getPrevArticle(String boardcd, int articleno, String searchWord) {
	    ModelArticle result = null;
        Map<String, Object> map = new HashMap();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
       
        result = session.selectOne("mapper.mapperBoard.getNextArticle",map);
        return result;
	}

	@Override
	public ModelAttachfile getAttachFile(int attachfileno) {
	    ModelAttachfile result = null;
        result = session.selectOne("mapper.mapperBoard.getAttachFile",attachfileno);
        return result;
        
	}

	@Override
	public List<ModelAttachfile> getAttachFileList(int articleno) {
	    List<ModelAttachfile> result = null;  
        result = session.selectList("mapper.mapperBoard.getAttachFileList",articleno );
        return result;
	}

	@Override
	public Integer insertAttachFile(ModelAttachfile Attachfile) {
	    int result = -1 ;
        result = session.insert("mapper.mapperBoard.insertAttachFile", Attachfile);
         return result;
	}

	@Override
	public Integer deleteAttachFile(ModelAttachfile Attachfile) {
	    int result = -1 ;
        result = session.delete("mapper.mapperBoard.deleteAttachFile", Attachfile);
         return result;
	}

	@Override
	public ModelComments getComment(Integer commentno) {
	    ModelComments result = null;
        
        result = session.selectOne("mapper.mapperBoard.getComment",commentno);
        return result;
	}

	@Override
	public List<ModelComments> getCommentList(Integer articleno) {
	    List<ModelComments> result = null;  
        result = session.selectList("mapper.mapperBoard.getCommentList", articleno);
        return result;
	}

	@Override
	public Integer insertComment(ModelComments comments) {
	    int result = -1 ;
        result = session.insert("mapper.mapperBoard.insertComment", comments);
         return result;
	}

	@Override
	public Integer updateComment(ModelComments searchValue, ModelComments updateValue) {
	    Map<String, ModelComments> map = new HashMap<String, ModelComments>();
        map.put("searchValue", searchValue);
        map.put("updateValue", updateValue);
        
        int result = -1 ;
        result = session.update("mapper.mapperBoard.updateComment", map);
         return result;
	}

	@Override
	public Integer deleteComment(ModelComments comments) {
	    int result = -1 ;
        result = session.delete("mapper.mapperBoard.deleteBoard", comments);
         return result;
	}
    
    
 
    
}
