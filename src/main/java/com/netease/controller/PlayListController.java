package com.netease.controller;

import com.netease.dosc.PlayListDocs;
import com.netease.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 歌单
 */
@RestController
public class PlayListController implements PlayListDocs {

    @Autowired
    private PlayListService playListService;


    @GetMapping("personalized")
    public String personalized(@RequestParam(value = "limit", defaultValue = "30") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return playListService.personalized(limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("playlist/detail")
    public String playlistDetail(@RequestParam("id") String id, @RequestParam(value = "s", defaultValue = "8") Integer s) {
        try {
            return playListService.playlistDetail(id, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("comment/playlist")
    public String commentPlaylist(
            @RequestParam("id") String id,
            @RequestParam(value = "limit", defaultValue = "20") Integer limit,
            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "before", defaultValue = "0") String before) {
        try {
            return playListService.commentPlaylist(id, limit, offset, before);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("playlist/catlist")
    public String playlistCatlist() {
        try {
            return playListService.playlistCatlist();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("top/playlist")
    public String topPlaylist(
            @RequestParam(value = "order", defaultValue = "hot") String order,
            @RequestParam(value = "cat", defaultValue = "全部") String cat,
            @RequestParam(value = "limit", defaultValue = "50") Integer limit,
            @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return playListService.topPlaylist(order, cat, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
