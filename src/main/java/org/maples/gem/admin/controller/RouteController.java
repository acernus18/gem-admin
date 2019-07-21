package org.maples.gem.admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Controller
public class RouteController {

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

    @GetMapping("/index")
    public ModelAndView getIndexFTL() {
        ModelAndView modelAndView = new ModelAndView("Index");
        modelAndView.addObject("test", "123");
        return modelAndView;
    }

    @GetMapping("/purchase")
    public ModelAndView getPurchaseFTL() {
        return new ModelAndView("Purchase");
    }

    @GetMapping("/soldList")
    public ModelAndView getSoldListFTL() {
        return new ModelAndView("SoldList");
    }

    @ResponseBody
    @GetMapping("/health")
    public JSONObject getHealthStatus() {
        return new JSONObject(true);
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
