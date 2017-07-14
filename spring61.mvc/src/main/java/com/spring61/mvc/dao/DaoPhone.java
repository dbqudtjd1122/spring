package com.spring61.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring61.mvc.model.ModelPhone;

@Repository("daoPhone")
public class DaoPhone implements IDaoPhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSessionFactory")
    private SqlSession session;
        
    @Override
    public ModelPhone getPhoneOne(String name) {
        return session.selectOne("mapper.mysql.mapperPhone.getPhoneOne", name);
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        return session.selectList("mapper.mysql.mapperPhone.getPhoneList");
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        return session.insert("mapper.mysql.mapperPhone.insertPhone", phone);
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        return session.insert("mapper.mysql.mapperPhone.insertPhoneList", phones);
    }
}
