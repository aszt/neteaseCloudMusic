package com.netease.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicProperties {

    @Value("${neteaseMusic.cookieName}")
    public String COOKIENAME;

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

    // 搜索建议
    @Value("${neteaseMusic.searchSuggest}")
    public String SEARCHSUGGEST;

    // 热搜列表(简略)
    @Value("${neteaseMusic.searchHot}")
    public String SEARCHHOT;

    // 热搜列表(详细)
    @Value("${neteaseMusic.searchHotDetail}")
    public String SEARCHHOTDETAIL;


    // 推荐新音乐
    @Value("${neteaseMusic.personalizedNewsong}")
    public String PERSONALIZEDNEWSONG;

    // 新歌速递
    @Value("${neteaseMusic.topSong}")
    public String TOPSONG;

    // 歌单评论
    @Value("${neteaseMusic.commentPlayList}")
    public String COMMENTPLAYLIST;

    // 所有榜单内容摘要
    @Value("${neteaseMusic.toplistDetail}")
    public String TOPLISTDETAIL;

    // 全部歌单分类
    @Value("${neteaseMusic.playlistCatlist}")
    public String PLAYLISTCATLIST;

    // 全部歌单分类
    @Value("${neteaseMusic.topPlaylist}")
    public String TOPPLAYLIST;
}
