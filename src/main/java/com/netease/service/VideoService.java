package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private MusicProperties MP;

    public String mvDetail(String mvid) throws Exception {
        String url = MP.BASEURL + MP.MVDETAIL;
        UrlParam up = Api.mvDetail(url, mvid);
        return SendRequest.getMusicData(up);
    }

    public String videoDetail(String id) throws Exception {
        String url = MP.BASEURL + MP.VIDEODETAIL;
        UrlParam up = Api.mvDetail(url, id);
        return SendRequest.getMusicData(up);
    }

    public String mvUrl(String id) throws Exception {
        String url = MP.BASEURL + MP.MVURL;
        UrlParam up = Api.mvUrl(url, id);
        return SendRequest.getMusicData(up);
    }

    public String videoUrl(String id) throws Exception {
        String url = MP.BASEURL + MP.VIDEOURL;
        UrlParam up = Api.videoUrl(url, id);
        return SendRequest.getMusicData(up);
    }

    public String relatedAllvideo(String id) throws Exception {
        String url = MP.BASEURL + MP.RELATEDALLVIDEO;
        UrlParam up = Api.relatedAllvideo(url, id);
        return SendRequest.getMusicData(up);
    }

    public String commentMv(String id, Integer limit, Integer offset) throws Exception {
        String url = MP.BASEURL + MP.COMMENTMV + id;
        UrlParam up = Api.commentMv(url, id, limit, offset);
        return SendRequest.getMusicData(up);
    }

    public String commentVideo(String id, Integer limit, Integer offset) throws Exception {
        String url = MP.BASEURL + MP.COMMENTVIDEO + id;
        UrlParam up = Api.commentMv(url, id, limit, offset);
        return SendRequest.getMusicData(up);
    }
}
