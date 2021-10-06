create table vin(
id serial primary key,
vin int
);

create table cars(
id serial primary key,
model_car varchar (50),
vin_id int references vin(id) unique
);

insert into vin(vin) values (123456);
insert into cars(model_car, vin_id) values ('mazda',1);
select * from vin where id in(select id from cars);



