package com.netease.controller;

import com.netease.service.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 音乐模块
 */
@RestController
@Api(description = "音乐模块")
public class SongController {

    @Autowired
    private SongService songService;

    // 获取音乐详情
    @ApiOperation(value = "获取歌曲详情", notes = " 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParam(name = "ids", value = "音乐 id", required = true, dataType = "String", paramType = "query")
    @GetMapping("song/detail")
    public String songDetail(@RequestParam("ids") String ids) {
        try {
            return songService.songDetail(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取音乐url
    @ApiOperation(value = "获取音乐Url", notes = " 传入的音乐 id( 可多个 , 用逗号隔开 ), 可以获取对应的音乐的 url，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "br", value = "码率,默认设置了 999000 即最大码率,如果要 320k 则可设置为 320000,其他类推", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("song/url")
    public String songUrl(@RequestParam("id") String id, @RequestParam(value = "br", defaultValue = "999000") Integer br) {
        try {
            return songService.songUrl(id, br);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取歌词
    @ApiOperation(value = "获取歌词", notes = " 传入音乐 id 可获得对应音乐的歌词，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query")
    @GetMapping("lyric")
    public String lyric(@RequestParam("id") String id) {
        try {
            return songService.lyric(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取评论
    @ApiOperation(value = "歌曲评论", notes = " 传入音乐 id 和 limit 参数 , 可获得该音乐的15条热门评论及limit条最新评论,例如：1365393542-孤身")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("comment/music")
    public String commentMusic(@RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return songService.commentMusic(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
