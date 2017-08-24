-- 테이블 제거하기
BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Upload_File CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Upload_Image CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

           
-- 첨부파일 테이블
CREATE TABLE TB_Upload_File (
      uploadFileNo   NUMBER(10)     generated as identity 
    , fileName       VARCHAR2(50)   NOT NULL
    , fileSize       NUMBER(10)     NOT NULL    
    , contentType    VARCHAR2(30)   NOT NULL 
    
    , PRIMARY KEY(uploadFileNo)
);

Insert into TB_Upload_File (fileName,contentType,fileSize) values ('어태치파일','파일타입',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('어태치파일','파일타입',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('어태치파일','파일타입',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('어태치파일','파일타입',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('어태치파일','파일타입',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('어태치파일','파일타입',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('어태치파일','파일타입',10);

select * from TB_Upload_File;   

           
                   
-- 첨부파일 테이블
CREATE TABLE TB_Upload_Image (
      uploadImageNo  NUMBER(10)     generated as identity 
    , fileName       VARCHAR2(50)   NOT NULL
    , fileSize       NUMBER(10)     NOT NULL    
    , contentType    VARCHAR(50)    NOT NULL
    , imageBytes     BLOB  -- 사진 저장 컬럼. 바이너리로 이미지 저장
    , imageBase64    CLOB  -- 사진 저장 컬럼. BASE64 문자열로 이미지 저장
    
    , PRIMARY KEY(uploadImageNo)
);


select * from TB_Upload_Image;   

commit;
