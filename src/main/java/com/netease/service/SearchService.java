package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private MusicProperties MP;

    public String searchSuggest(String keywords, String type) throws Exception {
        if (type.equals("mobile")) {
            type = "keyword";
        } else {
            type = "web";
        }
        String url = MP.BASEURL + MP.SEARCHSUGGEST + type;
        UrlParam up = Api.searchSuggest(url, keywords);
        return SendRequest.getMusicData(up);
    }

    public String searchHot() throws Exception {
        String url = MP.BASEURL + MP.SEARCHHOT;
        UrlParam up = Api.searchHot(url);
        return SendRequest.getMusicData(up);
    }

    public String searchHotDetail() throws Exception {
        String url = MP.BASEURL + MP.SEARCHHOTDETAIL;
        UrlParam up = Api.album(url);
        return SendRequest.getMusicData(up);
    }

    public String search(String keywords, Integer type, Integer limit, Integer offset) throws Exception {
        String url = MP.BASEURL + MP.SEARCH;
        UrlParam up = Api.search(url, keywords, type, limit, offset);
        return SendRequest.getMusicData(up);
    }
}
