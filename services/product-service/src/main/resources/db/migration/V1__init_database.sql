create sequence if not exists category_seq increment by 1 start with 1;
create sequence if not exists product_seq increment by 1 start with 1;

create table if not exists category
(
    id          bigint not null primary key,
    name        varchar(255),
    description varchar(255)
);

create table if not exists product
(
    id          bigint           not null primary key,
    name        varchar(255),
    description varchar(255),
    quantity    double precision not null,
    price       decimal(10, 2),
    category_id bigint
        constraint fk_category references category
);