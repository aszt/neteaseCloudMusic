package com.netease.controller;

import com.netease.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共数据
 */
@RestController
@Api(description = "公共模块")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "获取音乐Url", notes = " 传入的音乐 id( 可多个 , 用逗号隔开 ), 可以获取对应的音乐的 url，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "音乐 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "br", value = "码率,默认设置了 999000 即最大码率,如果要 320k 则可设置为 320000,其他类推", required = false, dataType = "int", paramType = "query")
    })
    @PostMapping("songUrl")
    public String songUrl(@RequestParam("ids") String ids, @RequestParam(value = "br", defaultValue = "999000") Integer br) {
        try {
            return commonService.songUrl(ids, br);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "获取歌词", notes = " 传入音乐 id 可获得对应音乐的歌词，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query")
    @PostMapping("lyric")
    public String lyric(@RequestParam("id") String id) {
        try {
            return commonService.lyric(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "获取歌曲详情", notes = " 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParam(name = "ids", value = "音乐 id", required = true, dataType = "String", paramType = "query")
    @PostMapping("songDetail")
    public String songDetail(@RequestParam("ids") String ids) {
        try {
            return commonService.songDetail(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "获取专辑内容", notes = " 传入专辑 id, 可获得专辑内容,例如：79130968-孤身")
    @ApiImplicitParam(name = "id", value = "专辑 id", required = true, dataType = "String", paramType = "query")
    @PostMapping("album")
    public String album(@RequestParam("id") String id) {
        try {
            return commonService.album(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "歌曲评论", notes = " 传入音乐 id 和 limit 参数 , 可获得该音乐的15条热门评论及limit条最新评论,例如：1365393542-孤身")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    @PostMapping("commentMusic")
    public String commentMusic(@RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return commonService.commentMusic(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "热门评论", notes = "0-歌曲、1-mv、2-歌单、3-专辑、4-电台、5-视频，其它参数同歌曲评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20+1", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    @PostMapping("commentHot")
    public String commentHot(@RequestParam("type") Integer type, @RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return commonService.commentHot(type, id, limit, offset);
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
    @PostMapping("search")
    public String search(@RequestParam("keywords") String keywords, @RequestParam(value = "type", defaultValue = "1") Integer type, @RequestParam(value = "limit", defaultValue = "30") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return commonService.search(keywords, type, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
