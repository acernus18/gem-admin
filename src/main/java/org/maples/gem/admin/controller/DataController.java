package org.maples.gem.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.maples.gem.admin.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private BuyService service;

    @GetMapping("/search")
    public Object search(HttpServletRequest request) {

        return null;
    }

    @PostMapping("/template")
    public Object getTemplate(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=template.xlsx");
        OutputStream outputStream = response.getOutputStream();
        service.getTemplate(outputStream);
        return null;
    }

    @PostMapping("/generateBuyOrder")
    public Object generateBuyOrder(@RequestParam("file") MultipartFile file,
                                   HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=output.xlsx");

        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = response.getOutputStream();
        service.generateBuyList(inputStream, outputStream);
        return null;
    }
}
