DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user`
(
    `user_id`        INT          NOT NULL PRIMARY KEY,
    `user_name`      VARCHAR(255) NOT NULL,
    `user_password`  VARCHAR(255) NOT NULL,
    `user_privilege` INT          NOT NULL,
    `last_login_time` INT NOT NULL
);