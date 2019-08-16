package com.netease.dosc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "歌单模块", description = "歌单相关")
public interface PlayListDocs {

    @ApiOperation(value = "推荐歌单", notes = "获取推荐歌单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "limit", value = "数量 , 默认为 30", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0(该参数有问题)", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("personalized")
    String personalized(Integer limit, Integer offset);

    @ApiOperation(value = "获取歌单详情", notes = "传入歌单 id, 可 以获取对应歌单内的所有的音乐信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "歌单 id（例如：2877629036）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "s", value = "歌单最近的 s 个收藏者， 默认8", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("playlist/detail")
    String playlistDetail(String id, Integer s);

    @ApiOperation(value = "歌单评论", notes = "传入音乐 id 和 limit 参数 , 可获得该歌单的所有评论 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "歌单 id（例如：2877629036）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "before", value = "分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)", required = false, dataType = "String", paramType = "query")
    })
    @GetMapping("comment/playlist")
    String commentPlaylist(String id, Integer limit, Integer offset, String before);

    @ApiOperation(value = "歌单分类", notes = "调用此接口,可获取歌单分类,包含 category 信息 ")
    @GetMapping("playlist/catlist")
    String playlistCatlist();

    @ApiOperation(value = "歌单 ( 网友精选碟 )", notes = "调用此接口 , 可获取网友精选碟歌单 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", value = "可选值为 'new' 和 'hot', 分别对应最新和最热 , 默认为 'hot'", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cat", value = "tag, 比如 华语、欧美，默认全部", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出歌单数量 , 默认为 50", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页 ", required = false, dataType = "int", paramType = "query"),
    })
    @GetMapping("top/playlist")
    String topPlaylist(String order, String cat, Integer limit, Integer offset);
}
