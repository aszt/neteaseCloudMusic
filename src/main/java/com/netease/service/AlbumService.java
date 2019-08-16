package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    private MusicProperties mp;

    public String newAlbum() throws Exception {
        String url = mp.baseUrl + mp.discoveryNewAlbum;
        UrlParam up = Api.album(url);
        return SendRequest.getMusicData(up);
    }
}
