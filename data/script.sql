create table laptop(
id serial primary key,
color varchar(10),
age smallint,
status boolean
);
insert into laptop(color,age,status) values ('red', 1, true );
update laptop set status = false;
select * from laptop;
delete from laptop;
select * from laptop;
