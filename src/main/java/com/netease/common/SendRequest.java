package com.netease.common;

import com.netease.bean.UrlParam;
import com.netease.utils.NewMusicEncrypt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.HashMap;
import java.util.Map;

public class SendRequest {

    public static String getMusicData(UrlParam up) throws Exception {
        String url = up.getUrl();
        System.out.println("urlParam:" + up.toString());
        String params = up.getParams().toJSONString();
        System.out.println("params:" + params);
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("data:" + data);
        String list = send(url, data, "");
        System.out.println(list);
        return list;
    }

    public static String send(String url, HashMap<String, String> Data, String cookie) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String _ntes_nuid = NewMusicEncrypt.createRandomKey(32);
        Connection.Response
                response = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                .header("Accept", "*/*")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Host", "music.163.com")
                .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                .header("DNT", "1")
                .header("Pragma", "no-cache")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .cookie("Cookie", "_ntes_nuid=" + _ntes_nuid + "; __remember_me=true; MUSIC_U=9d0acc3c84eef18ecb3ece59623c0ef36502f48cec432dd78dea31c2c6935a72b686bd74a70dbb8669acbdd29ab03e997955a739ab43dce1; __csrf=b29d08aaa7b8d48ece61cf88881813f0")
                .data(Data)
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        String list = response.body();
        Map<String, String> cookies = response.cookies();
        map.put("body", list);
        map.put("cookies", cookies);
        return list;
    }
}
