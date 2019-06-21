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

@RestController
@Api(description = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "每日歌曲推荐（待改）", notes = "根据你的音乐口味生成，每天6:00更新")
    @ApiImplicitParam(name = "uid", value = "用户 id", required = true, dataType = "String", paramType = "query")
    @PostMapping("recommendSongs")
    public String recommendSongs(@RequestParam("uid") String uid) {
        try {
            String list = userService.recommendSongs(uid);
            return list;
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
            String list = userService.userPlayList(uid, limit, offset);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
