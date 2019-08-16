package com.netease.dosc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "用户模块", description = "登录或与用户相关的操作")
public interface UserDocs {

    @ApiOperation(value = "手机登录（有高频IP限制）", notes = "用于登录网易云音乐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    String loginCellphone(String phone, String password, HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "邮箱登录（Cookie有校验，待解决）", notes = "用于登录网易云音乐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    String login(String email, String password);

    @ApiOperation(value = "每日歌曲推荐( 需要登录 )", notes = "根据你的音乐口味生成，每天6:00更新")
    @ApiImplicitParam(name = "token", value = "不用管", required = false, dataType = "String", paramType = "query")
    @GetMapping("recommendSongs")
    String recommendSongs(String token);

    @ApiOperation(value = "每日推荐歌单( 需要登录 )", notes = "可获得每日推荐歌单")
    @ApiImplicitParam(name = "token", value = "不用管", required = false, dataType = "String", paramType = "query")
    String recommendResource(String token);

    @ApiOperation(value = "获取用户歌单", notes = "登陆后调用此接口 , 传入用户 id, 可以获取用户歌单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出数量 , 默认为 30", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    String userPlayList(String uid, Integer limit, Integer offset);
}
