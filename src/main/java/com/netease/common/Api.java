package com.netease.common;

import com.netease.bean.UrlParam;

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
}
