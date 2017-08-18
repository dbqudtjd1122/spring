package com.spring67.upload.dao;

import com.spring67.upload.model.*;

public interface IDaoUpload {
    int insertAttachFile(ModelUploadFile attachfile);
    
    int insertPhoto(ModelUploadImage attachfile);    
    ModelUploadImage getImageByte(int attachfileno);
}
