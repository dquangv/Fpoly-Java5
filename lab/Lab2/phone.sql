drop database java5_lab2_phone;

CREATE DATABASE java5_lab2_phone;

USE java5_lab2_phone;

CREATE TABLE phone (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL,
    maker ENUM('Apple', 'Samsung', 'Xiaomi') NOT NULL,
    country ENUM('USA', 'Korea', 'Vietnam') NOT NULL
);
