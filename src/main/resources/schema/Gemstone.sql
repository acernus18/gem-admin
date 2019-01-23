DROP TABLE IF EXISTS `tb_gemstone`;

CREATE TABLE `tb_gemstone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gem_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT '',
  `type` varchar(255) NOT NULL DEFAULT '',
  `color` varchar(255) NOT NULL DEFAULT '',
  `amount` int(11) NOT NULL DEFAULT '0',
  `weight` double NOT NULL DEFAULT '0',
  `count_amount` smallint(1) NOT NULL DEFAULT '0',
  `count_weight` smallint(1) NOT NULL DEFAULT '0',
  `create_time` int(11) NOT NULL DEFAULT '0',
  `update_time` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4