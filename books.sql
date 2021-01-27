DROP DATABASE IF EXISTS book;

CREATE DATABASE book;

USE book;

CREATE TABLE t_user(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(20),
	`password` VARCHAR(32),
	`email` VARCHAR(200)
	

);`book`

INSERT INTO t_user(`username`, `password`, `email`) VALUES ('admin','admin', '714332550@qq.com');

SELECT * FROM t_user;