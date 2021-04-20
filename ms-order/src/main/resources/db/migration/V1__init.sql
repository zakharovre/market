CREATE TABLE order_status
(
    `id`   INT         NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO order_status(id, name)
VALUES (1, 'New'),
       (2, 'Pending Payment'),
       (3, 'Confirmed'),
       (4, 'Delivered'),
       (5, 'Cancelled');

CREATE TABLE orders
(
    `id`        INT NOT NULL AUTO_INCREMENT,
    `user_id`   INT NOT NULL,
    `status_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `ordstat_idx` (`status_id` ASC) VISIBLE,
    CONSTRAINT `order_status_id`
        FOREIGN KEY (`status_id`)
            REFERENCES `ms_order`.`order_status` (`id`)
);

/*CREATE TABLE orders_proditems
(
    `order_id`    INT NOT NULL,
    `proditem_id` INT NOT NULL,
    CONSTRAINT `or_id`
        FOREIGN KEY (`order_id`)
            REFERENCES `spring_data`.`orders` (`id`),
    CONSTRAINT `pi_id`
        FOREIGN KEY (`proditem_id`)
            REFERENCES `spring_data`.`product_item` (`id`)
);
*/








