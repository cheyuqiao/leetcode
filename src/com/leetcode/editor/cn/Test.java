package com.leetcode.editor.cn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: che
 * @Date: 2021-08-17
 * @Version:v1.0
 */
public class Test {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);

        Date time = cal.getTime();
        System.out.println("time：" + time);
        cal.setTime(time);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date startTime = cal.getTime();

        cal.setTime(time);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  //获取某月最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);    //设置日历中月份的最大天数
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date endTime = cal.getTime();

//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE,-1);
//        Date time = cal.getTime();
//        // 设置前一天的开始时间
//        cal.setTime(time);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        Date startTime =  cal.getTime();
//        // 设置前一天的结束时间
//        cal.set(Calendar.HOUR_OF_DAY, 23);
//        cal.set(Calendar.MINUTE, 59);
//        cal.set(Calendar.SECOND, 59);
//        cal.set(Calendar.MILLISECOND, 999);
//        Date endTime = cal.getTime();
        System.out.println("定时任务时间查询时间：" + startTime + " - " + endTime);
    }
}
