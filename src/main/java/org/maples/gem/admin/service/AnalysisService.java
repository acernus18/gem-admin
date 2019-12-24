package org.maples.gem.admin.service;

import lombok.extern.slf4j.Slf4j;
import org.maples.gem.admin.model.GemSoldInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AnalysisService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<GemSoldInfo> queryInfoList(String statement) {
        return jdbcTemplate.query("select * from tb_gem_sold_list where " + statement, (resultSet, i) -> {
            GemSoldInfo data = new GemSoldInfo();

            data.setGemId(resultSet.getString("gem_id"));
            data.setGemName(resultSet.getString("gem_name"));
            data.setGemNumber(resultSet.getInt("gem_number"));
            data.setGemWeight(resultSet.getFloat("gem_weight"));
            data.setGemCost(resultSet.getFloat("gem_cost"));
            data.setGemUnitPrice(resultSet.getFloat("gem_unit_price"));
            data.setGemTotalPrice(resultSet.getFloat("gem_total_price"));
            data.setSoldTo(resultSet.getString("sold_to"));
            data.setSoldTime(resultSet.getDate("sold_time"));

            return data;
        });
    }

    public List<Map<String, Integer>> query() {
        return null;
    }
}
