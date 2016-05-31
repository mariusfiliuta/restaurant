CREATE TABLE `foame`.`history` (
  `id` INT(11) NOT NULL,
  `start_date` VARCHAR(120) NULL,
  `end_date` VARCHAR(120) NULL,
  `total_price` DOUBLE NULL,
  `table_name` VARCHAR(45) NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_toUser_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `foame`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `foame`.`history`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;
