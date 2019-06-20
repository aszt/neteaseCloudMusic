package com.netease.controller;

import com.netease.service.TopListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 榜单模块
 */
@RestController
@Api(description = "排行榜模块")
public class TopListController {

    @Autowired
    private TopListService topListService;

    @ApiOperation(value = "音乐排行榜", notes = "根据ID获取不同音乐榜单，例如：3779629-新歌榜、19723756-飙升榜等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "榜单ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "n", value = "记录数", required = false, dataType = "int", paramType = "query")
    })
    @PostMapping("topList")
    public String topList(@RequestParam("id") String id, @RequestParam(value = "n", defaultValue = "10") Integer n) {
        try {
            String list = topListService.topList(id, n);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
