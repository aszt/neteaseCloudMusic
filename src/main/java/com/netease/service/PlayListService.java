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

    public String commentPlaylist(String id, Integer limit, Integer offset, String before) throws Exception {
        String url = MP.BASEURL + MP.COMMENTPLAYLIST + id;
        UrlParam up = Api.commentPlaylist(url, id, limit, offset, before);
        return SendRequest.getMusicData(up);
    }

    public String playlistCatlist() throws Exception {
        String url = MP.BASEURL + MP.PLAYLISTCATLIST;
        UrlParam up = Api.open(url);
        return SendRequest.getMusicData(up);
    }

    public String topPlaylist(String order, String cat, Integer limit, Integer offset) throws Exception {
        String url = MP.BASEURL + MP.TOPPLAYLIST;
        UrlParam up = Api.topPlaylist(url, order, cat, limit, offset);
        return SendRequest.getMusicData(up);
    }
}
