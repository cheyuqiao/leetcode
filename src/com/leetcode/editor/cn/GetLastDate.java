package com.leetcode.editor.cn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: GetLastDate
 * @Description: TODO
 * @Author: che
 * @Date: 2021-08-31
 * @Version:v1.0
 */
public class GetLastDate {
    private static final String DATE_FORMAT_DAY = "yyyy-MM-dd";

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);
        //cal.set(2021, 1, 1);  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
        //cal.add(Calendar.MONTH,-1);
        Date time = cal.getTime();
        Date endTime = getDayEndMonth(cal.getTime());

//        Calendar calendar=Calendar.getInstance();
//        calendar.set(2021, 2, 1);  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
//        Date date=calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DAY);
        System.out.println(time);
        System.out.println(sdf.format(endTime));
    }

    public static String getLastDayOfMonth(int year, int month) {

        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        // cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.MONTH, month); //设置当前月的上一个月
        // 获取某月最大天数
        //int lastDay = cal.getActualMaximum(Calendar.DATE);
        int lastDay = cal.getMinimum(Calendar.DATE); //获取月份中的最小值，即第一天
        // 设置日历中月份的最大天数
        //cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.DAY_OF_MONTH, lastDay - 1); //上月的第一天减去1就是当月的最后一天
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DAY);
        return sdf.format(cal.getTime());
    }

    public static Date getDayEndMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  //获取某月最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);    //设置日历中月份的最大天数
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }
}
