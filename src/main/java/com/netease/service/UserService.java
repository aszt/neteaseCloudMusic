package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MusicProperties MP;

    public String recommendSongs(String uid) throws Exception {
        String url = MP.BASEURL + MP.RECOMMENDSONGS + "?csrf_token=eaba29ac3fb8730cde19b626d0ee4ed4";
        UrlParam up = Api.recommendSongs(url, uid);
        return SendRequest.getMusicData(up);
    }

    public String userPlayList(String uid, Integer limit, Integer offset) throws Exception {
        String url = MP.BASEURL + MP.USERPLAYLIST;
        UrlParam up = Api.userPlayList(url, uid, limit, offset);
        return SendRequest.getMusicData(up);
    }
}
