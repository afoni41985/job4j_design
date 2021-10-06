create table book(
id serial primary key,
name_book varchar(50)
);
create table author(
id serial primary key,
name_author varchar(50)
);
create table book_author(
id serial primary key,
book_id int references book(id),
author_id int references author(id)
);
insert into book(name_book) values('A');
insert into book(name_book) values('B');
insert into book(name_book) values('C');
insert into author(name_author) values('dog');
insert into author(name_author) values('cat');
insert into author(name_author) values('mouse');

insert into book_author(book_id,author_id) values (1,1);
insert into book_author(book_id,author_id) values (1,2);
insert into book_author(book_id,author_id) values (1,3);
insert into book_author(book_id,author_id) values (2,1);
insert into book_author(book_id,author_id) values (3,1);

select * from book_author;