
-- springboard 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS springboard;

CREATE DATABASE springboard DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


-- 사용자 추가
GRANT ALL ON springboard.* TO tester1@localhost IDENTIFIED BY '1234';


FLUSH PRIVILEGES;



-- 데이터베이스 변경
USE springboard;


DROP TABLE IF EXISTS TB_Bbs_Article;
DROP TABLE IF EXISTS TB_Bbs_Board;

-- 게시판 종류 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_Board (
      boardcd       NVARCHAR(20)   NOT NULL
    , boardnm       NVARCHAR(40)   NOT NULL
                                   
    , UseYN         TINYINT(1)     NOT NULL   DEFAULT  1 
                                   
    , InsertUID     VARCHAR(40)    NULL                            
    , InsertDT      DateTime       NULL
    , UpdateUID     VARCHAR(40)    NULL                            
    , UpdateDT      DateTime       NULL
    
    , PRIMARY KEY(boardcd)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Board(boardcd, boardnm) values ('free','자유게시판');
insert into TB_Bbs_Board(boardcd, boardnm) values ('qna' ,'QnA게시판' );
insert into TB_Bbs_Board(boardcd, boardnm) values ('data','자료실'    );

select * from TB_Bbs_Board;



-- 게시글 테이블
CREATE TABLE IF NOT EXISTS  TB_Bbs_Article (
      articleno     INT UNSIGNED  NOT NULL AUTO_INCREMENT
    , boardcd       NVARCHAR(20)
    , title         NVARCHAR(200) NOT NULL
    , content       MEDIUMTEXT
    , email         NVARCHAR(60)
    , hit           INT UNSIGNED  DEFAULT  0   
    , regdate       DateTime
                       
    , UseYN         TINYINT(1)    NOT NULL   DEFAULT  1  
                                  
    , InsertUID     VARCHAR(40)   NULL                            
    , InsertDT      DateTime      NULL
    , UpdateUID     VARCHAR(40)   NULL                            
    , UpdateDT      DateTime      NULL
    
    , PRIMARY KEY(articleno)
    , FOREIGN KEY(boardcd) REFERENCES TB_Bbs_Board(boardcd)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 01", "article test 01", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 02", "article test 02", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 03", "article test 03", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 04", "article test 04", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 05", "article test 05", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 06", "article test 06", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 07", "article test 07", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 08", "article test 08", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 09", "article test 09", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 10", "article test 10", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 11", "article test 11", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 12", "article test 12", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 13", "article test 13", "aa@aa.co.kr", 0, now(), 1 );
insert into TB_Bbs_Article( boardcd, title, content, email, hit, regdate, UseYN ) values ( "free", "article test 14", "article test 14", "aa@aa.co.kr", 0, now(), 1 );

select * from TB_Bbs_Article;



-- 덧글 테이블
DROP TABLE IF EXISTS TB_Bbs_Comments;
CREATE TABLE IF NOT EXISTS  TB_Bbs_Comments (
      commentno     INT UNSIGNED     NOT NULL AUTO_INCREMENT
    , articleno     INT UNSIGNED     NOT NULL     
    , email         NVARCHAR(60)  
    , memo          NVARCHAR(4000)
    , regdate       DateTime 
                       
    , UseYN         TINYINT(1)       NULL     DEFAULT  1  
                                     
    , InsertUID     VARCHAR(40)      NULL                            
    , InsertDT      DateTime         NULL
    , UpdateUID     VARCHAR(40)      NULL                            
    , UpdateDT      DateTime         NULL
    
    , PRIMARY KEY(commentno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

insert into TB_Bbs_Comments( articleno, email, memo, regdate, UseYN  ) values ( 1, "aa@aa.co.kr", "comment test", now(), 1 );
      
select * from TB_Bbs_Comments;     
           
           
-- 첨부파일 테이블
DROP TABLE IF EXISTS TB_Bbs_Attachfile;
CREATE TABLE IF NOT EXISTS  TB_Bbs_Attachfile (
      attachfileno   INT UNSIGNED    NOT NULL AUTO_INCREMENT
    , filename       NVARCHAR(50)    NOT NULL
    , filetype       NVARCHAR(30)    
    , filesize       INT             
    , articleno      INT             
                                     
    , UseYN          TINYINT(1)      NULL     DEFAULT  1  
                                     
    , InsertUID      VARCHAR(40)     NULL                            
    , InsertDT       DateTime        NULL
    , UpdateUID      VARCHAR(40)     NULL                            
    , UpdateDT       DateTime        NULL
    
    , imageData      LONGBLOB        NULL
    
    , PRIMARY KEY(attachfileno)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');
Insert into TB_BBS_ATTACHFILE (FILENAME,FILETYPE,FILESIZE,ARTICLENO,USEYN,INSERTUID,INSERTDT,UPDATEUID,UPDATEDT) values ('어태치파일','파일타입',10,1,1,'attachfile','2016/12/09','filetype','2016/12/09');

select * from TB_Bbs_Attachfile;   

           
           
-- 회원  테이블
DROP TABLE IF EXISTS TB_User;
CREATE TABLE TB_User (
      userno        INT UNSIGNED    NOT NULL AUTO_INCREMENT
    , userid        VARCHAR( 50)    NOT NULL
    , email         NVARCHAR(100)   NOT NULL
    , passwd        NVARCHAR( 30)    
    , name          NVARCHAR( 30)    
    , mobile        VARCHAR(20)        
    , retireYN      TINYINT(1)      NULL     DEFAULT  1  
                                     
    , InsertUID     VARCHAR(40)     NULL                            
    , InsertDT      DateTime        NULL
    , UpdateUID     VARCHAR(40)     NULL                            
    , UpdateDT      DateTime        NULL
    
    , PRIMARY KEY(userno)
    , UNIQUE KEY(userid)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

select * from TB_User;


           
           
--  Phone 테이블
DROP TABLE IF EXISTS TB_Phone;
CREATE TABLE IF NOT EXISTS  TB_Phone (
      name           NVARCHAR(50)    NOT NULL
    , manufacturer   NVARCHAR(30)    NOT NULL
    , price          INT             NOT NULL 
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;

select * from TB_Phone;   




commit;
  





