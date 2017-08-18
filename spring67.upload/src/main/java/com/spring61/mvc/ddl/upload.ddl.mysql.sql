
USE springboard;


-- create a table TB_PHONE
DROP TABLE IF EXISTS TB_Upload_File;
CREATE TABLE TB_Upload_File (
      uploadFileNo   NUMBER(10)     generated as identity 
    , fileName       VARCHAR2(50)   NOT NULL
    , fileSize       NUMBER(10)     NOT NULL    
    , contentType    VARCHAR2(30)   NOT NULL 
    
    , PRIMARY KEY(uploadFileNo)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;


commit;
