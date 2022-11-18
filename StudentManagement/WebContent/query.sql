drop table class;
drop sequence emp_seq;
drop table teacher;
drop table student;
drop table studentTag;
drop table teacherTag;
drop table attend;

create table class(
	classId varchar2(20) primary key,
	classPw varchar2(20),
	className varchar2(20),
	dates date
);


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


create table teacher(
	teacherid varchar2(20) primary key,
	teacherpwd varchar2(20),
	teachername varchar2(20)
);


create table teacherTag(
	userid varchar2(20),
	classid varchar2(20),
	CONSTRAINT fk_teacher_userid FOREIGN KEY(userid)
    REFERENCES teacher(teacherid) ON DELETE CASCADE
);

create table studentTag(
	userid number(20),
	classid varchar2(20),
	CONSTRAINT fk_student_userid FOREIGN KEY(userid)
    REFERENCES student(studentid) ON DELETE CASCADE
);

create table attend(
	userid number(20),
	classid varchar2(20),
	dates date,
	CONSTRAINT fk_attend_userid FOREIGN KEY(userid)
    REFERENCES student(studentid) ON DELETE CASCADE,
    CONSTRAINT fk_attend_classid FOREIGN KEY(classid)
    REFERENCES class(classid) ON DELETE CASCADE
);


insert into class values('1', 'alpha', 'aaaaaaaa', '2022-11-01');
insert into teacher values('1111','2222','aaaaa');
insert into teacherTag values('1111','1');
insert into student values('2222','3333','2020-01-01');
insert into studentTag values('2222','1');
insert into attend values('2222', '1', '2022-11-18');


