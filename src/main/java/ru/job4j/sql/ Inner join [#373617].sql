create table bank_account(
id serial primary key,
	number_card bigint,
	account_number bigint,
	amount_eur money
);

create table users(
id serial primary key,
	name varchar(255),
	bank_account_id int references bank_account(id) unique
);

insert into bank_account(number_card, account_number, amount_eur) 
values(1111222233334444, 123456789, 1000.00);
insert into bank_account(number_card, account_number, amount_eur) 
values(2222333344445555, 123454321,0.99 ); 
insert into bank_account(number_card, account_number, amount_eur) 
values(6666777788889999, 987654321,99999999.10);

insert into users(name,bank_account_id) 
values ('Alibaba',2);
insert into users(name,bank_account_id) 
values ('Buratino',1);
insert into users(name,bank_account_id) 
values ('Pikachy',3);

/*  **test**
select number_card nc,
account_number ac,
amount_eur ae
from bank_account;
select bank_account_id ba_id
from users;
*/
select * from users u join bank_account b on u.bank_account_id = b.id;
select u.name, b.number_card, b.account_number, b.amount_eur from users u join
bank_account b on u.bank_account_id = b.id;
select u.name "имена пользователей", b.amount_eur "деньги клиентов" from users u join
bank_account b on u.bank_account_id = b.id;
