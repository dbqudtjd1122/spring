package com.spring67.upload.service;

import com.spring67.upload.model.*;

public interface IServiceUpload {
    int insertAttachFile(ModelUploadFile attachfile);
    
    int insertPhoto(ModelUploadImage attachfile);
    ModelUploadImage getImageByte(int attachfileno);
}
