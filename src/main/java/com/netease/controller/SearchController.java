package com.netease.controller;

import com.netease.dosc.SearchDocs;
import com.netease.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搜索模块
 */
@RestController
public class SearchController implements SearchDocs {

    @Autowired
    private SearchService searchService;


    @GetMapping("search/suggest")
    public String searchSuggest(@RequestParam("keywords") String keywords, @RequestParam(value = "type", defaultValue = "mobile") String type) {
        try {
            return searchService.searchSuggest(keywords, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("search/hot")
    public String searchHot() {
        try {
            return searchService.searchHot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("search/hot/detail")
    public String searchHotDetail() {
        try {
            return searchService.searchHotDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("search")
    public String search(@RequestParam("keywords") String keywords, @RequestParam(value = "type", defaultValue = "1") Integer type, @RequestParam(value = "limit", defaultValue = "30") Integer limit, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        try {
            return searchService.search(keywords, type, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
