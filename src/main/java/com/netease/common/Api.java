package com.netease.common;

import com.netease.bean.UrlParam;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Api {

    public static UrlParam banner(String url, Integer type) {
        String[] typeList = {"pc", "android", "iphone", "ipad"};
        url += "?clientType=" + typeList[type];
        UrlParam up = new UrlParam();
        up.setUrl(url);
//        up.addParam("clientType", typeList[type]);
        return up;
    }

    public static UrlParam personalized(String url, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("total", true);
        up.addParam("n", 1000);
        return up;
    }

    public static UrlParam playlistDetail(String url, String id, Integer s) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("n", 100000);
        up.addParam("s", s);
        return up;
    }

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

    public static UrlParam recommendSongs(String url, String cookie) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.setCookie(cookie);
        up.addParam("limit", 20);
        up.addParam("offset", 0);
        up.addParam("total", true);
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

    public static UrlParam recommendResource(String url, String cookie) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.setCookie(cookie);
        return up;
    }

    public static UrlParam mvDetail(String url, String mvid) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", mvid);
        return up;
    }

    public static UrlParam mvUrl(String url, String id) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("id", id);
        up.addParam("r", 1080);
        return up;
    }

    public static UrlParam videoUrl(String url, String id) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("ids", "[\"" + id + "\"]");
        up.addParam("resolution", 1080);
        return up;
    }

    public static UrlParam relatedAllvideo(String url, String id) {
        UrlParam up = new UrlParam();
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        boolean matches = pattern.matcher(id).matches();
        if (matches) {
            up.addParam("type", 0);
        } else {
            up.addParam("type", 1);
        }
        up.setUrl(url);
        up.addParam("id", id);
        return up;
    }

    public static UrlParam commentMv(String url, String id, Integer limit, Integer offset) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("rid", id);
        up.addParam("limit", limit);
        up.addParam("offset", offset);
        up.addParam("beforeTime", 0);
        return up;
    }

    public static UrlParam searchSuggest(String url, String keywords) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("s", keywords);
        return up;
    }

    public static UrlParam searchHot(String url) {
        UrlParam up = new UrlParam();
        up.setUrl(url);
        up.addParam("type", 1111);
        return up;
    }
}
