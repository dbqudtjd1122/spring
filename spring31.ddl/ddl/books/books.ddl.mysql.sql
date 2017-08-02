DROP DATABASE IF EXISTS book_db;
CREATE DATABASE book_db COLLATE  'utf8_general_ci';

--
USE book_db;

-- DROP TABLE IF EXISTS book;
CREATE TABLE book (
      book_id     int  NOT  NULL  auto_increment
    , title       VARCHAR(50)
    , publisher   VARCHAR(30)
    , year        VARCHAR(10)
    , price       int
    , dtm         DATE
    , use_yn      TINYINT(1) NOT NULL DEFAULT 0
    , authid      int
      
    , PRIMARY KEY(book_id)
);


-- DROP TABLE IF EXISTS auth;
CREATE TABLE auth (
      authid    INT  NOT  NULL  auto_increment
    , name      VARCHAR(50)
    , birth     VARCHAR(10)

    ,  PRIMARY KEY(authid)
);



INSERT INTO book (title, publisher, year, price, dtm, use_yn, authid)
            VALUES('Operating System', 'Wiley', '2003', 30700, '2004-01-01', 0, 1 ) ;

INSERT INTO book (title, publisher, year, price, dtm, use_yn, authid)
            VALUES('MySQL', 'OReilly', '2009',  58700, '2010-01-01', 1, 2 ) ;

INSERT INTO book (title, publisher, year, price, dtm, use_yn, authid)
            VALUES('JAVA', 'Hall', '2013', 40000, '2014-01-01', 1,  3 ) ;

INSERT INTO book (title, publisher, year, price, dtm, use_yn, authid)
            VALUES('First SQL', 'Wiley', '2015',  57700, '2016-01-01', 1, 4 ) ;


INSERT INTO auth (authid, name, birth)   VALUES(1, 'bob' , '1970.05.01' ) ;
INSERT INTO auth (authid, name, birth)   VALUES(2, 'kim' , '1980.05.01' ) ;
INSERT INTO auth (authid, name, birth)   VALUES(7, 'park', '2000.05.01' ) ;


COMMIT;
