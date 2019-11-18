package org.maples.gem.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.maples.gem.admin.utility.ExcelUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/heath")
public class HealthController {

    @PostMapping("/loadExcel")
    public List<List<String>> loadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        return ExcelUtils.load(file.getInputStream(), 0);
    }

    @GetMapping("/session")
    public HttpSession session(HttpSession session) {
        return session;
    }
}
