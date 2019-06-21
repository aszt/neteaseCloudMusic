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

    // 获取歌词
    @Value("${neteaseMusic.lyric}")
    public String LYRIC;

    // 获取歌曲详情
    @Value("${neteaseMusic.songDetail}")
    public String SONGDETAIL;

    // 获取专辑内容
    @Value("${neteaseMusic.album}")
    public String ALBUM;

    // 歌曲评论
    @Value("${neteaseMusic.commentMusic}")
    public String COMMENTMUSIC;

    // 热门评论
    @Value("${neteaseMusic.commentHot}")
    public String COMMENTHOT;

}
