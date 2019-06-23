package com.netease.common;

import com.netease.bean.UrlParam;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Api {

    public static UrlParam topList(String url, String id, Integer n) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("n", n);
        return up;
    }

    public static UrlParam songUrl(String url, String ids, Integer br) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("ids", "[" + ids + "]");
        up.addParam("br", br);
        return up;
    }

    public static UrlParam lyric(String url, String id) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("lv", -1);
        up.addParam("kv", -1);
        up.addParam("tv", -1);
        return up;
    }

    public static UrlParam songDetail(String url, String ids) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        String[] split = ids.split(",");
        String collect = Arrays.stream(split).map(i -> "{'id':'" + i.toString() + "'}").collect(Collectors.joining(","));
//        up.addParam("c", "[{'id':'1365393542'},{'id':'1369601580'}]");
        up.addParam("c", "[" + collect + "]");
        up.addParam("ids", "[" + ids + "]");
        return up;
    }

    public static UrlParam album(String url) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        return up;
    }

    public static UrlParam commentMusic(String url, String id, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("rid", id);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        return up;
    }

    public static UrlParam recommendSongs(String url, String uid) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
//        up.addParam("uid", "259679147");
        up.addParam("limit", 20);
        up.addParam("offset", 0);
        up.addParam("total", true);
//        up.addParam("csrf_token", "eaba29ac3fb8730cde19b626d0ee4ed4");
        return up;
    }

    public static UrlParam userPlayList(String url, String uid, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("uid", uid);
//        up.addParam("total", true);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
//        up.addParam("n", 1000);
        return up;
    }

    public static UrlParam search(String url, String keywords, Integer type, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("s", keywords);
        up.addParam("type", type);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        return up;
    }

    public static UrlParam loginCellphone(String url, String phone, String password) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("phone", phone);
        up.addParam("password", password);
        up.addParam("rememberLogin", "true");
        return up;
    }

    public static UrlParam login(String url, String email, String password) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("username", email);
        up.addParam("password", password);
        up.addParam("rememberLogin", "true");
        return up;
    }
}
