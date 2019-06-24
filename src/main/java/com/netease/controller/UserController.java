package com.netease.controller;

import com.netease.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(description = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "手机登录（有高频IP限制）", notes = "用于登录网易云音乐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("loginCellphone")
    public String loginCellphone(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        try {
            return userService.loginCellphone(phone, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "邮箱登录（Cookie有校验，待解决）", notes = "用于登录网易云音乐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            return userService.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "每日歌曲推荐( 需要登录 )", notes = "根据你的音乐口味生成，每天6:00更新")
    @ApiImplicitParam(name = "cookie", value = "登录时返回的cookie信息(巨坑，顺序不能变)", required = true, dataType = "String", paramType = "query")
    @PostMapping("recommendSongs")
    public String recommendSongs(@RequestParam("cookie") String cookie) {
        try {
            return userService.recommendSongs(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "每日推荐歌单( 需要登录 )", notes = "可获得每日推荐歌单")
    @ApiImplicitParam(name = "cookie", value = "登录时返回的cookie信息(巨坑，顺序不能变)", required = true, dataType = "String", paramType = "query")
    @PostMapping("recommendResource")
    public String recommendResource(@RequestParam("cookie") String cookie) {
        try {
            return userService.recommendResource(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "获取用户歌单", notes = "登陆后调用此接口 , 传入用户 id, 可以获取用户歌单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出数量 , 默认为 30", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    @PostMapping("userPlayList")
    public String userPlayList(@RequestParam("uid") String uid, @RequestParam(value = "limit", defaultValue = "30") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return userService.userPlayList(uid, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
