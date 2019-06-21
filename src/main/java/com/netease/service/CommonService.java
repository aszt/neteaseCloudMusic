package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CommonService {

    @Autowired
    private MusicProperties MP;

    public String songUrl(String ids, Integer br) throws Exception {
        String url = MP.BASEURL + MP.SONGURL;
        UrlParam up = Api.songUrl(url, ids, br);
        return SendRequest.getMusicData(up);
    }

    public String lyric(String id) throws Exception {
        String url = MP.BASEURL + MP.LYRIC;
        UrlParam up = Api.lyric(url, id);
        return SendRequest.getMusicData(up);
    }

    public String songDetail(String ids) throws Exception {
        String url = MP.BASEURL + MP.SONGDETAIL;
        UrlParam up = Api.songDetail(url, ids);
        return SendRequest.getMusicData(up);
    }

    public String album(String id) throws Exception {
        String url = MP.BASEURL + MP.ALBUM + "/" + id;
        UrlParam up = Api.album(url, id);
        return SendRequest.getMusicData(up);
    }
}
