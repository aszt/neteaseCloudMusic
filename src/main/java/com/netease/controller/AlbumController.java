package com.netease.controller;

import com.netease.service.AlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 专辑
 */
@RestController
@Api(description = "专辑模块")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @ApiOperation(value = "最新专辑", notes = "获取云音乐首页新碟上架数据")
    @GetMapping("album/newest")
    public String newAlbum() {
        try {
            return albumService.newAlbum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
