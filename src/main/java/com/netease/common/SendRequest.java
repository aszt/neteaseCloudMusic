package com.netease.common;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.HashMap;

public class SendRequest {

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
