package com.spring82.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring82.board.model.ModelUser;

public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public int insertUser(ModelUser user) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ModelUser login(String id, String pw) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updatePasswd(String newPasswd, String currentPasswd,
            String userid) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteUser(ModelUser user) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ModelUser selectUserOne(ModelUser user) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int checkuserid(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }
}
