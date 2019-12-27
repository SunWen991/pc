package com.yaoren.common.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: DateUtil
 * @Description: 日期时间工具
 * @author zxh
 * @date 2016-8-6
 * 
 */
public class DateUtil
{

    private static Logger logger = Logger.getLogger(DateUtil.class);

    private static final long MILLISECONDS_A_DAY = 24 * 3600 * 1000;

    private static final long MILLISECONDS_A_HOUR = 3600 * 1000;

    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final String DEFAULT_DATEFULLTIME_FORMAT = "yyyyMMddHHmmss";

    public static final String DEFAULT_FULLDATETIME_FORMAT = "yyyyMMddHHmmssSSS";

    public static final String DEFAULT_DATEFULLDATE_FORMAT = "yyyyMMdd";

    public static final String DEFAULT_YEAR_FORMAT = "yyyy";

    public static final String DEFAULT_MONTH_FORMAT = "MM";

    private static final Pattern pattern = Pattern.compile("(?:(?:19|20)\\d{2})-(?:0?[1-9]|1[0-2])-(?:0?[1-9]|[12][0-9]|3[01])");

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date addMinutes(Date date, int minute)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }
    
    public static Date addSeconds(Date date, int second)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);
        return cal.getTime();
    }

    public static Date parseDate(String s) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(s);
    }
    
    public static Date parseDate(String s,String format) throws ParseException
    {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    	return simpleDateFormat.parse(s);
    }
    
    public static Date parseDate2hms(String s) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.parse(s);
    }

    public static Date addMonths(Date date, int months)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public static Date getMaxDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

    public static int getYear()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    public static int getMonth()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }

    public static Date getMinDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        return cal.getTime();
    }

    public static Date getMinDateByMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        return cal.getTime();
    }

    public static Date getMaxDateByMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

    public static Date getLastDayOfLastMonth(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        // cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date addYears(Date date, int years)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    public static String datetime(String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(new Date());
    }

    public static String datetime(Date date, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String datetime(String date, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String date(Date date, String format)
    {
        if (date == null)
        {
            return "";
        }

        return (new SimpleDateFormat(format)).format(date);
    }

    public static String date(String dateStr, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(dateStr);
    }

    public static String getNowDateStr()
    {
        return getNowDatetimeStr(DEFAULT_DATE_FORMAT);
    }

    public static String getNowDatetimeStr()
    {
        return getNowDatetimeStr(DEFAULT_DATETIME_FORMAT);
    }

    public static String getNowDateminStr()
    {
        return getNowDatetimeStr(DEFAULT_DATEFULLTIME_FORMAT);
    }

    public static String getNowDatetimeStr(String format)
    {
        Calendar cal = Calendar.getInstance();
        return datetime(cal.getTime(), format);
    }

    public static Date dateOnly(Date date)
    {
        return new Date(date.getTime() / MILLISECONDS_A_DAY);
    }

    public static Date dateOnlyExt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date dateMinTime(Date date)
    {
        return dateOnlyExt(date);
    }

    public static String getStandDateTimeStr(String dateTimeStr)
    {
        if (dateTimeStr == null || "".equals(dateTimeStr))
        {
            return "";
        }

        dateTimeStr = dateTimeStr.replaceAll("\\s+", "|");
        String[] a = dateTimeStr.split("\\|");
        List<String> list = Arrays.asList(a);
        String datetime = "";
        int count = 1;
        for (int i = 0; i < list.size(); i++)
        {
            String temp = (String) list.get(i);
            StringTokenizer st;
            if (i == 0)
                st = new StringTokenizer(temp, "-");
            else
                st = new StringTokenizer(temp, ":");
            int k = st.countTokens();
            for (int j = 0; j < k; j++)
            {
                String sttemp = (String) st.nextElement();
                if (count == 1)
                {
                    datetime = sttemp;
                } else
                {
                    if ((sttemp.equals("0")) || (sttemp.equals("00")))
                        sttemp = "0";
                    else if ((Integer.valueOf(sttemp).intValue()) < 10)
                        sttemp = sttemp.replaceAll("0", "");
                    if (count < 4)
                    {
                        if ((Integer.valueOf(sttemp).intValue()) < 10)
                            datetime = datetime + "-0" + sttemp;
                        else
                            datetime = datetime + "-" + sttemp;
                    }
                    if (count == 4)
                    {
                        if ((Integer.valueOf(sttemp).intValue()) < 10)
                            datetime = datetime + " 0" + sttemp;
                        else
                            datetime = datetime + " " + sttemp;
                    }
                    if (count > 4)
                    {
                        if ((Integer.valueOf(sttemp).intValue()) < 10)
                            datetime = datetime + ":0" + sttemp;
                        else
                            datetime = datetime + ":" + sttemp;
                    }
                }
                count++;
            }
        }

        try
        {
            @SuppressWarnings("unused")
            Date test = getDateFromStr(datetime);
            return datetime;
        } catch (Exception e)
        {
            return "";
        }
    }

    @SuppressWarnings("deprecation")
    public static Date getDateFromStr(String datetime)
    {
        if (datetime == null || "".equals(datetime))
        {
            return new Date();
        }

        String nyr = datetime.trim();

        if (nyr.indexOf(" ") > 0)
        {
            nyr = nyr.substring(0, nyr.indexOf(" "));
        } else
        {
            nyr = nyr.substring(0, nyr.length());
        }

        StringTokenizer st = new StringTokenizer(nyr, "-");
        Date date = new Date();
        String temp = "";
        int count = st.countTokens();
        for (int i = 0; i < count; i++)
        {
            temp = (String) st.nextElement();
            // if(!(temp.equals("0")))
            // temp.replaceAll("0", "");
            if (i == 0)
                date.setYear(Integer.parseInt(temp) - 1900);
            if (i == 1)
                date.setMonth(Integer.parseInt(temp) - 1);
            if (i == 2)
                date.setDate(Integer.parseInt(temp));
        }

        if (datetime.length() > 10)
        {
            String sfm = datetime.substring(11, 19);
            StringTokenizer st2 = new StringTokenizer(sfm, ":");
            count = st2.countTokens();
            for (int i = 0; i < count; i++)
            {
                temp = (String) st2.nextElement();
                // if(!(temp.equals("0")))
                // temp.replaceAll("0", "");
                if (i == 0)
                    date.setHours(Integer.parseInt(temp));
                if (i == 1)
                    date.setMinutes(Integer.parseInt(temp));
                if (i == 2)
                    date.setSeconds(Integer.parseInt(temp));
            }
        }
        return date;
    }

    public static int getQuot(Date startDate, Date endDate)
    {
        long quot = 0;
        quot = endDate.getTime() - startDate.getTime();
        quot = quot / MILLISECONDS_A_DAY;
        return (int) quot;
    }

    public static int getQuot(String startDateStr, String endDateStr, String format)
    {
        long quot = 0;
        format = (format != null && format.length() > 0) ? format : DEFAULT_DATE_FORMAT;
        SimpleDateFormat ft = new SimpleDateFormat(format);
        try
        {
            Date date1 = ft.parse(endDateStr);
            Date date2 = ft.parse(startDateStr);
            quot = date1.getTime() - date2.getTime();
            quot = quot / MILLISECONDS_A_DAY;
        } catch (ParseException e)
        {
            logger.error("", e);
        }
        return (int) quot;
    }

    public static final String getDateTime(Date date)
    {
        if (date == null)
            return "";
        DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return ymdhmsFormat.format(date);
    }

    public static final String getDateTime(Date date, String pattern)
    {
        if (date == null)
            return "";
        DateFormat ymdhmsFormat = new SimpleDateFormat(pattern);
        return ymdhmsFormat.format(date);
    }

    public static int getQuotHours(Date startDate, Date endDate)
    {
        long quot = 0;
        quot = endDate.getTime() - startDate.getTime();
        quot = quot / MILLISECONDS_A_HOUR;
        return (int) quot;
    }

    public static Date getDateTime(String dateTime)
    {
        return getDateTime(dateTime, "yyyy-MM-dd");
    }

    public static Date getDateTime(String dateTime, String formatPattern)
    {
        try
        {
            if (StringUtils.isNotBlank(dateTime) && StringUtils.isNotBlank(formatPattern))
            {
                SimpleDateFormat format = new SimpleDateFormat(formatPattern);
                return format.parse(dateTime);
            }
        } catch (ParseException e)
        {
            logger.error(e);
        }

        return null;
    }

    public static Date getDateDetailTime(String dateTime)
    {
        try
        {
            if (StringUtils.isNotBlank(dateTime))
            {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                return format.parse(dateTime);
            }
        } catch (ParseException e)
        {
            logger.error(e);
        }

        return null;
    }

    public static long getDtSeq()
    {
        return System.currentTimeMillis();
    }

    public static boolean isBetween(Date min, Date compare)
    {
        Boolean ret = false;
        Date minDate = DateUtil.dateOnlyExt(min);
        Date maxDate = DateUtil.dateOnlyExt(DateUtil.addDays(min, 1));
        if (compare.after(minDate) && compare.before(maxDate))
        {
            ret = true;
        }
        return ret;
    }

    public static Date getDate(int year, int month, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    public static Map<String, String> getFLDayMap(String monthRange)
    {
        return getFLDayMap(monthRange, DEFAULT_DATE_FORMAT);
    }

    public static Map<String, String> getFLDayMap(String monthRange, String pattern)
    {
        Map<String, String> rs = new LinkedHashMap<String, String>();

        SimpleDateFormat df = new SimpleDateFormat(pattern);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        if (StringUtils.isBlank(monthRange))
        {
            monthRange = "cm";
        }

        if (!"sm".equals(monthRange))
        {
            if ("pm".equals(monthRange))
            {
                calendar.add(Calendar.MONTH, -1);
            }

            calendar.set(Calendar.DAY_OF_MONTH, 1);
            rs.put("firstDay", df.format(calendar.getTime()));

            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            rs.put("lastDay", df.format(calendar.getTime()));

            return rs;
        }

        int[][] seasons = { { 2, 4 }, { 5, 7 }, { 8, 10 }, { 11, 1 } };
        int cm = calendar.get(Calendar.MONTH) + 1;

        for (int[] im : seasons)
        {
            if (cm >= im[0] && cm <= im[1])
            {
                calendar.set(Calendar.MONTH, im[0] - 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                rs.put("firstDay", df.format(calendar.getTime()));

                calendar.set(Calendar.MONTH, im[1] - 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar
                        .getActualMaximum(Calendar.DAY_OF_MONTH));
                rs.put("lastDay", df.format(calendar.getTime()));

                break;
            }
        }

        return rs;
    }

    public static String getYearString(Date date)
    {
        return DateUtil.date(date, DEFAULT_YEAR_FORMAT);
    }

    public static int getYearInteger(Date date)
    {
        return Integer.parseInt(DateUtil.date(date, DEFAULT_YEAR_FORMAT));
    }

    public static String getMonthString(Date date)
    {
        return DateUtil.date(date, DEFAULT_MONTH_FORMAT);
    }

    public static int getMonthInteger(Date date)
    {
        return Integer.parseInt(DateUtil.date(date, DEFAULT_MONTH_FORMAT));
    }

    public static Date getLastDayOfCurMonth(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, 1);
        // cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date getFirstDayOfCurMonth(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        // cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, 0);
        return cal.getTime();
    }

    public static Date getFirstDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c.getTime();
    }

    public static Date getLastDayOfWeek(Date date)
    {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    }

    public static boolean isValidDate(String ds)
    {
        if (StringUtils.isBlank(ds))
            return false;
        return pattern.matcher(ds).matches();
    }

    public static boolean isValidDate(Date d)
    {
        if (d == null)
            return false;
        return pattern.matcher(date(d, DEFAULT_DATE_FORMAT)).matches();
    }
    
    /**
     * 
     * @return
     */
    public static Date getToday()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.add(Calendar.SECOND, -1);
        return today;
    }
    
    /**
     * 根据生日计算出年龄
     * @param birthday
     * @return
     */
    public static int getAgeByBirthDay(Date birthday)
    {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday))
        {
            throw new IllegalArgumentException("The birthDay is before Now. It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth)
        {
            if (monthNow == monthBirth)
            {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth)
                {
                    age--;
                }
            } else
            {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

}
