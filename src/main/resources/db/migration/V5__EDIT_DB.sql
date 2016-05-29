ALTER TABLE `foame`.`orders`
RENAME TO  `foame`.`orderproduct` ;
ALTER TABLE `foame`.`history`
RENAME TO  `foame`.`orders` ;
ALTER TABLE `foame`.`orders`
ADD COLUMN `user_id` INT NOT NULL AFTER `status`,
ADD INDEX `fk_user_id_idx` (`user_id` ASC);
ALTER TABLE `foame`.`orders`
ADD CONSTRAINT `fk_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `foame`.`users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
