CREATE TABLE t_book(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(100),
	`price` DECIMAL(11,2),
	`author` VARCHAR(100),
	`sales` INT,
	`stock` INT,
	`img_path` VARCHAR(200)
);