package com.spring67.upload.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring67.upload.model.*;

@Repository
public class DaoUpload implements IDaoUpload {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    public int insertAttachFile(ModelUploadFile attachfile) {
        return session.insert("mapper.mapperUpload.insertAttachFile",attachfile);
    }

    public int insertPhoto(ModelUploadImage attachfile) {
        
       /*Oracle 용 
        Map<String, Object> map = new  HashMap<String, Object>();
        map.put("file"  , attachfile);
        map.put("result", null);
        
        session.insert("mapper.mapperUpload.insertPhoto", map);
        int result = map.get("result") != null ? (int) map.get("result") : -1;
        
        return result;
        */
        
        session.insert("mapper.mapperUpload.insertPhoto", attachfile );
        return attachfile.getUploadImageNo();
    }
    
    public ModelUploadImage getImageByte(int attachfileno) {
        return session.selectOne("mapper.mapperUpload.getImageByte", attachfileno);
    }
}
