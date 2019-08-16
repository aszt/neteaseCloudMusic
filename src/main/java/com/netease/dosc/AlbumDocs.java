package com.netease.dosc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "专辑模块", description = "专辑相关")
public interface AlbumDocs {

    @ApiOperation(value = "最新专辑", notes = "获取云音乐首页新碟上架数据")
    String newAlbum();
}
