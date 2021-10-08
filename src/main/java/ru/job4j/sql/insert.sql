insert into role(roles) values ('админ'),('пользoватель'),('гость');

insert into category(category) values ('срочная'),('текущая'),('просроченная');

insert into state(state) values ('новая'),('выполнена');

insert into rules(rules) values ('Создавать заявки'),('Редактировать заявки'),
                                ('Просматривать заявки'),('Удалять заявки');

insert into role_rules(role_id, rules_id) values (1, 1);
insert into role_rules(role_id, rules_id) values (2, 2);
insert into role_rules(role_id, rules_id) values (3, 3);

insert into role_rules(role_id, rules_id) values (1, 1);
insert into role_rules(role_id, rules_id) values (1, 3);
insert into role_rules(role_id, rules_id) values (1, 4);
insert into role_rules(role_id, rules_id) values (1, 3);

insert into role_rules(role_id, rules_id) values (2, 1);
insert into role_rules(role_id, rules_id) values (2, 3);
insert into role_rules(role_id, rules_id) values (2, 4);
insert into role_rules(role_id, rules_id) values (3, 3);

insert into users(name_user,role_id) values ('Вася',1),('Коля',2),('Дима',3);

insert into item(user_id, category_id, state_id) values (1, 3, 1);
insert into item(user_id, category_id, state_id) values (2, 2, 2);
insert into item(user_id, category_id, state_id) values (3, 1, 2);

insert into attachs(attachs, item_id) values ('a',1),('b',2),('c',3);

insert into comments(comments, item_id) values ('aaa', 1);
insert into comments(comments, item_id) values ('bbb', 2);
insert into comments(comments, item_id) values ('ccc', 3);

