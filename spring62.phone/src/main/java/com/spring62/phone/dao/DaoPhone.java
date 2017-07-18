package com.spring62.phone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring62.phone.model.ModelPhone;

@Repository("daophone")
public class DaoPhone implements IDaoPhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;
        
    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone result = session.selectOne("mapper.mysql.mapperPhone.????", name);
        return null;
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        // TODO Auto-generated method stub
        return 0;
    }
}
