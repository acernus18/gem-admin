package org.maples.gem.admin.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Data
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String principal;

    private String credential;

    private Integer status;

    @Column(name = "create_time")
    private Integer createTime;

    @Column(name = "update_time")
    private Integer updateTime;

    @Column(name = "last_login_time")
    private Integer lastLoginTime;
}