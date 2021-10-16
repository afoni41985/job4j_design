create table body(
id serial primary key,
	name text
);

create table engine(
id serial primary key,
power int
);

create table transmission(
id serial primary key,
name text
);

create table cars(
id serial primary key,
    name text,
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body(name) values ('A');
insert into body(name) values ('B');
insert into body(name) values ('C');
insert into body(name) values ('D');
insert into body(name) values ('E');

insert into engine(power) values (130);
insert into engine(power) values (180);
insert into engine(power) values (98);
insert into engine(power) values (250);
insert into engine(power) values (300);

insert into transmission(name) values('Mechanics');
insert into transmission(name) values('Automaton');
insert into transmission(name) values('Robot');
insert into transmission(name) values('Variator');

insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 1',1,1,1);
insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 2',4,1,2); 
insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 3',2,2,1); 
insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 4',3,3,2); 
insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 5',2,2,2); 
insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 6',4,3,3); 
insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 7',2,2,2);
insert into cars (name, body_id, engine_id, transmission_id) values ('protoyupe 8',1,1,1);

select c.name cars, b.name body, e.power engine, t.name transmission
from cars c 
join body b on c.body_id = b.id
join engine e on c.engine_id = e.id
join transmission t on c.transmission_id = t.id;

select * from body b 
left join cars c on c.body_id = b.id 
where c.id is null;

select * from engine e 
left join cars c on c.engine_id = e.id
where c.id is null;

select * from transmission t 
left join cars c on c.transmission_id = t.id
where c.id is null;

