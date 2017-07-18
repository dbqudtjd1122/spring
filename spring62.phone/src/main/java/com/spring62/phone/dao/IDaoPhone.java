package com.spring62.phone.dao;

import java.util.List;

import com.spring62.phone.model.ModelPhone;

public interface IDaoPhone {
    ModelPhone getPhoneOne(String name);
    List<ModelPhone> getPhoneList();
    int insertPhone( ModelPhone phone);
    int insertPhoneList( List<ModelPhone> phones);    
}
