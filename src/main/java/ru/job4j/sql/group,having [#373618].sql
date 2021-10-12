create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name,price) values('phone', 78000.65);
insert into devices(name,price) values('laptop', 141000.20);
insert into devices(name,price) values('tv', 204055.99);
insert into devices(name,price) values('playstation', 55000.00);
insert into devices(name,price) values('watch', 3000.31);
insert into devices(name,price) values('MP3 player', 3000.31);


insert into people(name) values('Maxim');
insert into people(name) values('Alex');
insert into people(name) values('Anna');
insert into people(name) values('Dima');
insert into people(name) values('Galy');

insert into devices_people(device_id,people_id) values(1,1);
insert into devices_people(device_id,people_id) values(2,1);
insert into devices_people(device_id,people_id) values(1,1);
insert into devices_people(device_id,people_id) values(2,1);
insert into devices_people(device_id,people_id) values(3,1);
insert into devices_people(device_id,people_id) values(4,2);
insert into devices_people(device_id,people_id) values(5,1);
insert into devices_people(device_id,people_id) values(6,1);
insert into devices_people(device_id,people_id) values(5,2);
insert into devices_people(device_id,people_id) values(6,2);
insert into devices_people(device_id,people_id) values(2,3);
insert into devices_people(device_id,people_id) values(3,3);
insert into devices_people(device_id,people_id) values(5,4);
insert into devices_people(device_id,people_id) values(2,4);
insert into devices_people(device_id,people_id) values(6,3);
insert into devices_people(device_id,people_id) values(1,2);
insert into devices_people(device_id,people_id) values(3,2);

select avg(price) "средняя цена" from devices;

select p.name, avg(d.price)
from devices_people dp
join people p on dp.device_id = p.id
join devices d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people dp
join people p on dp.device_id = p.id
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;


