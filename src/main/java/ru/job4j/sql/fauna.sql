create table fauna(
id serial primary key,
	name text,
	avg_age int,
	discovery_data date
);

insert into fauna(name, avg_age, discovery_data)
values('fish_whale',22000, date '1998-01-01');
insert into fauna(name, avg_age, discovery_data)
values('exploding_pig',16000, date '1911-03-11');
insert into fauna(name, avg_age, discovery_data)
values('killer_kitten',50000, null);
insert into fauna(name, avg_age, discovery_data)
values('chinchilla_poisonous',16000, date '2021-05-07');
insert into fauna(name, avg_age, discovery_data)
values('headless_fish',15000, date '1703-11-11');
insert into fauna(name, avg_age, discovery_data)
values('guinea_pig',11000, date '1941-09-10');

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_data is null;
select * from fauna where discovery_data < '1950.01.01';