CREATE TABLE `foame`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(100) NOT NULL COMMENT '',
  `role` VARCHAR(45) NOT NULL COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

CREATE TABLE `foame`.`categories` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

CREATE TABLE `foame`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `category_id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `price` DOUBLE NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  `in_stock` VARCHAR(1) NULL DEFAULT 'Y' COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

ALTER TABLE `foame`.`products`
DROP COLUMN `category_id`;
ALTER TABLE `foame`.`products`
ADD CONSTRAINT `category_id`
FOREIGN KEY (`id`)
REFERENCES `foame`.`categories` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `foame`.`stocks` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `quantity` INT NULL COMMENT '',
  `quantity_type` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

CREATE TABLE `foame`.`product_ingredients` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `quantity` DOUBLE NULL COMMENT '',
  `quantity_type` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `product_id`
  FOREIGN KEY (`id`)
  REFERENCES `foame`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ingredient_id`
  FOREIGN KEY (`id`)
  REFERENCES `foame`.`stocks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `foame`.`history` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `date` DATETIME NULL COMMENT '',
  `total_price` DOUBLE NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

CREATE TABLE `foame`.`order_content` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `quantity` INT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `order_id`
  FOREIGN KEY (`id`)
  REFERENCES `foame`.`history` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `prod_id`
  FOREIGN KEY (`id`)
  REFERENCES `foame`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `foame`.`products`
ADD COLUMN `category_id` INT NOT NULL AFTER `in_stock`;

ALTER TABLE `foame`.`products`
DROP FOREIGN KEY `category_id`;

ALTER TABLE `foame`.`products`
ADD INDEX `fk_category_id_idx` (`category_id` ASC);
ALTER TABLE `foame`.`products`
ADD CONSTRAINT `fk_category_id`
  FOREIGN KEY (`category_id`)
  REFERENCES `foame`.`categories` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `foame`.`product_ingredients`
DROP FOREIGN KEY `product_id`,
DROP FOREIGN KEY `ingredient_id`;
ALTER TABLE `foame`.`product_ingredients`
ADD COLUMN `product_id` INT NOT NULL AFTER `quantity_type`,
ADD COLUMN `ingredient_id` INT NOT NULL AFTER `product_id`,
ADD INDEX `fk_product_id_idx` (`product_id` ASC),
ADD INDEX `fk_ingredient_id_idx` (`ingredient_id` ASC);
ALTER TABLE `foame`.`product_ingredients`
ADD CONSTRAINT `fk_product_id`
  FOREIGN KEY (`product_id`)
  REFERENCES `foame`.`products` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_ingredient_id`
  FOREIGN KEY (`ingredient_id`)
  REFERENCES `foame`.`stocks` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `foame`.`order_content`
DROP FOREIGN KEY `prod_id`,
DROP FOREIGN KEY `order_id`;
ALTER TABLE `foame`.`order_content`
ADD COLUMN `product_id` INT NOT NULL AFTER `quantity`,
ADD COLUMN `order_id` INT NOT NULL AFTER `product_id`,
ADD INDEX `fk_prod_id_idx` (`product_id` ASC),
ADD INDEX `fk_order_id_idx` (`order_id` ASC);
ALTER TABLE `foame`.`order_content`
ADD CONSTRAINT `fk_prod_id`
  FOREIGN KEY (`product_id`)
  REFERENCES `foame`.`products` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_order_id`
  FOREIGN KEY (`order_id`)
  REFERENCES `foame`.`history` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `foame`.`order_content`
RENAME TO  `foame`.`orders` ;

ALTER TABLE `foame`.`history`
ADD COLUMN `status` VARCHAR(45) NULL AFTER `total_price`;
