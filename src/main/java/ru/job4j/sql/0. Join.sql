create table departments(
id  serial primary key,
	name text
);

create table emploers(
id serial primary key,
	name text,
	departments_id int references departments(id)
);
	
insert into departments(name) values ('Operations');
insert into departments(name) values ('Сommercial');
insert into departments(name) values ('Information');
insert into departments(name) values ('security service');
insert into departments(name) values ('logistics');

insert into emploers(name, departments_id) values ('Petrov',1);
insert into emploers(name, departments_id) values ('Cidorov',1);

insert into emploers(name, departments_id) values ('Nif-nif',2);
insert into emploers(name, departments_id) values ('Naf-naf',2);
insert into emploers(name, departments_id) values ('Nyf-nyf',2);

insert into emploers(name, departments_id) values (null,3);

insert into emploers(name, departments_id) values (null,4);
insert into emploers(name, departments_id) values (null,4);
insert into emploers(name, departments_id) values ('Buratino',4);
insert into emploers(name, departments_id) values ('Chepalino',4);

insert into emploers(name, departments_id) values (null,5);

select * from departments d
left join emploers e
on e.departments_id = d.id;

select * from departments d
right join emploers e
on e.departments_id = d.id;

select * from departments d
cross join emploers e;

select * from departments d
left join emploers e
on e.departments_id = d.id is null;

select * from departments d
left join emploers e
on e.departments_id = d.id;
select * from  emploers e
right join departments d
on e.departments_id = d.id;




