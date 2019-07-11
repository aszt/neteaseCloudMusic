package com.netease.controller;

import com.netease.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搜索模块
 */
@RestController
@Api(description = "搜索模块")
public class SearchController {

    @Autowired
    private SearchService searchService;

    // 搜索建议
    @ApiOperation(value = "搜索建议", notes = "搜索关键词可获得搜索建议 , 搜索结果同时包含单曲 , 歌手 , 歌单 ,mv 信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keywords", value = "关键词", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "mobile or web,默认 'mobile' 返回移动端数据", required = false, dataType = "String", paramType = "query"),
    })
    @GetMapping("search/suggest")
    public String searchSuggest(@RequestParam("keywords") String keywords, @RequestParam(value = "type", defaultValue = "mobile") String type) {
        try {
            return searchService.searchSuggest(keywords, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 热搜列表（简略）
    @ApiOperation(value = "热搜列表(简略)", notes = "调用此接口,可获取热门搜索列表")
    @GetMapping("search/hot")
    public String searchHot() {
        try {
            return searchService.searchHot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 热搜列表（详细）
    @ApiOperation(value = "热搜列表(详细)", notes = "调用此接口,可获取热门搜索列表")
    @GetMapping("search/hot/detail")
    public String searchHotDetail() {
        try {
            return searchService.searchHotDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "搜索", notes = "传入搜索关键词可以搜索该音乐 / 专辑 / 歌手 / 歌单 / 用户 , 关键词可以多个 , 以空格隔开 , 如：周杰伦 搁浅")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keywords", value = "关键词", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "搜索类型：默认为单曲，1: 单曲、100: 歌手、10: 专辑、1014: 视频、1000: 歌单、1006: 歌词、1009: 主播电台、1002: 用户", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "返回数量 , 默认为 30", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页，如 :( 页数 -1)*30， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("search")
    public String search(@RequestParam("keywords") String keywords, @RequestParam(value = "type", defaultValue = "1") Integer type, @RequestParam(value = "limit", defaultValue = "30") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return searchService.search(keywords, type, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
