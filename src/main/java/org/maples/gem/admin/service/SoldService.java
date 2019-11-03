package org.maples.gem.admin.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.maples.gem.admin.model.GemSoldInfo;
import org.maples.gem.admin.repository.GemSoldInfoMapper;
import org.maples.gem.admin.utility.ExcelUtils;
import org.maples.gem.admin.utility.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

@Slf4j
@Service
public class SoldService {

    @Autowired
    private GemSoldInfoMapper gemSoldInfoMapper;

    @Transactional
    public void importSoldInfoList(InputStream inputStream, int flag) throws ParseException {
        List<List<String>> info = ExcelUtils.load(inputStream, 0);
        info.remove(0);
        for (List<String> line : info) {
            GemSoldInfo soldInfo = new GemSoldInfo();
            soldInfo.setSoldTime(DateUtils.parseDate(line.get(0), "MM/dd/yy"));
            soldInfo.setOrderId(line.get(1));
            soldInfo.setSoldTo(line.get(2));
            soldInfo.setGemId(line.get(3));
            soldInfo.setGemName(line.get(4));
            soldInfo.setGemType(line.get(5));
            soldInfo.setGemNumber(Integer.parseInt(line.get(6)));
            soldInfo.setGemWeight(Float.parseFloat(line.get(7)));
            soldInfo.setGemUnitPrice(Float.parseFloat(line.get(8)));
            soldInfo.setGemTotalPrice(Float.parseFloat(line.get(9)));
            soldInfo.setGemRealPrice(Float.parseFloat(line.get(10)));

            String cost = ParseUtils.parse(soldInfo.getGemName()).get("cost");
            if (cost != null) {
                soldInfo.setGemCost(Float.parseFloat(cost));
            }

            if (flag == 0) {
                log.info(JSON.toJSONString(soldInfo));
            } else {
                gemSoldInfoMapper.insert(soldInfo);
            }
        }

        if (flag == 1) {
            throw new RuntimeException("Now rollback");
        }
    }

}
