package com.hdl.mudium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 * Created by huangdongliang on 2018/8/15.
 */
public class TinyURL535 {
    private static Map<String, String> dict = new HashMap<String, String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = "http://tinyurl.com/" + longUrl.hashCode();
        dict.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return dict.get(shortUrl);
    }

    public static void main(String args[]) {
        TinyURL535 codec = new TinyURL535();
        String longUrl="https://leetcode.com/problems/design-tinyurl";
        String shortUrl = codec.encode(longUrl);
        System.out.println("shortUrl:"+shortUrl);
        String decodeUrl = codec.decode(shortUrl);
        System.out.println("shortUrl:"+decodeUrl);
    }

}
