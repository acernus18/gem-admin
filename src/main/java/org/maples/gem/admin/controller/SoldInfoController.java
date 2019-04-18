package org.maples.gem.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.maples.gem.admin.model.GemSoldInfo;
import org.maples.gem.admin.repository.GemSoldInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sold")
public class SoldInfoController {

    @Autowired
    private GemSoldInfoMapper gemSoldInfoMapper;

    @GetMapping("/get/{clientName}")
    public List<GemSoldInfo> listSoldInfoByClientName(@PathVariable("clientName") String clientName) {
        log.info("Request for {}", clientName);
        return gemSoldInfoMapper.listGemSoldInfoBySoldTo(clientName);
    }

    @GetMapping("/getByGemID/{gemID}")
    public List<GemSoldInfo> listSoldInfoByGemID(@PathVariable("gemID") String gemID) {
        log.info("Request for gemID = {}", gemID);
        return gemSoldInfoMapper.selectGemSoldInfoByGemID(gemID);
    }
}
