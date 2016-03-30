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
