package com.netease.dosc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "公共模块", description = "公共数据获取")
public interface CommonDocs {

    @ApiOperation(value = "banner", notes = " 获取 banner( 轮播图 ) 数据")
    @ApiImplicitParam(name = "type", value = "资源类型,默认为 0（0:pc、1:android、2:iphone、3:ipad）", required = false, dataType = "int", paramType = "query")
    String banner(Integer type);

    @ApiOperation(value = "获取专辑内容", notes = " 传入专辑 id, 可获得专辑内容,例如：79130968-孤身")
    @ApiImplicitParam(name = "id", value = "专辑 id", required = true, dataType = "String", paramType = "query")
    String album(String id);

    @ApiOperation(value = "热门评论", notes = "0-歌曲、1-mv、2-歌单、3-专辑、4-电台、5-视频，其它参数同歌曲评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "取出评论数量 , 默认为 20+1", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "offset", value = "偏移数量 , 用于分页， 默认为 0", required = false, dataType = "int", paramType = "query")
    })
    String commentHot(Integer type, String id, Integer limit, Integer offset);
}
