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
public class CommonService {

    @Autowired
    private MusicProperties MP;

    public String songUrl(String ids, Integer br) throws Exception {
        String url = MP.BASEURL + MP.SONGURL;
        UrlParam up = Api.songUrl(url, ids, br);
        System.out.println("urlParam:" + up.toString());
        String params = up.getParams().toJSONString();
        System.out.println("params:" + params);
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("data:" + data);
        String list = SendRequest.send(url, data);
        System.out.println(list);
        return list;
    }

    public String lyric(String id) throws Exception {
        String url = MP.BASEURL + MP.LYRIC;
        UrlParam up = Api.lyric(url, id);
        System.out.println("urlParam:" + up.toString());
        String params = up.getParams().toJSONString();
        System.out.println("params:" + params);
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("data:" + data);
        String list = SendRequest.send(url, data);
        System.out.println(list);
        return list;
    }

    public String songDetail(String ids) throws Exception {
        String url = MP.BASEURL + MP.SONGDETAIL;
        UrlParam up = Api.songDetail(url, ids);
        System.out.println("urlParam:" + up.toString());
        String params = up.getParams().toJSONString();
        System.out.println("params:" + params);
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("data:" + data);
        String list = SendRequest.send(url, data);
        System.out.println(list);
        return list;
    }

    public String album(String id) throws Exception {
        String url = MP.BASEURL + MP.ALBUM+"/"+id;
        UrlParam up = Api.album(url, id);
        System.out.println("urlParam:" + up.toString());
        String params = up.getParams().toJSONString();
        System.out.println("params:" + params);
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("data:" + data);
        String list = SendRequest.send(url, data);
        System.out.println(list);
        return list;
    }
}
