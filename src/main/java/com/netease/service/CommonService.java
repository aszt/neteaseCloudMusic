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
    private MusicProperties mp;

    public String banner(Integer type) throws Exception {
        if (type < 0 || type > 3) {
            return "参数错误";
        } else {
            String url = mp.baseUrl + mp.banner;
            UrlParam up = Api.banner(url, type);
            return SendRequest.getMusicData(up);
        }
    }

    public String album(String id) throws Exception {
        String url = mp.baseUrl + mp.album + "/" + id;
        UrlParam up = Api.album(url);
        return SendRequest.getMusicData(up);
    }

    public String commentHot(Integer type, String id, Integer limit, Integer offset) throws Exception {
        String url = mp.baseUrl + mp.commentHot;
        if (type == 0) {
            // 歌曲
            url += "/R_SO_4_" + id;
        } else if (type == 1) {
            // MV
            url += "/R_MV_5_" + id;
        } else if (type == 2) {
            // 歌单
            url += "/A_PL_0_" + id;
        } else if (type == 3) {
            // 专辑
            url += "/R_AL_3_" + id;
        } else if (type == 4) {
            // 电台
            url += "/A_DJ_1_" + id;
        } else if (type == 5) {
            // 视频
            url += "/R_VI_62_" + id;
        } else {
            return "类型错误！";
        }
        UrlParam up = Api.commentMusic(url, id, limit, offset);
        return SendRequest.getMusicData(up);
    }

}
