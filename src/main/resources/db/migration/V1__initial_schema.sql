create table "user"
(
    id bigserial not null primary key,
    login varchar(100) not null unique,
    password varchar(100) not null,
    authority varchar(100) default 'ROLE_USER' not null
);

create table cart
(
    id bigserial not null primary key,
    user_id bigint not null references "user"(id) unique
);

create table product
(
    id bigserial not null primary key,
    name varchar(100) not null,
    quantity int not null default 0,
    price numeric(9,2) not null default 0.0,
    cart_id bigint not null references cart(id)
);

insert into "user"(login, password, authority) values('user', 'password', 'ROLE_USER');
insert into "user"(login, password, authority) values('admin', 'password', 'ROLE_ADMIN');

