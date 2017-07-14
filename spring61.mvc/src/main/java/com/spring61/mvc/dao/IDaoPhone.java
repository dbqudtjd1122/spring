package com.spring61.mvc.dao;

import java.util.List;

import com.spring61.mvc.model.ModelPhone;

public interface IDaoPhone {
    ModelPhone  getPhoneOne(String name);
    List<ModelPhone>  getPhoneList();
    int insertPhone( ModelPhone phone );
    int insertPhoneList( List<ModelPhone> phones );
}
