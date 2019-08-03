create table Product (
    id integer not null,
    name varchar(50) not null,
    quantity integer not null default 0,
    constraint pk_product primary key (id)
);
create sequence seq_product;

select * from product;
