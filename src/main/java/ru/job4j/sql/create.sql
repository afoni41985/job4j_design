create table role(
id serial primary key,
roles varchar(100)
);

create table users(
id serial primary key,
name_user varchar(100),
role_id int references role(id)
);

create table rules(
id serial primary key,
rules varchar(100)
);

create table role_rules(
id serial primary key,
role_id int references role(id),
rules_id int references rules(id)
);

create table state(
id serial primary key,
state varchar(100)
);

create table category(
id serial primary key,
category varchar(100)
);

create table item(
id serial primary key,
user_id int references users(id),
category_id int references category(id),
state_id int references state(id)
);

create table comments(
id serial primary key,
comments text,
item_id int references item(id)
);

create table attachs(
id serial primary key,
attachs varchar(100),
item_id int references item(id)
);

