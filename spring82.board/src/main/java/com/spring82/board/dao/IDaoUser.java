package com.spring82.board.dao;

import java.util.List;

import com.spring82.board.model.*;

public interface IDaoUser {

    // 사용자 추가
    int insertUser(ModelUser user);
    
    // 사용자 로그인. HttpSession 에 사용자 정보 추가
    ModelUser login(String id, String pw );
    
    // 사용자 로그아웃. HttpSession에서 사용자 정보 삭제.
    int logout(String userid);
    
    // 사용자 정보 수정
    int updateUserInfo(ModelUser updateValue, ModelUser searchValue);
    
    // 사용자 패스워드 수정
    int updatePasswd(String newPasswd, String currentPasswd, String userid);
    
    // 사용자 탈퇴 처리
    int deleteUser(ModelUser user);
   
    // 
    ModelUser selectUserOne(ModelUser user);
    
    // 사용자 목록 출력
    List<ModelUser> selectUserList(ModelUser user);   
    
    // 사용자 아이디 존재 여부 체크. "사용 가능한 아이디" 표시할 때 사용됨.
    int checkuserid(String userid );
}
