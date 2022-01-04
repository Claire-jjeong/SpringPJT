--board table
create table board(
	idx int not null auto_increment,
	title varchar(100) not null,
	contents varchar(2000) not null,
	writer varchar(20) not null,
	indate datetime default now(), 
	count int default 0,
	primary key(idx)
);
insert into board(title,contents,writer)
values ('스프링게시판','스프링게시판','관리자');
insert into board(title,contents,writer)
values ('스프링게시판','스프링게시판','김정미');

select * from board;