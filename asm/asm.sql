drop database java5_asm;

create database java5_asm;

use java5_asm;

create table account (
	accountid int auto_increment,
    password varchar(20),
    role boolean,
    email varchar(100),
    primary key (accountid),
    unique index (email)
);

create table user (
	email varchar(100),
    fullname varchar(50),
    phone varchar(15),
    address varchar(200),
    primary key (email),
    index (fullname)
	);


create table order_product (
	id bigint auto_increment,
    email varchar(100),
    createdate date,
    address varchar(200),
    primary key (id)
	);
    
create table order_detail (
	id bigint auto_increment,
    orderid bigint,
    productid int,
    price double,
    quantity int,
    primary key (id)
    );
    
create table product (
	id int,
    name varchar(100),
    image varchar(100),
    price double,
    quantity int,
    createdate date,
    categoryid varchar(100),
    available boolean,
    primary key (id)
    );
    
create table category (
	id varchar(100),
    name varchar(100),
    primary key (id)
    );
    
alter table account
	add constraint fk_us_ac
    foreign key (email)
    references user (email);

alter table order_product
	add constraint fk_ac_op
	foreign key (email)
	references account(email);
    
alter table order_detail
	add constraint fk_op_od
    foreign key (orderid)
    references order_product(id),
    
    add constraint fk_pr_od
    foreign key (productid)
    references product(id);
    
alter table product
	add constraint fk_ca_pr
    foreign key (categoryid)
    references category(id);