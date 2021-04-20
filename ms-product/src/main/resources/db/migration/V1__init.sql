CREATE TABLE categories
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(45) NOT NULL,
    `discount_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `catdis_id`
        FOREIGN KEY (`discount_id`)
            REFERENCES `spring_data`.`discount`(`id`)
);

CREATE TABLE products
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(45) NOT NULL,
    `cost`        INT         NOT NULL,
    `description` VARCHAR(200),
    `created_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `discount_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `proddis_id`
        FOREIGN KEY (`discount_id`)
            REFERENCES `spring_data`.`discount` (`id`)
);

CREATE TABLE products_categories
(
    `product_id`  INT NOT NULL,
    `category_id` INT NOT NULL,
    CONSTRAINT `pcuniq` UNIQUE (product_id, category_id),
    CONSTRAINT `prod_id`
        FOREIGN KEY (`product_id`)
            REFERENCES `spring_data`.`products` (`id`),
    CONSTRAINT `cat_id`
        FOREIGN KEY (`category_id`)
            REFERENCES `spring_data`.`categories` (`id`)
);

INSERT INTO categories
VALUES (1, 'Ale', 1),
       (2, 'Lagger', 1),
       (3, 'Stout', 1),
       (4, 'Wheat', 1),
       (5, 'Pilsner', 1),
       (6, 'England', 1),
       (7, 'Belgium', 1),
       (8, 'Germany', 1);



INSERT INTO products (`id`, `name`, `cost`, `description`, `discount_id`)
VALUES (1, 'Boddingtons Pub Ale', 146, 'Alc 4.7%, volume 0.5', 1),
       (2, 'Fuller''s Frontier', 228, 'Alc 4.5%, volume 0.5', 1),
       (3, 'St. Peter’s Honey Porter', 242, 'Alc 4.5%, volume 0.5', 1),
       (4, 'Blanche De Bruxelles', 147, 'Alc 4.5%, volume 0.5', 1),
       (5, 'Silly Pils', 149, 'Alc 5.0%, volume 0.25', 1),
       (6, 'ABK Hefeweizen Anno 25', 162, 'Alc 5.3%, volume 0.5', 1),
       (7, 'Altmuller Hell', 140, 'Alc 4.9%, volume 0.5', 1),
       (8, 'Andechser Vollbier Hell', 200, 'Alc 4.8%, volume 0.5', 1),
       (9, 'Gulden Draak', 346, 'Alc 12.0%, volume 0.33', 1),
       (10, 'Franziskaner Hefe-Weissbier', 149, 'Alc 5.0%, volume 0.5', 1);



INSERT INTO products_categories (product_id, category_id)
VALUES (1, 1),
       (1, 6),
       (2, 2),
       (2, 6),
       (3, 3),
       (3, 6),
       (4, 4),
       (4, 7),
       (5, 5),
       (5, 7),
       (6, 8),
       (6, 1),
       (7, 2),
       (7, 8),
       (8, 5),
       (8, 8),
       (9, 3),
       (9, 7),
       (10, 4),
       (10, 8);

CREATE TABLE product_item
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45) NOT NULL,
    `cost`       INT         NOT NULL,
    `product_id` INT         NOT NULL,
    `storage_id` INT         NOT NULL,
    PRIMARY KEY (`id`)
);










