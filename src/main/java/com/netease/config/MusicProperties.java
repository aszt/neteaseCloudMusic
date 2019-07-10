package com.netease.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicProperties {

    @Value("${neteaseMusic.baseUrl}")
    public String BASEURL;

    // banner
    @Value("${neteaseMusic.banner}")
    public String BANNER;

    // 推荐歌单
    @Value("${neteaseMusic.personalizedPlayList}")
    public String PERSONALIZEDPLAYLIST;

    // 最新专辑
    @Value("${neteaseMusic.discoveryNewAlbum}")
    public String DISCOVERYNEWALBUM;

    // 最新专辑
    @Value("${neteaseMusic.playlistDetail}")
    public String PLAYLISTDETAIL;

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

    // 每日歌曲推荐
    @Value("${neteaseMusic.recommendSongs}")
    public String RECOMMENDSONGS;

    // 用户歌单
    @Value("${neteaseMusic.userPlayList}")
    public String USERPLAYLIST;

    // 搜索
    @Value("${neteaseMusic.search}")
    public String SEARCH;

    // 手机号码登录
    @Value("${neteaseMusic.loginCellphone}")
    public String LOGINCELLPHONE;

    // 邮箱登录
    @Value("${neteaseMusic.login}")
    public String LOGIN;

    // 每日推荐歌单
    @Value("${neteaseMusic.recommendResource}")
    public String RECOMMENDRESOURCE;

    // MV详情
    @Value("${neteaseMusic.mvDetail}")
    public String MVDETAIL;

    // 视频详情
    @Value("${neteaseMusic.videoDetail}")
    public String VIDEODETAIL;

    // MV链接
    @Value("${neteaseMusic.mvUrl}")
    public String MVURL;

    // 视频链接
    @Value("${neteaseMusic.videoUrl}")
    public String VIDEOURL;

    // 相关视频
    @Value("${neteaseMusic.relatedAllvideo}")
    public String RELATEDALLVIDEO;

    // MV评论
    @Value("${neteaseMusic.commentMv}")
    public String COMMENTMV;

    // 视频评论
    @Value("${neteaseMusic.commentVideo}")
    public String COMMENTVIDEO;

}
