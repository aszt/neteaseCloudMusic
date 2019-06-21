package com.netease.common;

import com.netease.bean.UrlParam;
import com.netease.utils.NewMusicEncrypt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.HashMap;

public class SendRequest {

    public static String getMusicData(UrlParam up) throws Exception {
        String url = up.getUrl();
        System.out.println("urlParam:" + up.toString());
        String params = up.getParams().toJSONString();
        System.out.println("params:" + params);
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("data:" + data);
        String list = send(url, data);
        System.out.println(list);
        return list;
    }

    public static String send(String url, HashMap<String, String> Data) throws Exception {
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
                .data(Data)
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        String list = response.body();
        return list;
    }
}
