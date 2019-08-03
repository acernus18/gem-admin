package org.maples.gem.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.maples.gem.admin.model.GemSoldInfo;
import org.maples.gem.admin.repository.GemSoldInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class RouteController {

    @Autowired
    private GemSoldInfoMapper gemSoldInfoMapper;

    private boolean isServerOnline() {
        boolean result;
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("lisimin16.eicp.net", 35890), 1000);
            result = socket.isConnected();
            socket.close();
        } catch (IOException e) {
            result = false;
        }
        return result;
    }

    @GetMapping("/soldList")
    public ModelAndView getSoldListFTL(Integer flag, String value) {

        ModelAndView view = new ModelAndView("SoldList");
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

        view.addObject("tableList", list);
        return view;
    }

    @GetMapping("/code")
    public ModelAndView getCodeFTL() {
        return new ModelAndView("Code");
    }

    @GetMapping("/order")
    public ModelAndView getOrderFTL() {
        return new ModelAndView("Order");
    }

    @GetMapping("/server/check")
    public ModelAndView check() {
        ModelAndView view = new ModelAndView("Server");
        view.addObject("isOnline", String.valueOf(isServerOnline()));
        return view;
    }
}
