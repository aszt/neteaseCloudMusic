package com.netease.controller;

import com.netease.dosc.UserDocs;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController implements UserDocs {

    @Autowired
    private UserService userService;

    @GetMapping("loginCellphone")
    public String loginCellphone(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        try {
            return userService.loginCellphone(phone, password, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            return userService.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("recommendSongs")
    public String recommendSongs(@CookieValue("WY_TOKEN") String token) {
        try {
            return userService.recommendSongs(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("recommendResource")
    public String recommendResource(@CookieValue("WY_TOKEN") String token) {
        try {
            return userService.recommendResource(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("userPlayList")
    public String userPlayList(@RequestParam("uid") String uid, @RequestParam(value = "limit", defaultValue = "30") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return userService.userPlayList(uid, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
