CREATE TABLE IF NOT EXISTS `inventory`
(
    `id` bigint(30) NOT NULL AUTO_INCREMENT,
    `sku_code` varchar(60),
    `quantity` int(10) DEFAULT 0,
    PRIMARY KEY(`id`)
);