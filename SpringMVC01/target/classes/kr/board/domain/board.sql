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
