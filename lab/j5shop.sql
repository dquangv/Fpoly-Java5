create database java5_j5shop;

use java5_j5shop;

CREATE TABLE account (
    username VARCHAR(50) PRIMARY KEY,
    fullname nVARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    photo VARCHAR(255),
    activated BOOLEAN DEFAULT TRUE,
    admin BOOLEAN DEFAULT FALSE
);


CREATE TABLE `order` (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    createdate DATE NOT NULL,
    address VARCHAR(255) NOT NULL
);

create table category (
	id varchar(50) primary key,
    name nvarchar(100)
);