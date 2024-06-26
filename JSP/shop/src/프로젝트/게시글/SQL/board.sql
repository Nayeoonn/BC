-- 게시판 테이블
CREATE TABLE board (
    no NUMBER NOT NULL PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    user_id VARCHAR2(40) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    reg_date Date DEFAULT sysdate NOT NULL,
    upd_date Date DEFAULT sysdate NOT NULL
);

-- 시퀀스
CREATE SEQUENCE SEQ_PER
INCREMENT BY 1 
MAXVALUE 1000000 
MINVALUE 1;