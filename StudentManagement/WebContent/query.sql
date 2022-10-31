create table member(
	userid varchar2(20),
	username varchar2(20),
	usertype char(1),
	
	primary key(userid)


);

--create table class(
--	classId varchar2(20),
--	className varchar2(20),
--	classInfo varchar2(100),
--)
--
--create table student(
--	userid varchar2(20),
--	classId varchar2(20)
--);
--
--
--create table teacher(
--	userid varchar2(20),
--	classId varchar2(20)
--);

insert into member values('admin', '관리자');
insert into member values('user1', '금나라');
insert into member values('user2', '은나라');
insert into member values('user3', '동나라');


drop table member;