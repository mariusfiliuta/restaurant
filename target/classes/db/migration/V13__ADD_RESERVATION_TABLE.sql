CREATE TABLE `foame`.`reservations` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `start_date` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `table_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_table_id_idx` (`table_id` ASC),
  CONSTRAINT `fk_table_id`
    FOREIGN KEY (`table_id`)
    REFERENCES `foame`.`tables` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `foame`.`stocks`
CHANGE COLUMN `quantity` `quantity` DOUBLE NULL DEFAULT NULL ;

ALTER TABLE `foame`.`tables`
ADD COLUMN `status` VARCHAR(45) NULL DEFAULT 'liber' AFTER `nr_seats`;

