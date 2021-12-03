package com.leetcode.test;

import java.math.BigDecimal;

/**
 * @ClassName: LongMath
 * @Description: Long格式的数学计算
 * @Author: che
 * @Date: 2021-11-14
 * @Version:v1.0
 */
public class LongMath {
    public static void main(String[] args) {
        Long a = 500L;
        Long b = 256L;
        double rate = new BigDecimal(b.doubleValue()/a.doubleValue()).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(rate);
    }
}
