package com.netease.dosc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "音乐模块", description = "歌曲相关")
public interface SongDocs {

    @ApiOperation(value = "获取歌曲详情", notes = " 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParam(name = "ids", value = "音乐 id", required = true, dataType = "String", paramType = "query")
    String songDetail(String ids);

    @ApiOperation(value = "获取音乐Url", notes = " 传入的音乐 id( 可多个 , 用逗号隔开 ), 可以获取对应的音乐的 url，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "br", value = "码率,默认设置了 999000 即最大码率,如果要 320k 则可设置为 320000,其他类推", required = false, dataType = "int", paramType = "query")
    })
    String songUrl(String id, Integer br);

    @ApiOperation(value = "获取歌词", notes = " 传入音乐 id 可获得对应音乐的歌词，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query")
    String lyric(String id);

    @ApiOperation(value = "歌曲评论", notes = " 传入音乐 id 和 limit 参数 , 可获得该音乐的15条热门评论及limit条最新评论,例如：1365393542-孤身")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    String commentMusic(String id, Integer limit, Integer offset);

    @ApiOperation(value = "推荐新音乐", notes = " 用此接口 , 可获取推荐新音乐")
    String personalizedNewsong();

    @ApiOperation(value = "新歌速递", notes = " 用此接口 , 可获取新歌速递")
    @ApiImplicitParam(name = "type", value = "地区类型 id,(全部:0、华语:7、欧美:96、日本:8、韩国:16)", required = false, dataType = "int", paramType = "query")
    String topSong(Integer type);
}
