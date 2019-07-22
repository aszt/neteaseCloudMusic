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

    @ApiOperation(value = "歌单评论", notes = "传入音乐 id 和 limit 参数 , 可获得该歌单的所有评论 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "歌单 id（例如：2877629036）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "before", value = "分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)", required = false, dataType = "String", paramType = "query")
    })
    @GetMapping("comment/playlist")
    public String commentPlaylist(@RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset, @RequestParam(value = "before", defaultValue = "0") String before) {
        try {
            return playListService.commentPlaylist(id, limit, offset, before);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "歌单分类", notes = "调用此接口,可获取歌单分类,包含 category 信息 ")
    @GetMapping("playlist/catlist")
    public String playlistCatlist() {
        try {
            return playListService.playlistCatlist();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "歌单 ( 网友精选碟 )", notes = "调用此接口 , 可获取网友精选碟歌单 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", value = "可选值为 'new' 和 'hot', 分别对应最新和最热 , 默认为 'hot'", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cat", value = "tag, 比如 华语、欧美，默认全部", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出歌单数量 , 默认为 50", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页 ", required = false, dataType = "int", paramType = "query"),
    })
    @GetMapping("top/playlist")
    public String topPlaylist(@RequestParam(value = "order", defaultValue = "hot") String order, @RequestParam(value = "cat", defaultValue = "全部") String cat, @RequestParam(value = "limit", defaultValue = "50") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return playListService.topPlaylist(order, cat, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
