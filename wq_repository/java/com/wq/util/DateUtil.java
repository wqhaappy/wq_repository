package com.wq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 默认日期格式-24小时
	 */
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期格式-12小时
	 */
	public static final String FORMAT_12 = "yyyy-MM-dd hh:mm:ss a";
	/**
	 *1、 日期转字符串
	 * @param date 日期
	 * @return 字符串
	 */
	public static String toString(Date date) {
		//定义一个SimpleDateFormat
		SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
		//日期转换成字符串
		String time =  dateFormat.format(date);
		return time ;
	}
	
	/**
	 * 2、日期转字符串
	 * @param date 日期
	 * @param format 格式
	 * @return 字符串
	 */
	public static String toString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String time =  dateFormat.format(date);
		return time;
	}
	
	/**
	 *3、 字符串转日期
	 * @param dateStr 字符串
	 * @return 日期
	 */
	public static Date toDate(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
		Date date1 = null;
		try {
			 date1 = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
	
	/**
	 * 4、字符串转日期
	 * @param dateStr 字符串
	 * @param format 格式
	 * @return 日期
	 */
	public static Date toDate(String dateStr, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date2 = null;
		try {
			 date2 = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;
	}
	
	/** 
	 * 5、取得当前日期是多少周 
	 * 
	 * @param date 
	 * @return 
	 */ 
	 public static int getWeekOfYear(Date date) { 
		 //定义一个日历类
		 Calendar calendar = Calendar.getInstance();
		//当前是本年中的第几周
		int wod = calendar.get(Calendar.WEEK_OF_YEAR);
		 return wod;
	 }
	 
	 /**
	  * 6、日期相加减天数
	  * @param date 如果为Null，则为当前时间
	  * @param days 加减天数
	  * @return
	  */
	 public static Date dateAdd(Date date, int days){
	 	if (date == null) {
	 		date = new Date();
	 	}
	 	SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
	 	try {
	 		Date date3 = dateFormat.parse(dateFormat.format(date));
	 	} catch (ParseException e) {
	 		e.printStackTrace();
	 	}
	 	//定义一个日历类
	 	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(date);
	 	calendar.add(Calendar.DAY_OF_MONTH, days);
	 	return calendar.getTime();
	 }

	 /** 
	  * 7、时间加减小时
	  * @param startDate 要处理的时间，Null则为当前时间 
	  * @param hours 加减的小时 
	  * @return Date 
	  */  
	 public static Date dateAddHours(Date startDate, int hours) { 
	 	if (startDate == null) {
	 		startDate = new Date();
	 	}
	 	//定义一个日历类
	 	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(startDate);
	 	calendar.add(Calendar.HOUR,calendar.get(Calendar.HOUR)+hours);
	 	return calendar.getTime();
	 }
	
	 /**
	  * 8、时间加减分钟
	  * @param startDate 要处理的时间，Null则为当前时间 
	  * @param minutes 加减的分钟
	  * @return
	  */
	 public static Date dateAddMinutes(Date startDate, int minutes) { 
	 	if (startDate == null) {
	 		startDate = new Date();
	 	}
	 	//日期类
	 	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(startDate);
	 	calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+minutes);
	 	return calendar.getTime();
	 }
	 
	 /**
	  * 9、时间加减秒数
	  * @param startDate 要处理的时间，Null则为当前时间 
	  * @param minutes 加减的秒数
	  * @return
	  */
	 public static Date dateAddSeconds(Date startDate, int seconds) {  
	 	if (startDate == null) {
	 	  startDate = new Date();
	 	}
	 	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(startDate);
	 	calendar.add(Calendar.SECOND, calendar.get(Calendar.SECOND)+seconds);
	 	return calendar.getTime();
	 }
	 
	 /** 
	  * 10、时间加减天数 
	  * @param startDate 要处理的时间，Null则为当前时间 
	  * @param days 加减的天数 
	  * @return Date 
	  */  
	 public static Date dateAddDays(Date startDate, int days) {  
	 	if (startDate == null) {
	 		startDate = new Date();
	 	}
	 	Calendar calendar = Calendar.getInstance();
	 	calendar.setTime(startDate);
	 	calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+days );
	 	return calendar.getTime();
	 }
	 
	 /** 
	  * 11、时间比较（如果myDate>compareDate返回1，<返回-1，相等返回0） 
	  * @param myDate 时间 
	  * @param compareDate 要比较的时间 
	  * @return int 
	  */  
	 public static int dateCompare(Date myDate, Date compareDate) {  
	 	Calendar mycal = Calendar.getInstance();
	 	Calendar comcal = Calendar.getInstance();
	 	mycal.setTime(myDate);
	 	comcal.setTime(compareDate);
	 	return mycal.compareTo(comcal);
	 }

}
