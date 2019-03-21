package org.maples.gem.admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {

    @GetMapping("/index")
    public ModelAndView getIndexFTL() {
        return new ModelAndView("Index");
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
}
