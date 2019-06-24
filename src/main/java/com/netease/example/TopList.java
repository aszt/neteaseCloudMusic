package com.netease.example;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.utils.JSSecret;
import com.netease.utils.MusicEncrypt;
import com.netease.utils.NewMusicEncrypt;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 排行榜
 * "3779629", //云音乐新歌榜
 * "3778678", //云音乐热歌榜
 * "2884035", ///云音乐原创榜
 * "19723756", //云音乐飙升榜
 * "10520166", //云音乐电音榜
 * "180106", //UK排行榜周榜
 * "60198", //美国Billboard周榜
 * "21845217", //KTV嗨榜
 * "11641012", //iTunes榜
 * "120001", //Hit FM Top榜
 * "60131", //日本Oricon周榜
 * "3733003", //韩国Melon排行榜周榜
 * "60255", //韩国Mnet排行榜周榜
 * "46772709", //韩国Melon原声周榜
 * "112504", //中国TOP排行榜(港台榜)
 * "64016", //中国TOP排行榜(内地榜)
 * "10169002", //香港电台中文歌曲龙虎榜
 * "4395559", //华语金曲榜
 * "1899724", //中国嘻哈榜
 * "27135204", //法国 NRJ EuroHot 30周榜
 * "112463", //台湾Hito排行榜
 * "3812895", //Beatport全球电子舞曲榜
 * "71385702", //云音乐ACG音乐榜
 * "991319590" //云音乐嘻哈榜
 */
public class TopList {

    public static void main(String[] args) {
        try {
            String phone = "tongchongyuan@163.com";
            String password = "tongchongyuan88";
            String secKey = DigestUtils.md5DigestAsHex(password.getBytes());
            String url = "https://music.163.com/weapi/login";
            UrlParam up = Api.login(url, phone, secKey);
            String list = SendRequest.getMusicData(up);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
