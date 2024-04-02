-- 테이블 삭제
DROP TABLE users;

CREATE TABLE "USERS" (
	id	VARCHAR2(40)		    NOT NULL,
	pw	VARCHAR2(40)		    NOT NULL,
	name	VARCHAR2(10)		NOT NULL,
	gender	VARCHAR2(10)    NOT NULL,
	birth	VARCHAR2(10)		NOT NULL,
	mail	VARCHAR2(100)    NULL,
	join_date	Date DEFAULT sysdate NOT NULL ,
	reg_date	Date DEFAULT sysdate NOT NULL ,
	upd_date	Date DEFAULT sysdate NOT NULL
);

ALTER TABLE USERS ADD CONSTRAINT PK_USERS PRIMARY KEY (
	id
);

select *
form test;

INSERT INTO (id,password,name,gender,birth,mail) 
VALUS ('jouen', '123456', '김조은', '남자', '20241002', 'joeun@naver.com')
