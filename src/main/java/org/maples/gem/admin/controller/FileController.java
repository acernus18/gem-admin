package org.maples.gem.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    private File getUploadFileDir() {
        File dir = new File("uploadFileDir");
        if (!dir.exists() || !dir.isDirectory()) {
            if (!dir.mkdir()) {
                throw new RuntimeException("Create upload dir fail");
            } else {
                log.info("Make upload file directory success");
            }
        }
        return dir;
    }

    @GetMapping("/list")
    public String[] list() {
        return getUploadFileDir().list();
    }

    @GetMapping("/get")
    public void get(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
        String[] fileList = getUploadFileDir().list();

        if (fileList == null) {
            return;
        }

        for (String filename : fileList) {
            String token = Base64Utils.encodeToString(URLEncoder.encode(filename, "UTF-8").getBytes());
            if (token.equals(code)) {
                Files.copy(new File("uploadFileDir" + File.separator + filename).toPath(), response.getOutputStream());
            }
        }
    }

    @PostMapping("/delete")
    public Map<String, String> delete(@RequestParam("code") String code) throws UnsupportedEncodingException {
        String[] fileList = getUploadFileDir().list();

        if (fileList == null) {
            return null;
        }

        for (String filename : fileList) {
            String token = Base64Utils.encodeToString(URLEncoder.encode(filename, "UTF-8").getBytes());
            if (token.equals(code)) {
                if (new File("uploadFileDir" + File.separator + filename).delete()) {
                    log.info("Delete success");
                }
            }
        }

        Map<String, String> result = new HashMap<>();
        result.put("message", "success");
        return result;
    }

    @PostMapping("/upload")
    public Map<String, String> upload(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            return null;
        }
        File tempDir = getUploadFileDir();
        File destination = new File(tempDir.getAbsolutePath() + File.separator +  file.getOriginalFilename());
        try {
            file.transferTo(destination);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Saving file fail");
        }

        Map<String, String> result = new HashMap<>();
        result.put("message", "success");
        return result;
    }
}
