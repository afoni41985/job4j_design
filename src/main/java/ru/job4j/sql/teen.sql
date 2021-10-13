create table teens(
id serial primary key,
	name text,
	gender char(6)
);

insert into teens(name, gender) values ('ivanov','male');
insert into teens(name, gender) values ('Petrov','male');
insert into teens(name, gender) values ('Sidorov','male');
insert into teens(name, gender) values ('Ivanova','female');
insert into teens(name, gender) values ('Petrova','female');
insert into teens(name, gender) values ('Sidorova','female');
insert into teens(name, gender) values ('Kyrochkina','female');

select * from teens t 
cross join teens t1 
where t.gender != t1.gender;