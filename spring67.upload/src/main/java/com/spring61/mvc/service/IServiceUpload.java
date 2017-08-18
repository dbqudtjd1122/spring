package com.spring61.mvc.service;

import com.spring61.mvc.model.*;

public interface IServiceUpload {
    int insertAttachFile(ModelUploadFile attachfile);
    
    int insertPhoto(ModelUploadImage attachfile);
    ModelUploadImage getImageByte(int attachfileno);
}
