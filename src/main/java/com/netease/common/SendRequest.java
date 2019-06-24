package com.netease.common;

import com.alibaba.fastjson.JSONObject;
import com.netease.bean.UrlParam;
import com.netease.utils.NewMusicEncrypt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SendRequest {

    /**
     * 不需要携带cookie
     *
     * @param up
     * @return
     * @throws Exception
     */
    public static String getMusicData(UrlParam up) throws Exception {
        String url = up.getUrl();
        String params = up.getParams().toJSONString();
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("urlParam:" + up.toString());
        System.out.println("params:" + params);
        System.out.println("data:" + data);
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
                .data(data)
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        String list = response.body();

        Map<String, String> cookies = response.cookies();
        if (cookies.size() > 0) {
            // cookie处理
            JSONObject resultJsonObject = JSONObject.parseObject(list);
            StringBuffer sb = new StringBuffer();
            String remember_me = cookies.get("__remember_me");
            String music_u = cookies.get("MUSIC_U");
            String csrf = cookies.get("__csrf");
            String ntes_nuid = NewMusicEncrypt.createRandomKey(32);
            sb.append("_ntes_nuid=" + ntes_nuid + ";");
            sb.append("__remember_me=" + remember_me + ";");
            sb.append("MUSIC_U=" + music_u + ";");
            sb.append("__csrf=" + csrf + ";");
            resultJsonObject.put("cookie", sb);
            System.out.println(resultJsonObject.toString());
            return resultJsonObject.toString();
        } else {
            System.out.println(list);
            return list;
        }
    }

    /**
     * 用户数据访问，需携带cookie
     *
     * @param up
     * @return
     * @throws Exception
     */
    public static String getMusicDataByCookie(UrlParam up) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String url = up.getUrl();
        String params = up.getParams().toJSONString();
        String cookie = up.getCookie();
        HashMap<String, String> data = NewMusicEncrypt.getData(params);
        System.out.println("urlParam:" + up.toString());
        System.out.println("params:" + params);
        System.out.println("data:" + data);
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
                .cookie("Cookie", cookie)
                .data(data)
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .timeout(10000)
                .execute();
        String list = response.body();
        System.out.println(list);
        return list;
    }
}
