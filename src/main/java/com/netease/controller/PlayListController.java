package com.netease.controller;

import com.netease.service.PlayListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 歌单
 */
@RestController
@Api(description = "歌单模块")
public class PlayListController {

    @Autowired
    private PlayListService playListService;

    @ApiOperation(value = "推荐歌单", notes = "获取推荐歌单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "limit", value = "数量 , 默认为 30", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0(该参数有问题)", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("personalized")
    public String personalized(@RequestParam(value = "limit", defaultValue = "30") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return playListService.personalized(limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "获取歌单详情", notes = "传入歌单 id, 可 以获取对应歌单内的所有的音乐信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "歌单 id（例如：2877629036）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "s", value = "歌单最近的 s 个收藏者， 默认8", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("playlist/detail")
    public String playlistDetail(@RequestParam("id") String id, @RequestParam(value = "s", defaultValue = "8") Integer s) {
        try {
            return playListService.playlistDetail(id, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
