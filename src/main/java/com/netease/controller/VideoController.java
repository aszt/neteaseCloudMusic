package com.netease.controller;

import com.netease.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频模块（0-MV、1-用户上传视频）
 */
@RestController
@Api(description = "视频模块")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // 获取MV数据
    @ApiOperation(value = "获取 mv 数据", notes = " 传入 mvid，可获取对应 MV 数据,例如：5436712")
    @ApiImplicitParam(name = "mvid", value = "MV id", required = true, dataType = "String", paramType = "query")
    @GetMapping("mv/detail")
    public String mvDetail(@RequestParam("mvid") String mvid) {
        try {
            return videoService.mvDetail(mvid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取video数据
    @ApiOperation(value = "视频详情（用户上传）", notes = " 传入视频的 id，可获取视频详情,例如：89ADDE33C0AAE8EC14B99F6750DB954D")
    @ApiImplicitParam(name = "id", value = "视频 id", required = true, dataType = "String", paramType = "query")
    @GetMapping("video/detail")
    public String videoDetail(@RequestParam("id") String id) {
        try {
            return videoService.videoDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取MVurl
    @ApiOperation(value = "mv 地址", notes = " 传入 mv id,可获取 mv 播放地址")
    @ApiImplicitParam(name = "id", value = "MV id", required = true, dataType = "String", paramType = "query")
    @GetMapping("mv/url")
    public String mvUrl(@RequestParam("id") String id) {
        try {
            return videoService.mvUrl(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取videoUrl
    @ApiOperation(value = "获取视频播放地址", notes = " 传入视频 id,可获取视频播放地址,3C10B7D020D07031B595235C790737A4")
    @ApiImplicitParam(name = "id", value = "视频 id", required = true, dataType = "String", paramType = "query")
    @GetMapping("video/url")
    public String videoUrl(@RequestParam("id") String id) {
        try {
            return videoService.videoUrl(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取相关视频
    @ApiOperation(value = "相关视频", notes = " 获取相关视频")
    @ApiImplicitParam(name = "id", value = "视频 id", required = true, dataType = "String", paramType = "query")
    @GetMapping("related/allvideo")
    public String relatedAllvideo(@RequestParam("id") String id) {
        try {
            return videoService.relatedAllvideo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取MV评论
    @ApiOperation(value = "mv 评论", notes = " 传入mv id 和 limit 参数 , 可获得该 mv 的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "mv id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("comment/mv")
    public String commentMv(@RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return videoService.commentMv(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取Video评论
    @ApiOperation(value = "mv 评论", notes = " 传入视频 id 和 limit 参数 , 可获得该视频 的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "mv id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping("comment/video")
    public String commentVideo(@RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return videoService.commentVideo(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
