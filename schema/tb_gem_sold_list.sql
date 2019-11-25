DROP TABLE IF EXISTS `tb_gem_sold_list`;

CREATE TABLE `tb_gem_sold_list`
(
    `id`              int(11)      NOT NULL AUTO_INCREMENT,
    `order_id`        varchar(128) NOT NULL,
    `sold_time`       datetime     NOT NULL,
    `gem_id`          varchar(128) NOT NULL DEFAULT '',
    `gem_name`        varchar(128) NOT NULL DEFAULT '',
    `gem_type`        varchar(128) NOT NULL DEFAULT '',
    `gem_number`      int(128)     NOT NULL,
    `gem_weight`      float        NOT NULL,
    `gem_unit_price`  float        NOT NULL,
    `gem_cost`        float                 DEFAULT NULL,
    `gem_total_price` float        NOT NULL,
    `gem_real_price`  float        NOT NULL,
    `sold_to`         varchar(128) NOT NULL DEFAULT '',
    `other`           varchar(128) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4