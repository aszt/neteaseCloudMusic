package com.netease.controller;

import com.netease.dosc.VideoDocs;
import com.netease.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频模块（0-MV、1-用户上传视频）
 */
@RestController
public class VideoController implements VideoDocs {

    @Autowired
    private VideoService videoService;


    @GetMapping("mv/detail")
    public String mvDetail(@RequestParam("mvid") String mvid) {
        try {
            return videoService.mvDetail(mvid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("video/detail")
    public String videoDetail(@RequestParam("id") String id) {
        try {
            return videoService.videoDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("mv/url")
    public String mvUrl(@RequestParam("id") String id) {
        try {
            return videoService.mvUrl(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("video/url")
    public String videoUrl(@RequestParam("id") String id) {
        try {
            return videoService.videoUrl(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("related/allvideo")
    public String relatedAllvideo(@RequestParam("id") String id) {
        try {
            return videoService.relatedAllvideo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("comment/mv")
    public String commentMv(@RequestParam("id") String id, @RequestParam(value = "limit", defaultValue = "20") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return videoService.commentMv(id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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
