package com.netease.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicProperties {

    @Value("${neteaseMusic.cookieName}")
    public String cookieName;

    @Value("${neteaseMusic.baseUrl}")
    public String baseUrl;

    // banner
    @Value("${neteaseMusic.banner}")
    public String banner;

    // 推荐歌单
    @Value("${neteaseMusic.personalizedPlayList}")
    public String personalizedPlayList;

    // 最新专辑
    @Value("${neteaseMusic.discoveryNewAlbum}")
    public String discoveryNewAlbum;

    // 最新专辑
    @Value("${neteaseMusic.playlistDetail}")
    public String playlistDetail;

    // 排行榜
    @Value("${neteaseMusic.topList}")
    public String topList;

    // 获取音乐url
    @Value("${neteaseMusic.songUrl}")
    public String songUrl;

    // 获取歌词
    @Value("${neteaseMusic.lyric}")
    public String lyric;

    // 获取歌曲详情
    @Value("${neteaseMusic.songDetail}")
    public String songDetail;

    // 获取专辑内容
    @Value("${neteaseMusic.album}")
    public String album;

    // 歌曲评论
    @Value("${neteaseMusic.commentMusic}")
    public String commentMusic;

    // 热门评论
    @Value("${neteaseMusic.commentHot}")
    public String commentHot;

    // 每日歌曲推荐
    @Value("${neteaseMusic.recommendSongs}")
    public String recommendSongs;

    // 用户歌单
    @Value("${neteaseMusic.userPlayList}")
    public String userPlayList;

    // 搜索
    @Value("${neteaseMusic.search}")
    public String search;

    // 手机号码登录
    @Value("${neteaseMusic.loginCellphone}")
    public String loginCellphone;

    // 邮箱登录
    @Value("${neteaseMusic.login}")
    public String login;

    // 每日推荐歌单
    @Value("${neteaseMusic.recommendResource}")
    public String recommendResource;

    // MV详情
    @Value("${neteaseMusic.mvDetail}")
    public String mvDetail;

    // 视频详情
    @Value("${neteaseMusic.videoDetail}")
    public String videoDetail;

    // MV链接
    @Value("${neteaseMusic.mvUrl}")
    public String mvUrl;

    // 视频链接
    @Value("${neteaseMusic.videoUrl}")
    public String videoUrl;

    // 相关视频
    @Value("${neteaseMusic.relatedAllvideo}")
    public String relatedAllvideo;

    // MV评论
    @Value("${neteaseMusic.commentMv}")
    public String commentMv;

    // 视频评论
    @Value("${neteaseMusic.commentVideo}")
    public String commentVideo;

    // 搜索建议
    @Value("${neteaseMusic.searchSuggest}")
    public String searchSuggest;

    // 热搜列表(简略)
    @Value("${neteaseMusic.searchHot}")
    public String searchHot;

    // 热搜列表(详细)
    @Value("${neteaseMusic.searchHotDetail}")
    public String searchHotDetail;

    // 推荐新音乐
    @Value("${neteaseMusic.personalizedNewsong}")
    public String personalizedNewsong;

    // 新歌速递
    @Value("${neteaseMusic.topSong}")
    public String topSong;

    // 歌单评论
    @Value("${neteaseMusic.commentPlayList}")
    public String commentPlayList;

    // 所有榜单内容摘要
    @Value("${neteaseMusic.toplistDetail}")
    public String toplistDetail;

    // 全部歌单分类
    @Value("${neteaseMusic.playlistCatlist}")
    public String playlistCatlist;

    // 全部歌单分类
    @Value("${neteaseMusic.topPlaylist}")
    public String topPlaylist;
}
