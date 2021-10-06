create table pet(
id serial primary key,
nickname varchar(10)
);

create table owner(
id serial primary key,
names varchar(10),
pet_id int references pet(id)
);

insert into pet(nickname) values ('java');
insert into pet(nickname) values ('sql');
insert into owner(names,pet_id) values ('alex',1);

select * from owner;
select * from pet;
select * from pet where id in (select id from owner);
insert into owner(names,pet_id) values ('alex',2);
select * from pet where id in (select id from owner);
