drop table persistent_logins;

-- 자동로그인 테이블
CREATE TABLE persistent_logins (
  p_no NUMBER NOT NULL PRIMARY KEY,
  user_id varchar2(255) NOT NULL ,
  token varchar2(255) NOT NULL ,
  reg_date DATE DEFAULT SYSDATE NOT NULL,
  upd_date DATE DEFAULT SYSDATE NOT NULL,
  PRIMARY KEY (p_no),
);
-- 시퀀스
CREATE SEQUENCE SEQ_PER_LOGIN INCREMENT BY 1 START WITH 1 MAXVALUE 1000000 MINVALUE 1;