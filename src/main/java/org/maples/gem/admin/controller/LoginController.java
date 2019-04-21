package org.maples.gem.admin.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "Login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        log.info("{} {}", username, password);
        try {
            user.login(token);
            return "redirect:/index";
        }  catch (UnknownAccountException e) {
            model.addAttribute("message", "Unknown Account");
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message", "Incorrect credentials");
        }
        return "Login";
    }

    @GetMapping("/check")
    @ResponseBody
    public Object check() throws IOException, ClassNotFoundException {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();

        log.info(JSON.toJSONString(session, true));
        log.info("authentication={}", currentUser.isAuthenticated());
        log.info("something={}", currentUser.hasRole("something"));
        log.info("SystemAdministrator={}", currentUser.hasRole("SystemAdministrator"));

        return "";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
