package dev.ksc.api.controller;

import dev.ksc.api.pojo.PjUser;
import dev.ksc.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("html")
@Controller
public class HtmlController {

    @Autowired
    private UserService userService;

    @GetMapping("allUsers")
    public String getAllUser(Model model) {
        List<PjUser> pjUsers = this.userService.selectAllUsers();
        model.addAttribute("users", pjUsers);
        return "allUsers";
    }
}
