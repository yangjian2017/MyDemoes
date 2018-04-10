package cn.jt.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date工具类
 *
 * @author yangjian
 */
public class DateUtil {

    /**
     * 当天的开始时间
     *
     * @return
     */
    public static long getToday1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        return date.getTime();
    }

    /**
     * 当天的结束时间
     *
     * @return
     */
    public static long getToday2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date date = calendar.getTime();
        return date.getTime();
    }

    /**
     * 昨天的开始时间
     *
     * @return
     */
    public static long getYesterday1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        return date.getTime();
    }

    /**
     * 昨天的结束时间
     *
     * @return
     */
    public static long getYesterday2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DATE, -1);
        Date date = calendar.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取上周的开始时间
     */
    public static long getLastWeek1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, -7);
        Date date = calendar.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取上周的结束时间
     */
    public static long getLastWeek2() {// 当周开始时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date date = calendar.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取本周的开始时间 示例：2013-05-13 00:00:00
     */
    public static long getThisWeek1() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date date = currentDate.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取本周的结束时间 示例：2013-05-19 23:59:59
     */
    public static long getThisWeek2() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        currentDate.set(Calendar.MILLISECOND, 999);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date date = currentDate.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取本月的开始时间
     */
    public static long getThisMonth1() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        Date date = currentDate.getTime();
        return date.getTime();
    }

    public static long getThisMonth2() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取上月的开始时间
     */
    public static long getLastMonth1() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        currentDate.add(Calendar.MONTH, -1);
        Date date = currentDate.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取上月的结束时间
     */
    public static long getLastMonth2() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取上上月的开始时间
     */
    public static long getLast2Month1() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        currentDate.add(Calendar.MONTH, -2);
        Date date = currentDate.getTime();
        return date.getTime();
    }

    /**
     * 功能：获取上上月的结束时间
     */
    public static long getLast2Month2() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.MONTH, -1);
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        return date.getTime();
    }

    /**
     * 根据long返回year
     *
     * @param milliseconds
     *
     * @return
     */
    public static int getYear(long milliseconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(milliseconds);
        return cal.get(Calendar.YEAR);
    }
    /**
     * 获取月份
     *
     * @return
     */
    public static int getMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 从一个字符串格式的日期中获取月份
     *
     * @param time
     *
     * @return
     */
    public static int getMonth(String time) {
        Date date;
        try {
            date = DateFormat.getInstance().parse(time);
        } catch (ParseException e) {
            date = new Date();
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 今天是星期几
     *
     * @return
     */
    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 今天是几号
     *
     * @return
     */
    public static int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 取得当月天数
     */
    public static int getDaysOfMonth() {
        Calendar calendar = Calendar.getInstance();
        //把日期设置为当月第一天
        calendar.set(Calendar.DATE, 1);
        //日期回滚一天，也就是最后一天
        calendar.roll(Calendar.DATE, false);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 得到指定月的天数
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        //把日期设置为当月第一天
        calendar.set(Calendar.DATE, 1);
        //日期回滚一天，也就是最后一天
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }

    public static String getDate(long millisecond) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(millisecond));
    }

    public static String getTime(long millisecond) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(millisecond));
    }

    public static String getDatetime(long millisecond) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(millisecond));
    }

    public static String getFormatTime(long millisecond, String pattern) {
        return new SimpleDateFormat(pattern).format(new Date(millisecond));
    }

    public static void main(String[] args) {
    }
}