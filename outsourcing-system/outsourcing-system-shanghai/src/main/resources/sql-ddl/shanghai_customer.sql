CREATE TABLE `shanghai_customer_staff`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `nickname` VARCHAR(45) NOT NULL COMMENT 'NICK NAME',
    `avatar` VARCHAR(255) DEFAULT NULL COMMENT 'Head',
    `phone` VARCHAR(11) DEFAULT NULL COMMENT 'phone number',
    `gender` VARCHAR(32) NOT NULL COMMENT 'MALE, FEMALE',
    `good_at` VARCHAR(255) DEFAULT NULL COMMENT 'COME ON',
    `remark` VARCHAR(255) DEFAULT NULL COMMENT 'remark',
    `is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT "1=deleted, 0=not deleted",
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'creation time',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='ShangHai Outsourcing People List';