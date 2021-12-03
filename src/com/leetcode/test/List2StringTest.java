package com.leetcode.test;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: List2StringTest
 * @Description: TODO
 * @Author: che
 * @Date: 2021-09-15
 * @Version:v1.0
 */
public class List2StringTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list.toString().replace("[", "").replace("]", ""));
//        List<Msg> list = new ArrayList<>();
//        list.add(new Msg("aaa","BBBBBBBBB"));
//        list.add(new Msg("bbb","CCCCCCCCC"));
//        list.add(new Msg("ccc","DDDDDDDDD"));
//        System.out.println(JSONArray.toJSONString(list));
    }
}
class Msg{
    String url;
    String name;

    public Msg() {
    }

    public Msg(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"" +
                "url\":\"" + url + "\"" +
                ", \"name\":\"" + name + "\"" +
                '}';
    }
}
