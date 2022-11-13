create table class(
	classId varchar2(20),
	classPw varchar2(20),
	className varchar2(20),
	dates varchar2(20)
);

drop table class;

insert into class values('1', 'alpha', 'aaaaaaaa', '2022-11-01');

select * from class;

create table student(
	studentid varchar2(20) primary key,
	studentname varchar2(20),
	birth varchar2(20)
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
	classid varchar2(20),
	CONSTRAINT fk_teacher_userid FOREIGN KEY(userid)
    REFERENCES teacher(teacherid) ON DELETE CASCADE
);

create table studentTag(
	userid varchar2(20),
	classid varchar2(20),
	CONSTRAINT fk_student_userid FOREIGN KEY(userid)
    REFERENCES student(studentid) ON DELETE CASCADE
);

create table attend(
	userid varchar2(20),
	attend char(1),
	dates varchar2(20),
	CONSTRAINT fk_student_userid FOREIGN KEY(userid)
    REFERENCES student(studentid) ON DELETE CASCADE
);

insert into teacher values('1111','2222','aaaaa');


drop table teacher;
drop table student;
drop table middle;
drop table member;