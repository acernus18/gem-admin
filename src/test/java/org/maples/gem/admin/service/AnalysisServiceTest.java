package org.maples.gem.admin.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.maples.gem.admin.model.GemSoldInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnalysisServiceTest {

    @Autowired
    private AnalysisService analysisService;

    @Test
    public void test() {
        List<GemSoldInfo> result = analysisService.queryInfoList("select * from tb_gem_sold_list where id > 12000 limit 10");
        System.out.println(result);
    }
}
