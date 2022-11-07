create table class(
	classId varchar2(20),
	className varchar2(20),
	classInfo varchar2(100),
	dates varchar2(20)
);

insert into class values('1', 'alpha', 'aaaaaaaa', '2022-11-01');

create table student(
	idx number(20),
	studentid varchar2(20),
	studentname varchar2(20),
	birth varchar2(20),
	
);


create table teacher(
	idx number(20),
	teacherid varchar2(20),
	teachername varchar2(20),
	CONSTRAINT fk_code FOREIGN KEY(parentPk)
    REFERENCES parentTable(parentPk) ON DELETE CASCADE
);

create table middle(
	userid varchar2(20) primary key ,
	classid varhcar2(20)
);

insert into member values('admin', '관리자');
insert into member values('user1', '금나라');
insert into member values('user2', '은나라');
insert into member values('user3', '동나라');


drop table member;