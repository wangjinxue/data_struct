package me.wjx.map;

import java.util.HashMap;

/**
 * @author wjx
 * @date 2018/6/29 16:50
 */
public class App {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>(10);
        String key="key";
        int i=1;
        map.put(key,i);
        map.get("key");

    }
}
