package org.maples.gem.admin.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_gemstone")
public class Gemstone {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "gem_id")
    private Integer gemId;

    private String name;

    private String type;

    private String color;

    private Integer amount;

    private Double weight;

    @Column(name = "count_amount")
    private Short countAmount;

    @Column(name = "count_weight")
    private Short countWeight;

    @Column(name = "create_time")
    private Integer createTime;

    @Column(name = "update_time")
    private Integer updateTime;
}