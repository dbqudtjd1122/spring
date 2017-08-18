
USE springboard;


DROP TABLE IF EXISTS TB_Upload_File;
CREATE TABLE TB_Upload_File (
      uploadFileNo   INT UNSIGNED   NOT NULL AUTO_INCREMENT
    , fileName       NVARCHAR(50)   NOT NULL
    , fileSize       INT UNSIGNED   NOT NULL    
    , contentType    NVARCHAR(30)   NOT NULL 
    
    , PRIMARY KEY(uploadFileNo)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci
;


DROP TABLE IF EXISTS TB_Upload_Image;
CREATE TABLE TB_Upload_Image (
      uploadImageNo  INT UNSIGNED   NOT NULL AUTO_INCREMENT 
    , fileName       NVARCHAR(50)   NOT NULL
    , fileSize       INT UNSIGNED   NOT NULL    
    , contentType    NVARCHAR(30)   NOT NULL 
    
    , imageBytes     LONGBLOB  -- 사진 저장 컬럼. 바이너리로 이미지 저장
    , imageBase64    LONGTEXT  -- 사진 저장 컬럼. BASE64로 이미지 저장

    , PRIMARY KEY(uploadImageNo)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci
;

