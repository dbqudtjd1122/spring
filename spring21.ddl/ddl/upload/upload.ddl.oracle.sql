-- ���̺� �����ϱ�
BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Upload_File CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE TB_Upload_Image CASCADE CONSTRAINTS PURGE'; EXCEPTION WHEN OTHERS THEN NULL; END; 
/

           
-- ÷������ ���̺�
CREATE TABLE TB_Upload_File (
      uploadFileNo   NUMBER(10)     generated as identity 
    , fileName       VARCHAR2(50)   NOT NULL
    , fileSize       NUMBER(10)     NOT NULL    
    , contentType    VARCHAR2(30)   NOT NULL 
    
    , PRIMARY KEY(uploadFileNo)
);

Insert into TB_Upload_File (fileName,contentType,fileSize) values ('����ġ����','����Ÿ��',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('����ġ����','����Ÿ��',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('����ġ����','����Ÿ��',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('����ġ����','����Ÿ��',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('����ġ����','����Ÿ��',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('����ġ����','����Ÿ��',10);
Insert into TB_Upload_File (fileName,contentType,fileSize) values ('����ġ����','����Ÿ��',10);

select * from TB_Upload_File;   

           
                   
-- ÷������ ���̺�
CREATE TABLE TB_Upload_Image (
      uploadImageNo  NUMBER(10)     generated as identity 
    , fileName       VARCHAR2(50)   NOT NULL
    , fileSize       NUMBER(10)     NOT NULL    
    , contentType    VARCHAR(50)    NOT NULL
    , imageBytes     BLOB  -- ���� ���� �÷�. ���̳ʸ��� �̹��� ����
    , imageBase64    CLOB  -- ���� ���� �÷�. BASE64 ���ڿ��� �̹��� ����
    
    , PRIMARY KEY(uploadImageNo)
);


select * from TB_Upload_Image;   

commit;
