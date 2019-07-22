package com.netease.controller;

import com.netease.service.TopListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
            @ApiImplicitParam(name = "idx", value = "榜单ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "n", value = "记录数", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("top/list")
    public String topList(@RequestParam("idx") String idx, @RequestParam(value = "n", defaultValue = "10000") Integer n) {
        try {
            return topListService.topList(idx, n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "所有榜单内容摘要", notes = "调用此接口,可获取所有榜单内容摘要")
    @GetMapping("toplist/detail")
    public String toplistDetail() {
        try {
            return topListService.toplistDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
