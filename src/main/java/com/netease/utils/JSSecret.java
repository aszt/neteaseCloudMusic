package com.netease.utils;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.springframework.util.ResourceUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 网易云音乐参数加密（方案二）
 * 使用 ScriptEngine 调用 js 引擎
 */
public class JSSecret {

    private static Invocable inv;
    public static final String encText = "encText";
    public static final String encSecKey = "encSecKey";

    /**
     * 从本地加载修改后的 js 文件到 scriptEngine
     */
    static {
        try {
            // 文件读取
            String pathResources = ResourceUtils.getURL("classpath:").getPath();
            pathResources = pathResources + "file/core.js";
            pathResources = pathResources.substring(1, pathResources.length());
            Path path = Paths.get(pathResources);
            byte[] bytes = Files.readAllBytes(path);
            String js = new String(bytes);
            ScriptEngineManager factory = new ScriptEngineManager();
            // 查找并创建一个ScriptEngine
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            // js代码放入到eval中当做参数就可以执行相应的js代码
            engine.eval(js);
            // 调用js中的方法
            inv = (Invocable) engine;
            System.out.println("Init completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ScriptObjectMirror get_params(String paras) throws Exception {
        ScriptObjectMirror so = (ScriptObjectMirror) inv.invokeFunction("myFunc", paras);
        return so;
    }

    public static HashMap<String, String> getData(String paras) {
        try {
            ScriptObjectMirror so = (ScriptObjectMirror) inv.invokeFunction("myFunc", paras);

            Set<Map.Entry<String, Object>> entries = so.entrySet();
            for (Map.Entry<String, Object> map : entries) {
                System.out.println("key:" + map.getKey());
                System.out.println("value:" + map.getValue());
            }

            HashMap<String, String> data = new HashMap<>();
            data.put("params", so.get(JSSecret.encText).toString());
            data.put("encSecKey", so.get(JSSecret.encSecKey).toString());
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
