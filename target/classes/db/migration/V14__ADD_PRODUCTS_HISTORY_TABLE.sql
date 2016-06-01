ALTER TABLE `foame`.`products`
ADD COLUMN `status` VARCHAR(45) NULL DEFAULT 'active' AFTER `url_to_image`;

CREATE TABLE `foame`.`historyproduct` (
  `id` INT(11) NOT NULL,
  `quantity` INT(11) NULL,
  `product_id` INT(11) NOT NULL,
  `history_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_id_idx` (`product_id` ASC),
  INDEX `fk_history_id_idx` (`history_id` ASC),
  CONSTRAINT `fk_Hproduct_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `foame`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_history_id`
    FOREIGN KEY (`history_id`)
    REFERENCES `foame`.`history` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
