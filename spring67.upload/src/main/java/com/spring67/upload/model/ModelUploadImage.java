package com.spring67.upload.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ModelUploadImage {

    private Integer uploadImageNo   ;    
    private String  fileName       ;
    private Long    fileSize       ;
    private String  contentType    ;
    
    // 필드 추가 2017.01.25    
    private byte[]  imageBytes;
    private String  imageBase64;
    private CommonsMultipartFile image;
    
    
    public Integer getUploadImageNo() {
        return uploadImageNo;
    }
    public void setUploadImageNo(Integer attachFileNo) {
        this.uploadImageNo = attachFileNo;
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
    public byte[] getImageBytes() {
        return imageBytes;
    }
    public void setImageBytes(byte[] photoBytes) {
        this.imageBytes = photoBytes;
    }
    public String getImageBase64() {
        return imageBase64;
    }
    public void setImageBase64(String photoBase64) {
        this.imageBase64 = photoBase64;
    }
    public CommonsMultipartFile getImage() {
        return image;
    }
    public void setImage(CommonsMultipartFile photo) {
        this.image = photo;
    }
    
    @Override
    public String toString() {
        return "ModelUploadImage [uploadImageNo=" + uploadImageNo + ", fileName="
                + fileName + ", fileSize=" + fileSize + ", contentType="
                + contentType + ", image=" + image + ", imageBytes="
                + Arrays.toString(imageBytes) + ", imageBase64=" + imageBase64
                + "]";
    }
    
    public ModelUploadImage() {
        super();
    }
    
    
    
}
