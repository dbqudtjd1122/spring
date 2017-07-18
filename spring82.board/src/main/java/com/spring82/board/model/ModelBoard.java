package com.spring82.board.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelBoard {
  private String  boardcd   = ""  ; // boardcd       NVARCHAR(20)   NOT NULL
  private String  boardnm   = ""  ; // boardnm       NVARCHAR(40)   NOT NULL
  private Boolean UseYN     = null; // UseYN         TINYINT(1)     NOT NULL   DEFAULT  1 
  private String  InsertUID = ""  ; // InsertUID     VARCHAR(40)    NULL                            
  private Date    InsertDT  = null; // InsertDT      DateTime       NULL
  private String  UpdateUID = ""  ; // UpdateUID     VARCHAR(40)    NULL                            
  private Date    UpdateDT  = null; // UpdateDT      DateTime       NULL
  
  
}
