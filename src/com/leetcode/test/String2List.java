package com.leetcode.test;


import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: String2List
 * @Description: TODO
 * @Author: che
 * @Date: 2021-09-15
 * @Version:v1.0
 */
public class String2List {
    public static void main(String[] args) {
//        String str = "[{\"url\":\"aaa\", \"name\":\"BBBBBBBBB\"},{\"url\":\"bbb\", \"name\":\"CCCCCCCCC\"},{\"url\":\"ccc\", \"name\":\"DDDDDDDDD\"}]";
//        JSONArray jsonArray = JSONArray.parseArray(str);
//        List<Msg2> list = jsonArray.toJavaList(Msg2.class);
//        jsonArray.tol
//        System.out.println(str);
//        System.out.println(list.size());
    }
}

class Msg2 implements Serializable {
    String url;
    String name;

    public Msg2() {
    }

    public Msg2(String url, String name) {
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

