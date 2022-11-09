create table class(
	classId varchar2(20),
	className varchar2(20),
	classInfo varchar2(100),
	dates varchar2(20)
);

insert into class values('1', 'alpha', 'aaaaaaaa', '2022-11-01');

create table student(
	studentid varchar2(20) primary key,
	studentname varchar2(20),
	birth varchar2(20)
);


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


insert into member values('admin', '관리자');
insert into member values('user1', '금나라');
insert into member values('user2', '은나라');
insert into member values('user3', '동나라');

drop table teacher;
drop table student;
drop table middle;