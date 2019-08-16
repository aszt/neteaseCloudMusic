package com.netease.dosc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "排行榜模块", description = "排行榜相关")
public interface TopListDocs {

    @ApiOperation(value = "音乐排行榜", notes = "根据ID获取不同音乐榜单，例如：3779629-新歌榜、19723756-飙升榜等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idx", value = "榜单ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "n", value = "记录数", required = false, dataType = "int", paramType = "query")
    })
    String topList(String idx, Integer n);


    @ApiOperation(value = "所有榜单内容摘要", notes = "调用此接口,可获取所有榜单内容摘要")
    String toplistDetail();
}
