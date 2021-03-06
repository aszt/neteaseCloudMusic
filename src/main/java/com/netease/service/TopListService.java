package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import com.netease.utils.NewMusicEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TopListService {

    @Autowired
    private MusicProperties mp;

    public String topList(String id, Integer n) throws Exception {
        String url = mp.baseUrl + mp.topList;
        UrlParam up = Api.topList(url, id, n);
        return SendRequest.getMusicData(up);
    }

    public String toplistDetail() throws Exception {
        String url = mp.baseUrl + mp.toplistDetail;
        UrlParam up = Api.open(url);
        return SendRequest.getMusicData(up);
    }
}
