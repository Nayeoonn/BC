-- 게시글 테이블 생성
CREATE TABLE BOARD (
    BOARD_NO NUMBER PRIMARY KEY,
    TITLE VARCHAR2(100) NOT NULL,
    WRITER VARCHAR2(50) NOT NULL,
    CONTENT VARCHAR2(1000),
    REG_DATE DATE DEFAULT SYSDATE,
    UPD_DATE DATE DEFAULT SYSDATE
);

-- 시퀀스 생성
CREATE SEQUENCE SEQ_BOARD_NO 
START WITH 1
INCREMENT BY 1
;

-- 샘플 데이터 추가
INSERT INTO BOARD (BOARD_NO, TITLE, WRITER, CONTENT) VALUES (SEQ_BOARD_NO.NEXTVAL, '제목01', '작성자01', '내용01');
INSERT INTO BOARD (BOARD_NO, TITLE, WRITER, CONTENT) VALUES (SEQ_BOARD_NO.NEXTVAL, '제목02', '작성자02', '내용02');
INSERT INTO BOARD (BOARD_NO, TITLE, WRITER, CONTENT) VALUES (SEQ_BOARD_NO.NEXTVAL, '제목03', '작성자03', '내용03');
INSERT INTO BOARD (BOARD_NO, TITLE, WRITER, CONTENT) VALUES (SEQ_BOARD_NO.NEXTVAL, '제목04', '작성자04', '내용04');
INSERT INTO BOARD (BOARD_NO, TITLE, WRITER, CONTENT) VALUES (SEQ_BOARD_NO.NEXTVAL, '제목05', '작성자05', '내용05');

--
INSERT INTO BOARD(BOARD_NO, TITLE, WRITER, CONTENT)
SELECT SEQ_BOARD_NO.NEXTVAL
      ,TITLE
      ,WRITER
      ,CONTENT
FROM BOARD;

SELECT COUNT(*) FROM BOARD;
SELECT * FROM BOARD;


-- 페이징 처리
-- 페이징 번호 : 1 (행 1~10)
SELECT *
FROM (
    SELECT ROWNUM R, BOARD_NO, TITLE, WRITER, CONTENT
    FROM (
        SELECT *
        FROM BOARD
        ORDER BY BOARD_NO DESC
    ) A
    WHERE ROWNUM <= 10     -- 마지막 행 번호
) B
WHERE B.R >= 1             -- 시작 행 번호
;
-- 사용자가 선택한 페이지 번호 : 1
-- 페이지당 보여줄 게시글 수 : 10

--














