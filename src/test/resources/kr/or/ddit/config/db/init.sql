select * from no_exists_table; --test계정에만 있는 테이블


delete rangerDept;
delete ranger;

insert into ranger values ( 'brown', '브라운');
insert into ranger values ( 'cony', '코니');
insert into ranger values ( 'sally', '샐리');
insert into ranger values ( 'moon', '문');
insert into ranger values ( 'james', '제임스');

 insert into rangerDept values ('brown', '206');
 insert into rangerDept values ('cony', '205');
 insert into rangerDept values ('sally', '204');
 insert into rangerDept values ('james', '203');
 insert into rangerDept values ('moon', '202');

commit;































