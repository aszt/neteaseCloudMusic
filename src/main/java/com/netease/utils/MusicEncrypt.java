package com.netease.utils;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Random;

/**
 * 网易云音乐参数加密（方案一）
 * params：AES 加密
 * encSecKey：RSA 加密
 */
public class MusicEncrypt {

    // 密钥
    private static String nonce = "0CoJUm6Qyw8W8jud";

    // 偏移量
    private static String ivParameter = "0102030405060708";

    /**
     * AES加密
     * 此处使用AES-128-CBC加密模式，key需要为16位
     *
     * @param content 加密内容
     * @param sKey    偏移量
     * @return
     */
    public static String aesEncrypt(String content, String sKey) throws Exception {
        byte[] encryptedBytes;
        byte[] byteContent = content.getBytes("UTF-8");
        // 参数：算法、模式、补码方式
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes(), "AES");
        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
        encryptedBytes = cipher.doFinal(byteContent);
        // 此处使用BASE64做转码功能，同时能起到2次加密的作用
        return new String(Base64Utils.encode(encryptedBytes), "UTF-8");
    }

    /**
     * RSA 加密（暂写死）
     *
     * @return
     */
    public static String rsaEncrypt() {
        String secKey = "257348aecb5e556c066de214e531faadd1c55d814f9be95fd06d6bff9f4c7a41f831f6394d5a3fd2e3881736d94a02ca919d952872e7d0a50ebfa1769a7a62d512f5f1ca21aec60bc3819a9c3ffca5eca9a0dba6d6f7249b06f5965ecfff3695b54e1c28f3f624750ed39e7de08fc8493242e26dbc4484a01c76f739e135637c";
        return secKey;
    }

    /**
     * 随机字符串
     *
     * @param length 长度：取16
     * @return
     */
    public static String createSecretKey(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取加密参数（encSecKey暂写死）
     *
     * @param content 加密内容
     * @return
     * @throws Exception
     */
    public static HashMap<String, String> getData(String content) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        // 2次AES加密、加密模式都是CBC加密
        // 第一次加密使用message和key进行加密
        // 第二次使用第一次加密结果和16位随机字符串（暂写死）进行加密
        String params = aesEncrypt((MusicEncrypt.aesEncrypt(content, nonce)), "FFFFFFFFFFFFFFFF");
        String encSecKey = rsaEncrypt();
        data.put("params", params);
        data.put("encSecKey", encSecKey);
        return data;
    }

}
