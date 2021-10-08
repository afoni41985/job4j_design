create table owner(
id serial primary key,
names varchar(10)
);

create table pet(
id serial primary key,
nickname varchar(10),
owner_id int references owner(id)
);

insert into owner(names) values ('alex');
insert into pet(nickname, owner_id) values ('sql',1);
insert into pet(nickname,owner_id) values ('java',1);

select * from owner;
select * from pet;
select * from pet where id in (select id from owner);

