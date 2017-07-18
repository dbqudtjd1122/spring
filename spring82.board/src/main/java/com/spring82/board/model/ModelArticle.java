package com.spring82.board.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelArticle {
    private Integer articleno = null ;// articleno     INT UNSIGNED 
    private String  boardcd   = ""   ;// boardcd       NVARCHAR(20)
    private String  title     = ""   ;// title         NVARCHAR(200)
    private String  content   = ""   ;// content       MEDIUMTEXT
    private String  email     = ""   ;// email         NVARCHAR(60)
    private Integer hit       = null ;// hit           INT UNSIGNED 
    private Date    regdate   = null ;// regdate       DateTime
    private Boolean UseYN     = null ;// UseYN         TINYINT(1)     
    private String  InsertUID = ""   ;// InsertUID     VARCHAR(40)  
    private Date    InsertDT  = null ;// InsertDT      DateTime     
    private String  UpdateUID = ""   ;// UpdateUID     VARCHAR(40)  
    private Date    UpdateDT  = null ;// UpdateDT      DateTime  
    
    
}
