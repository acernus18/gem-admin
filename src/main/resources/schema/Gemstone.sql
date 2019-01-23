DROP TABLE IF EXISTS `tb_gemstone`;

CREATE TABLE `tb_gemstone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gem_id` INT NOT NULL DEFAULT 0,
  `name` VARCHAR(255) NOT NULL DEFAULT '',
  `type` VARCHAR(255) NOT NULL DEFAULT '',
  `color` VARCHAR(255) NOT NULL DEFAULT '',
  `amount` INT NOT NULL DEFAULT 0,
  `weight` DOUBLE NOT NULL DEFAULT 0.0,
  `count_amount` SMALLINT(1) NOT NULL DEFAULT 0,
  `count_weight` SMALLINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_gemstone`(
  `gem_id`,
  `name`,
  `type`,
  `color`,
  `amount`,
  `weight`,
  `count_amount`,
  `count_weight`
) VALUES (1, 'Test Value', 'Test Value', 'Test Value', 0, 0.0, 0, 0)