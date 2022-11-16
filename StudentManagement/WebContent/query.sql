create table class(
	classId varchar2(20) primary key,
	classPw varchar2(20),
	className varchar2(20),
	dates date
);

drop table class;

insert into class values('1', 'alpha', 'aaaaaaaa', '2022-11-01');

select * from class;

create table student(
	studentid number(20) primary key,
	studentname varchar2(20),
	birth date
);


CREATE SEQUENCE student_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       NOCYCLE
       NOCACHE
       NOORDER;

drop sequence emp_seq;

create table teacher(
	teacherid varchar2(20) primary key,
	teacherpwd varchar2(20),
	teachername varchar2(20)
);


create table teacherTag(
	userid varchar2(20),
	classid varchar2(20) unique,
	CONSTRAINT fk_teacher_userid FOREIGN KEY(userid)
    REFERENCES teacher(teacherid) ON DELETE CASCADE
);

create table studentTag(
	userid number(20),
	classid varchar2(20) unique,
	CONSTRAINT fk_student_userid FOREIGN KEY(userid)
    REFERENCES student(studentid) ON DELETE CASCADE
);

create table attend(
	userid number(20),
	classid varchar2(20),
	attend char(1),
	dates date,
	CONSTRAINT fk_attend_userid FOREIGN KEY(userid)
    REFERENCES student(studentid) ON DELETE CASCADE
);

drop table attend;

insert into teacher values('1111','2222','aaaaa');

insert into student values('2222','3333','2020-01-01');
insert into studentTag values('2222','1');

select * from student;
select * from teacher;
drop table studentTag;
drop table teacherTag;
drop table student;
select * from studentTag;

SELECT student_seq.nextval FROM dual;

drop table teacher;
drop table student;
drop table middle;
drop table member;