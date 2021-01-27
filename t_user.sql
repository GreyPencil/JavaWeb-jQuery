`book``t_book``t_user``t_order``t_user``t_order``t_order`USE book;

CREATE TABLE t_order(
	`order_id` VARCHAR(50) PRIMARY KEY,
	`create_time` DATETIME,
	`price` DECIMAL(11,2),
	`status` INT,
	`user_id` INT,
	FOREIGN KEY(`user_id`) REFERENCES t_user(`id`)
);
CREATE TABLE t_order_item(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(100),
	`count` INT,
	`price` DECIMAL(11,2),
	`total_price` DECIMAL(11,2),`order_id` VARCHAR(50),
	FOREIGN KEY(`order_id`) REFERENCES t_order(`order_id`)
);

SELECT * FROM t_order;
SELECT * FROM t_order_item;

INSERT INTO t_user VALUES(NULL, aaaaa, aaaaa, aaaa@qq.com`t_book``t_book``test``user_table`);