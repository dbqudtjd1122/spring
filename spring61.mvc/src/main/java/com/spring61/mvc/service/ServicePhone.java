package com.spring61.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring61.mvc.dao.IDaoPhone;
import com.spring61.mvc.model.ModelPhone;

@Service
public class ServicePhone implements IServicePhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daoPhone")
    IDaoPhone dao ;
    
    @Override
    public ModelPhone getPhoneOne(String name) { 
        ModelPhone result = null;
        try {
            result = dao.getPhoneOne(name);
        } catch (Exception e) {
            logger.error("getPhoneOne" + e.getMessage() );
        }
        return result ;
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> result = null;
        try {
            result = dao.getPhoneList();
        } catch (Exception e) {
            logger.error("getPhoneList" + e.getMessage() );
        }
        return result;
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        int result = -1;
        try {
            result = dao.insertPhone(phone);
        } catch (Exception e) {
            logger.error("insertPhone" + e.getMessage() );
        }
        return result ;
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        int result = -1;
        try {
            result = dao.insertPhoneList(phones);
        } catch (Exception e) {
            logger.error("insertPhone" + e.getMessage() );
        }
        return result ;
    }
}
