package com.netease.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 请求bean
 */
@Data
public class UrlParam {

    public String url;

    public JSONObject params;

    public UrlParam() {
        this.params = new JSONObject();
    }

    public UrlParam addParam(String key, Object value) {
        this.params.put(key, value.toString());
        return this;
    }
}
