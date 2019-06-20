package com.netease.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicProperties {

    @Value("${neteaseMusic.baseUrl}")
    public String BASEURL;

    // 排行榜
    @Value("${neteaseMusic.topList}")
    public String TOPLIST;

    // 获取音乐url
    @Value("${neteaseMusic.songUrl}")
    public String SONGURL;

    @Value("${neteaseMusic.lyric}")
    public String LYRIC;

}
