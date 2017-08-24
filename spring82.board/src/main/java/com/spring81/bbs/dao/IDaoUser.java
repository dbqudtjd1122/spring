package com.spring81.bbs.dao;

import java.util.List;

import com.spring81.bbs.model.ModelUser;

public interface IDaoUser {

   int insertUser(ModelUser user);
   
   ModelUser login(String id, String pw );
   
   int logout(String userid);
   
   int updateUserInfo(ModelUser updateValue, ModelUser searchValue);
   
   int updatePasswd(String newPasswd, String currentPasswd, String userid);
   
   int deleteUser(ModelUser user);
   
   ModelUser selectUserOne(Integer userno);
   
   List<ModelUser> selectUserList(ModelUser user);   

   int checkuserid(String userid );
}
