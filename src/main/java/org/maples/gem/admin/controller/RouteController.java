package org.maples.gem.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class RouteController {

    @GetMapping("/soldList")
    public String soldList() {
        return "soldList.html";
    }

    @GetMapping("/server")
    public String checkServer() {
        return "server.html";
    }

    @GetMapping("/generate")
    public String generate() {
        return "generate.html";
    }

    @GetMapping("order")
    public String order() {
        return "order.html";
    }
}
