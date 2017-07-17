package com.bbs.model;

import java.util.Date;

public class ModelAttachfile {
    Integer attachfileno   ;
    String  filename       ;
    String  filetype       ;
    Long    filesize       ;
    Integer articleno      ;
    Boolean UseYN          ; 
    String  InsertUID      ;     
    Date    InsertDT       ;
    String  UpdateUID      ;     
    Date    UpdateDT       ;
    
    public Integer getAttachfileno() {
        return attachfileno;
    }
    public void setAttachfileno(Integer attachfileno) {
        this.attachfileno = attachfileno;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFiletype() {
        return filetype;
    }
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
    public Long getFilesize() {
        return filesize;
    }
    public void setFilesize(long l) {
        this.filesize = l;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public Boolean getUseYN() {
        return UseYN;
    }
    public void setUseYN(Boolean useYN) {
        UseYN = useYN;
    }
    public String getInsertUID() {
        return InsertUID;
    }
    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }
    public Date getInsertDT() {
        return InsertDT;
    }
    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }
    public String getUpdateUID() {
        return UpdateUID;
    }
    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }
    public Date getUpdateDT() {
        return UpdateDT;
    }
    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }

    public ModelAttachfile() {
        super();
    }
    
    public ModelAttachfile(Integer articleno) {
        super();
        this.articleno = articleno;
    }

    public ModelAttachfile(String filename, String filetype, Long filesize, Integer articleno) {
        super();
        this.filename = filename;
        this.filetype = filetype;
        this.filesize = filesize;
        this.articleno = articleno;
    }
    
    @Override
    public String toString() {
        return "ModelAttachfile [attachfileno=" + attachfileno + ", filename="
                + filename + ", filetype=" + filetype + ", filesize=" + filesize
                + ", articleno=" + articleno + ", UseYN=" + UseYN
                + ", InsertUID=" + InsertUID + ", InsertDT=" + InsertDT
                + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }
}
