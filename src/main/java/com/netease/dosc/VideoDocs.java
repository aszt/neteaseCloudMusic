package com.netease.dosc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "视频模块", description = "视频相关的操作")
public interface VideoDocs {

    @ApiOperation(value = "获取 mv 数据", notes = " 传入 mvid，可获取对应 MV 数据,例如：5436712")
    @ApiImplicitParam(name = "mvid", value = "MV id", required = true, dataType = "String", paramType = "query")
    String mvDetail(String mvid);

    @ApiOperation(value = "视频详情（用户上传）", notes = " 传入视频的 id，可获取视频详情,例如：89ADDE33C0AAE8EC14B99F6750DB954D")
    @ApiImplicitParam(name = "id", value = "视频 id", required = true, dataType = "String", paramType = "query")
    String videoDetail(String id);

    @ApiOperation(value = "mv 地址", notes = " 传入 mv id,可获取 mv 播放地址")
    @ApiImplicitParam(name = "id", value = "MV id", required = true, dataType = "String", paramType = "query")
    String mvUrl(String id);

    @ApiOperation(value = "获取视频播放地址", notes = " 传入视频 id,可获取视频播放地址,3C10B7D020D07031B595235C790737A4")
    @ApiImplicitParam(name = "id", value = "视频 id", required = true, dataType = "String", paramType = "query")
    String videoUrl(String id);

    @ApiOperation(value = "相关视频", notes = " 获取相关视频")
    @ApiImplicitParam(name = "id", value = "视频 id", required = true, dataType = "String", paramType = "query")
    String relatedAllvideo(String id);

    @ApiOperation(value = "mv 评论", notes = " 传入mv id 和 limit 参数 , 可获得该 mv 的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "mv id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    String commentMv(String id, Integer limit, Integer offset);

    @ApiOperation(value = "mv 评论", notes = " 传入视频 id 和 limit 参数 , 可获得该视频 的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "mv id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    String commentVideo(String id, Integer limit, Integer offset);
}
