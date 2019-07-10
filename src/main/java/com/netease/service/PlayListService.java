package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayListService {

    @Autowired
    private MusicProperties MP;

    public String personalized(Integer limit, Integer offset) throws Exception {
        String url = MP.BASEURL + MP.PERSONALIZEDPLAYLIST;
        UrlParam up = Api.personalized(url, limit, offset);
        return SendRequest.getMusicData(up);
    }

    public String playlistDetail(String id, Integer s) throws Exception {
        String url = MP.BASEURL + MP.PLAYLISTDETAIL;
        UrlParam up = Api.playlistDetail(url, id, s);
        return SendRequest.getMusicData(up);
    }
}
