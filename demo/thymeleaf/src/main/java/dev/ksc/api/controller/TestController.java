package dev.ksc.api.controller;

import dev.ksc.api.pojo.PjUser;
import dev.ksc.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("{name}/{pwd}")
    public ResponseEntity<PjUser> inserUser(@PathVariable String name,
                                            @PathVariable String pwd) {
        PjUser user = new PjUser();
        user.setName(name);
        user.setPassword(pwd);
        user = userService.inserUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("{userId}")
    public ResponseEntity getUser(@PathVariable("userId") Long userId) {
        PjUser pjUser = userService.getUserById(userId);
        return ResponseEntity.ok(pjUser);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity delUser(@PathVariable("userId") Long userId) {
        int result = userService.delUserById(userId);
        return ResponseEntity.ok(result);
    }


}
