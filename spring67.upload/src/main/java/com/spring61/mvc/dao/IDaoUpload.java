package com.spring61.mvc.dao;

import com.spring61.mvc.model.*;

public interface IDaoUpload {
    int insertAttachFile(ModelUploadFile attachfile);
    
    int insertPhoto(ModelUploadImage attachfile);    
    ModelUploadImage getImageByte(int attachfileno);
}
