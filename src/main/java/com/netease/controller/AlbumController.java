package com.netease.controller;

import com.netease.dosc.AlbumDocs;
import com.netease.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 专辑
 */
@RestController
public class AlbumController implements AlbumDocs {

    @Autowired
    private AlbumService albumService;

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
