alter table member modify email varchar2 (300);

update member set password = '1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w==';

commit;

delete  from member where username = '유저06';
select * from member;

select * from member
where rownum between 6 and 10;

select *
from (select rownum as rnum, a.* from member a order by ENROLLDATE DESC)
where rnum between 6 and 10;



select * 
from ( select rownum as rnum, a.*
        from (select * from member order by ENROLLDATE desc) a)
where rnum BETWEEN 1 and 5;


/* //쿼리문 짜놔야겠다...  */
/* //기본 페이징 처리 쿼리문은 이렇게 되겠죠??? */
/* rownum과 rank  */

SELECT COUNT(*) FROM MEMBER;
delete from member where userid = 'user06';
select * from member
commit;

 select * from  
        (select rownum as rnum, a.* 
        from (select * 
                from member where userName like '%이%' order by enrolldate desc) a ) where rnum between 1 and 3;



select count(*) from MEMBER where UserName like '%이%';


select * FROM (select rownum as rnum, a.* from(select * from member where userName like '%이 order by ENROLLDATE desc) a ) where rnum between ? and ?;

select * from employee;

CREATE TABLE NOTICE(
        NOTICE_NO NUMBER PRIMARY KEY,
        NOTICE_TITLE VARCHAR2(100) NOT NULL,
        NOTICE_WRITER VARCHAR2(15) NOT NULL,
        NOTICE_CONTENT VARCHAR2(4000) NOT NULL,
        NOTICE_DATE DATE DEFAULT SYSDATE,
        FILEPATH VARCHAR2(300),
        STATUS VARCHAR2(1) DEFAULT 'Y',
        constraint fk_notice_writer FOREIGN KEY (NOTICE_WRITER) REFERENCES MEMBER (USERID)
    );

alter table member add constraint

    CREATE SEQUENCE SEQ_NOTICE_NO;

    INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL,'공지사항테스트','admin','공지사항테스트입니다',default,null,default);
    INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL,'코로나 힘내자','admin','코로나가 없어지길.',default,null,default);
    INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL,'코로나 힘내자','admin','코로나가 없어지길.',default,'file.png',default);
    COMMIT;

delete from board where BOARD_TITLE='테스트123';
select * from notice;

commit;
select * from (select rownum as rnum, a.* from( select * from notice) a) where rnum between 1 and 3;


-- 
select * from ;

select * from (select rownum as rnum, a.* from ( select * from board order by BOARD_DATE desc) a) where rnum between 1 and 5;


drop table board;
commit;
select * from USERS;

drop SEQUENCE SEQ_BOARD_NO;



--게시판생성
CREATE TABLE BOARD (	
    "BOARD_NO" NUMBER, 
	"BOARD_TITLE" VARCHAR2(50), 
	"BOARD_WRITER" VARCHAR2(15), 
	"BOARD_CONTENT" VARCHAR2(2000), 
	"BOARD_ORIGINAL_FILENAME" VARCHAR2(100), 
	"BOARD_RENAMED_FILENAME" VARCHAR2(100), 
	"BOARD_DATE" DATE DEFAULT SYSDATE, 
	"BOARD_READCOUNT" NUMBER DEFAULT 0, 
    CONSTRAINT PK_BOARD_NO PRIMARY KEY(BOARD_NO),
    CONSTRAINT FK_BOARD_WRITER FOREIGN KEY(BOARD_WRITER) REFERENCES MEMBER(USERID) ON DELETE SET NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';
COMMENT ON COLUMN "BOARD"."BOARD_WRITER" IS '게시글작성자 아이디';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';
COMMENT ON COLUMN "BOARD"."BOARD_ORIGINAL_FILENAME" IS '첨부파일원래이름';
COMMENT ON COLUMN "BOARD"."BOARD_RENAMED_FILENAME" IS '첨부파일변경이름';
COMMENT ON COLUMN "BOARD"."BOARD_DATE" IS '게시글올린날짜';
COMMENT ON COLUMN "BOARD"."BOARD_READCOUNT" IS '조회수';

--게시판시퀀스생성
CREATE SEQUENCE SEQ_BOARD_NO
START WITH 1
INCREMENT BY 1
NOMINVALUE
NOMAXVALUE
NOCYCLE
NOCACHE;


Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 1','abcd','반갑습니다',null,null,to_date('18/02/10','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 2','bcde','반갑습니다',null,null,to_date('18/02/12','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 3','cdef','반갑습니다',null,null,to_date('18/02/13','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 4','defg','반갑습니다',null,null,to_date('18/02/14','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 5','efgh','반갑습니다',null,null,to_date('18/02/15','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 6','fghi','반갑습니다',null,null,to_date('18/02/16','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 7','ghij','반갑습니다',null,null,to_date('18/02/17','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 8','hijk','반갑습니다',null,null,to_date('18/02/18','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 9','ijkl','반갑습니다',null,null,to_date('18/02/19','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 10','jklm','반갑습니다',null,null,to_date('18/02/20','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 11','klmn','반갑습니다',null,null,to_date('18/03/11','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 12','lmno','반갑습니다',null,null,to_date('18/03/12','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 13','mnop','반갑습니다',null,null,to_date('18/03/13','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 14','nopq','반갑습니다',null,null,to_date('18/03/14','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 15','opqr','반갑습니다',null,null,to_date('18/03/15','RR/MM/DD'),0);


Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 16','pqrs','반갑습니다',null,null,to_date('18/03/16','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 17','qrst','반갑습니다',null,null,to_date('18/03/17','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 18','rstu','반갑습니다',null,null,to_date('18/03/18','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 19','stuv','반갑습니다',null,null,to_date('18/03/19','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 20','tuvw','반갑습니다',null,null,to_date('18/03/20','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 21','uvwx','반갑습니다',null,null,to_date('18/04/01','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 22','vwxy','반갑습니다',null,null,to_date('18/04/02','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 23','wxyz','반갑습니다',null,null,to_date('18/04/03','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 24','admin','반갑습니다',null,null,to_date('18/04/04','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 25','abcde','반갑습니다',null,null,to_date('18/04/05','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 26','admin','반갑습니다',null,null,to_date('18/04/06','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 27','abcde','반갑습니다',null,null,to_date('18/04/07','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 28','admin','반갑습니다',null,null,to_date('18/04/08','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 29','abcde','반갑습니다',null,null,to_date('18/04/09','RR/MM/DD'),0);
Insert into webtest.BOARD (BOARD_NO,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAMED_FILENAME,BOARD_DATE,BOARD_READCOUNT) values (SEQ_BOARD_NO.nextval,'안녕하세요, 게시판입니다 - 30','admin','반갑습니다',null,null,to_date('18/04/10','RR/MM/DD'),0);

select * from board;

select * from board_comment where BOARD_REF = 46  start with board_comment_level=1 connect by prior board_comment_no=board_comment_ref;

select * from board_comment a join board_comment b on( a.board_commnet_no = b.board_comment_ref ); where board_ref=46;