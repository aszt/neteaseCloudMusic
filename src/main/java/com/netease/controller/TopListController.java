package com.netease.controller;

import com.netease.dosc.TopListDocs;
import com.netease.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 榜单模块
 */
@RestController
public class TopListController implements TopListDocs {

    @Autowired
    private TopListService topListService;

    @GetMapping("top/list")
    public String topList(@RequestParam("idx") String idx, @RequestParam(value = "n", defaultValue = "10000") Integer n) {
        try {
            return topListService.topList(idx, n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("toplist/detail")
    public String toplistDetail() {
        try {
            return topListService.toplistDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
