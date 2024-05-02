-- Active: 1714531532208@@127.0.0.1@3306@joeun
CREATE TABLE reply(
    no              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,        -- 댓글 번호
    board_no        INT NOT NULL,                                   -- 글 번호
    parent_no       INT NOT NULL,                                   -- 부모 번호
    writer          VARCHAR(100) NOT NULL,                               -- 작성자
    content         TEXT NOT NULL,                                  -- 내용
    reg_date        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 등록일자
    upd_date        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP    -- 수정일자
);

-- 댓글 샘플 데이터
-- 글번호 : 273
INSERT INTO reply(board_no, parent_no, writer, content)
VALUES(273, 0, '홍길동', '댓글 내용1')
     ,(273, 0, '홍길동', '댓글 내용2')
     ,(273, 0, '홍길동', '댓글 내용3')
     ,(273, 0, '홍길동', '댓글 내용4')
     ,(273, 0, '홍길동', '댓글 내용5')
;

SELECT *
FROM reply
WHERE board_no = 273;