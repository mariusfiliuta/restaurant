CREATE TABLE `foame`.`tables` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL,
  `nr_seats` INT(11) NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `foame`.`tables`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 1', '2');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 2', '2');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 3 ', '2');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 4', '2');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 5', '4');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 6', '4');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 7', '4');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 8', '4');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 9', '6');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 10', '6');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 11', '6');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 12', '6');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 13', '10');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 14', '10');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 15', '10');
INSERT INTO `foame`.`tables` (`name`, `nr_seats`) VALUES ('table 16', '10');
