package com.spring82.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring82.board.model.ModelUser;

@Repository
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;
    
    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mapper.mysql.mapperUser.insertUser", user);
    }
    
    @Override
    public ModelUser login(String id, String pw) {
        ModelUser user = new ModelUser(id, pw);
        return session.selectOne("mapper.mysql.mapperUser.login", user);
    }
    
    @Override
    public int logout(String userid) {
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {
        Map<String, ModelUser> map = new HashMap<>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        return session.update("mapper.mysql.mapperUser.updateUserInfo", map);
    }
    
    @Override
    public int updatePasswd(String newPasswd, String currentPasswd, String userid) {
        Map<String, String> map = new HashMap<>();
        map.put("newPasswd"    , newPasswd    );
        map.put("currentPasswd", currentPasswd);
        map.put("userid"       , userid       );
        return session.update("mapper.mysql.mapperUser.updatePasswd", map);
    }
    
    @Override
    public int deleteUser(ModelUser user) {
        return session.update("mapper.mysql.mapperUser.deleteUser", user);
    }
    
    @Override
    public ModelUser selectUserOne(ModelUser user) {
        return session.selectOne("mapper.mysql.mapperUser.selectUserOne", user);
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        return session.selectList("mapper.mysql.mapperUser.selectUserList", user);
    }
    
    @Override
    public int checkuserid(String userid) {
        return session.selectOne("mapper.mysql.mapperUser.checkuserid", userid);
    }
}
