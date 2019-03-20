package org.maples.gem.admin.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tb_gem_sold_list")
public class GemSoldInfo {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "sold_time")
    private Date soldTime;

    @Column(name = "gem_id")
    private String gemId;

    @Column(name = "gem_name")
    private String gemName;

    @Column(name = "gem_type")
    private String gemType;

    @Column(name = "gem_number")
    private Integer gemNumber;

    @Column(name = "gem_weight")
    private Float gemWeight;

    @Column(name = "gem_unit_price")
    private Float gemUnitPrice;

    @Column(name = "gem_cost")
    private Float gemCost;

    @Column(name = "gem_total_price")
    private Float gemTotalPrice;

    @Column(name = "gem_real_price")
    private Float gemRealPrice;

    @Column(name = "sold_to")
    private String soldTo;

    private String other;
}