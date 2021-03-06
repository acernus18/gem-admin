package org.maples.gem.admin.service;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SoldService {

    @Autowired
    private GemSoldInfoMapper gemSoldInfoMapper;

    @Transactional
    public void importSoldInfoList(InputStream inputStream) throws ParseException {
        List<List<String>> info = ExcelUtils.load(inputStream, 0);

        int counter = 0;

        info.remove(0); // Remove tag

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

            Integer number = gemSoldInfoMapper.selectNumberByVerifiedInfo(
                    soldInfo.getGemName(),
                    soldInfo.getGemWeight(),
                    soldInfo.getGemRealPrice());

            if (number != null && number == 0) {
                log.info("Sold record {} Not exist", soldInfo.getOrderId());
                gemSoldInfoMapper.insert(soldInfo);
            } else {
                counter++;
                log.warn("Sold record {} has existed", soldInfo.getOrderId());
            }
        }

        log.warn("Sold record existed count {}", counter);
    }

    public List<Map<String, String>> getSoldList(Integer flag, String value) {
        List<Map<String, String>> list = new ArrayList<>();
        List<GemSoldInfo> queryList = new ArrayList<>();
        if (flag != null) {
            switch (flag) {
                case 0:
                    queryList = gemSoldInfoMapper.listGemSoldInfoBySoldTo(value.trim());
                    break;
                case 1:
                    queryList = gemSoldInfoMapper.selectGemSoldInfoByGemID(value.trim());
                    break;
            }
        }

        queryList.forEach(x -> {
            Map<String, String> info = new HashMap<>();

            info.put("id", x.getGemId());
            info.put("name", x.getGemName());
            info.put("client", x.getSoldTo());
            info.put("weight", String.valueOf(x.getGemWeight()));
            info.put("unitPrice", String.valueOf(x.getGemUnitPrice()));
            info.put("soldTime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(x.getSoldTime()));

            list.add(info);
        });
        return list;
    }

}
