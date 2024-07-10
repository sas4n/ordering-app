CREATE TABLE `orders`
(`id` bigint(20) NOT NULL AUTO_INCREMENT,
`order_refrence` varchar(50) DEFAULT NULL,
`SKU_CODE` varchar(50),
`price` decimal(19,2),
`quantity` int(12),
PRIMARY KEY(`id`));