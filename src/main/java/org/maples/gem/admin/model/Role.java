package org.maples.gem.admin.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_role")
public class Role {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private Integer status;

    @Column(name = "create_time")
    private Integer createTime;

    @Column(name = "update_time")
    private Integer updateTime;
}