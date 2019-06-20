package com.netease.controller;

import com.netease.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共数据
 */
@RestController
@Api(description = "公共模块")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "获取音乐Url", notes = " 传入的音乐 id( 可多个 , 用逗号隔开 ), 可以获取对应的音乐的 url，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "音乐 id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "br", value = "码率,默认设置了 999000 即最大码率,如果要 320k 则可设置为 320000,其他类推", required = false, dataType = "int", paramType = "query")
    })
    @PostMapping("songUrl")
    public String songUrl(@RequestParam("ids") String ids, @RequestParam(value = "br", defaultValue = "999000") Integer br) {
        try {
            String list = commonService.songUrl(ids, br);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "获取歌词", notes = " 传入音乐 id 可获得对应音乐的歌词，例如：1365393542-孤身、1369601580-祝你爱我到天荒地老等")
    @ApiImplicitParam(name = "id", value = "音乐 id", required = true, dataType = "String", paramType = "query")
    @PostMapping("lyric")
    public String lyric(@RequestParam("id") String id) {
        try {
            String list = commonService.lyric(id);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
