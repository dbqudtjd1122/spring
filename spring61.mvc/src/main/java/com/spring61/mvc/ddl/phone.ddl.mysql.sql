
-- springboard 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS springboard;
CREATE DATABASE springboard DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 사용자 추가
GRANT ALL ON springboard.* TO tester1@localhost IDENTIFIED BY '1234';

FLUSH PRIVILEGES;


-- 데이터베이스 변경
USE springboard;


-- create a table TB_PHONE
DROP TABLE IF EXISTS TB_PHONE;
CREATE TABLE TB_PHONE (
      name          NVARCHAR(20)    NOT NULL 
    , manufacturer  NVARCHAR(40)    NOT NULL 
    , price         INTEGER         DEFAULT 0 NOT NULL 
);

select * from TB_Phone;



-- create a table TB_PERSON
DROP TABLE IF EXISTS TB_PERSON;
CREATE TABLE TB_PERSON (
      id        NVARCHAR(20)    NOT NULL
    , name      NVARCHAR(40)    NOT NULL
    , email     NVARCHAR(40)    NOT NULL
    , country   NVARCHAR(40)    NOT NULL
);

select * from TB_PERSON;


commit;
