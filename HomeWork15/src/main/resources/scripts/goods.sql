create table goods
(
    id     INT,
    tittle VARCHAR(50),
    price  DOUBLE
);
insert into goods (id, tittle, price)
values (1, 'book', 90.7);
insert into goods (id, tittle, price)
values (2, 'game', 30.9);
insert into goods (id, tittle, price)
values (3, 'pen', 71.1);
insert into goods (id, tittle, price)
values (4, 'phone', 78.7);




create table users
(
    id       int AUTO_INCREMENT,
    userName VARCHAR(50),
    password VARCHAR(50)
);



create table order
(
    id       INT,
    user_id  INT,
    total_prise DOUBLE
);


create table order_good
(
    id       INT
    order_id VARCHAR(50),
    user_id     VARCHAR(50)
);
