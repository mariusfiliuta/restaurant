ALTER TABLE `foame`.`products`
CHANGE COLUMN `description` `description` VARCHAR(250) NULL DEFAULT NULL COMMENT '' ;

ALTER TABLE `foame`.`products`
CHANGE COLUMN `url_to_image` `url_to_image` VARCHAR(250) NULL DEFAULT NULL COMMENT '' ;

INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (1,'Pizza Margherita',13,'sos rosii, mozzarella, busuioc.','N',1,'http://www.brassio.ro/lib/foto/63-470a80da1fd5fcfa9f604409ec0680d4.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (2,'Pizza Funghi',14,'sos rosii, mozzarella, ciuperci','N',1,'http://www.brassio.ro/lib/foto/64-0c1dd3c4b40fc1e621e647b3fe34b897.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (3,'Pizza Romana',17,'sos rosii, mozzarella, salam, ciuperci, ardei gras','N',1,'http://www.brassio.ro/lib/foto/68-628ca06a9240ad78e697c4ab1f97bf45.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (4,'Penne Arabiata',14,'sos de rosii,masline,ardei gras,oregano,peperoncino','N',4,'http://www.pomodoropizza.ro/73-large_default/spaghetti-penne-arabiata.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (5,'Penne Milaneze',16,'penne pasta,sunca,ciuperci,sos special pomodoro, mozzarela','N',4,'http://www.pomodoropizza.ro/70-large_default/spaghetti-penne-milaneze.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (6,'Spaghetti Carbonara',16,'pasta,bacon,gran cucina,ou,parmezan','N',4,'http://www.pomodoropizza.ro/69-large_default/spaghetti-penne-carbonara.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (7,'Coca-cola',4,'Cola','N',2,'http://www.marijuanapackaging.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/c/o/coca-cola-stash-can-12-oz-1_1.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (8,'Nestea',4,'Nestea','N',2,'https://dworkins.com/media/catalog/product/cache/1/image/800x800/9df78eab33525d08d6e5fb8d27136e95/n/e/nestea_355_1_1_1_1_2_1_1_1_1_1.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (9,'Timisoreana',4,'Timisoreana','N',2,'http://www.carrefour-online.ro/-/media/Images/Products/0/3/7/N1_5942016300260.png?w=460&h=460&q=90&bc=white');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (10,'Ciocolata calda',6,'Calda ciocolata','N',2,'http://www.bizcafeshop.ro/media/catalog/product/cache/1/thumbnail/5e06319eda06f020e43594a9c230972d/h/o/hot-chocolate.jpg');
INSERT INTO `products` (`id`,`name`,`price`,`description`,`in_stock`,`category_id`,`url_to_image`) VALUES (11,'Alune',7,'-','N',3,'http://archive.boston.com/lifestyle/health/blog/nutrition/peanuts.jpg');

ALTER TABLE `foame`.`orders`
CHANGE COLUMN `date` `date` VARCHAR(120) NULL DEFAULT NULL COMMENT '' ;

ALTER TABLE `foame`.`orders`
ADD COLUMN `name` VARCHAR(45) NULL COMMENT '' AFTER `user_id`;
