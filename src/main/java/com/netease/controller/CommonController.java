package com.netease.controller;

import com.netease.dosc.CommonDocs;
import com.netease.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共数据
 */
@RestController
public class CommonController implements CommonDocs {

    @Autowired
    private CommonService commonService;

    @GetMapping("banner")
    public String banner(@RequestParam(value = "type", defaultValue = "0") Integer type) {
        try {
            return commonService.banner(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("album")
    public String album(@RequestParam("id") String id) {
        try {
            return commonService.album(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("commentHot")
    public String commentHot(
            @RequestParam("type") Integer type,
            @RequestParam("id") String id,
            @RequestParam(value = "limit", defaultValue = "20") Integer limit,
            @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return commonService.commentHot(type, id, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
