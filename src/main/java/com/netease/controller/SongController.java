package com.netease.controller;

import com.netease.dosc.SongDocs;
import com.netease.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 音乐模块
 */
@RestController
public class SongController implements SongDocs {

    @Autowired
    private SongService songService;

    @GetMapping("song/detail")
    public String songDetail(@RequestParam("ids") String ids) {
        try {
            return songService.songDetail(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("song/url")
    public String songUrl(@RequestParam("id") String id, @RequestParam(value = "br", defaultValue = "999000") Integer br) {
        try {
            return songService.songUrl(id, br);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("lyric")
    public String lyric(@RequestParam("id") String id) {
        try {
            return songService.lyric(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("comment/music")
    public String commentMusic(@RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return songService.commentMusic(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("personalized/newsong")
    public String personalizedNewsong() {
        try {
            return songService.personalizedNewsong();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("top/song")
    public String topSong(@RequestParam(value = "type", defaultValue = "0") Integer type) {
        try {
            return songService.topSong(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
