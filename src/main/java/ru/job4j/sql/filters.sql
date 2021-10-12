create table type(
id serial primary key,
	name text
);

create table product(
id serial primary key,
	name text,
	expired_date date,
	price numeric(10, 2),
	type_id int references type(id)
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('КОЛБАСА');

insert into product(name, type_id, expired_date, price) values
('сыр масдам', 1 , date '2021-02-02', 630.50);
insert into product(name, type_id, expired_date, price) values
('сыр пармезан', 1 , date '2021-03-15', 750.40);
insert into product(name, type_id, expired_date, price) values
('сыр гауда', 1 , date '2021-01-01', 500.1);

insert into product(name, type_id, expired_date, price) values
('молоко деревенское', 2 , date '2021-04-05', 55.51);
 insert into product(name, type_id, expired_date, price) values
('молоко отборное', 2 , date '2021-05-06', 49.30);
insert into product(name, type_id, expired_date, price) values
('молоко 2.5', 2 , date '2021-06-07', 50.44);

insert into product(name, type_id, expired_date, price) values
('колбаса вареная', 3 , date '2021-07-06', 100.11);
 insert into product(name, type_id, expired_date, price) values
('сервелат', 3 , date '2021-08-07', 178.20);
insert into product(name, type_id, expired_date, price) values
('праздничная', 3 , date '2021-09-08', 234.44);

select t.name, p.name, p.price, p.expired_date
from type t
join product p
on t.id = p.type_id
and t.name = 'СЫР';

select * from product
where name like '%мороженое%';

select * from product
where expired_date < current_date;

select name, price
from product
where price = (select max(price) from product);

select t.name, count(t.id)
from type as t
join product as p on t.id = p.type_id
group by t.id;

select t.name, p.name, p.price, p.expired_date
from type t
join product p
on t.id = p.type_id
and t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name, count(*)
from product
join type t
on type_id = t.id
group by t.name
having count(t.name) < 10;

select t.name, p.name, p.price, p.expired_date
from type t
join product p
on t.id = p.type_id;