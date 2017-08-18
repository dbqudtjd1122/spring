package com.spring61.mvc.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ModelUploadFile {

    private Integer uploadFileNo   ;    
    private String  fileName       ;
    private Long    fileSize       ;
    private String  contentType    ;
  
    public Integer getUploadFileNo() {
        return uploadFileNo;
    }
    public void setUploadFileNo(Integer uploadFileNo) {
        this.uploadFileNo = uploadFileNo;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Long getFileSize() {
        return fileSize;
    }
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    @Override
    public String toString() {
        return "ModelUploadFile [uploadFileNo=" + uploadFileNo + ", fileName="
                + fileName + ", fileSize=" + fileSize + ", contentType="
                + contentType + "]";
    }
    
    public ModelUploadFile() {
        super();
    }
    
}
