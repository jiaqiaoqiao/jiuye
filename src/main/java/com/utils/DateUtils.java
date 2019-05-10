package com.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ����ת������
 * @author Administrator
 *
 */
public class DateUtils {
	/**
     * ��������תΪyyyy-MM-dd 23:01:59��ʽ
     *
     * @param date
     * @return
     */
    public static String date2StringHHmmss(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } else {
            return "";
        }
    }
    
	/**
     * ��������תΪyyyyMMdd23:01:59��ʽ�������ո�,ʱ�䲻��ð��
     *
     * @param date
     * @return
     */
    public static String date2StringHHmmss2(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sdf.format(date);
        } else {
            return "";
        }
    }
    
    /**
     * ��yyyy-MM-dd 23:01:59 ���͵��ַ���תΪ����
     *
     * @param dateStr
     * @return
     */
    public static Date stringHHmmss2Date(String dateStr) {
        if (dateStr != null && !"".equals(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(dateStr);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }
    /**
     * ��������תΪyyyy-MM-dd��ʽ
     *
     * @param date
     * @return
     */
    public static String date2String(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        } else {
            return "";
        }
    }
    /**
     * ��������תΪMM-yy��ʽ
     *
     * @param date
     * @return
     */
    public static String date2StringMMyy(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
            return sdf.format(date);
        } else {
            return "";
        }
    }
    /**
     * �����ڶ���תΪ���ĵ��ַ���ʽ
     * @param date
     * @return
     */
    public static String date2ChineseString(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
            return sdf.format(date);
        } else {
            return "";
        }
    }
    /**
     * ������תΪyyyyMM����ʽ
     * @param date
     * @return
     */
    public static String date2String1(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            return sdf.format(date);
        } else {
            return "";
        }
    }
    /**
     * ��yyyy-MM-dd ���͵��ַ���תΪ����
     *
     * @param dateStr
     * @return
     */
    public static Date string2Date(String dateStr) {
        if (dateStr != null && !"".equals(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
            try {
                return sdf.parse(dateStr);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }
    
    public static Date string2Date2(String dateStr) {
        if (dateStr != null && !"".equals(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return sdf.parse(dateStr);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }
    
    /**
     * ��yyyy-MM-dd ���͵��ַ���תΪ����
     *
     * @param dateStr
     * @return
     */
    public static Date string2Date1(String dateStr) {
        if (dateStr != null && !"".equals(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            try {
                return sdf.parse(dateStr);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }

   
    
    /**
     * ����15��16ԭ�򷵻�����
     * @param date
     * @return
     */
    public static Map date2YM(String dateStr){
    	Map dateMap = new HashMap();
    	if(dateStr != null){
    		Date date = string2Date(dateStr);
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(date);
    		int year1 = calendar.get(Calendar.YEAR);
      		int month1 = calendar.get(Calendar.MONTH )+1;
      		int day1 = calendar.get(Calendar.DAY_OF_MONTH );
      		int year2 = 0;
      		int month2 = 0;
      		//year2�������
      		if((month1+1)>12 && day1>15){year2=year1+1;}else{year2=year1;}
      		//month2�������
      		if(day1<=15){month2=month1;}
      		else{
      			if((month1+1)<=12){month2=month1+1;}
      			else{month2=month1+1-12;}
      		}
      		dateMap.put("year", year2+"");
    		dateMap.put("month", month2+"");
    		return dateMap;
    	}else{
    		dateMap.put("year", "");
    		dateMap.put("month", "");
    		return dateMap;
    	}
    }
    
  
    /**
     * ȡ���������ڼ��ʱ��
     * @param d1
     * @param d2
     * @return
     */
    public static int getDaysBetween (Calendar d1, Calendar d2) {
        if (d1.after(d2)) {  // swap dates so that d1 is start and d2 is end
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) -
                   d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    } 

    
    /**
     * ��ʽ������Ϊ*��*��*��
     * @param dateStr
     * @return
     */
    public static String string2String(String dateStr) throws Exception{
        if (dateStr != null && !"".equals(dateStr)) {
        	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
            Date date = sdf.parse(dateStr);
            String dateString = dateFormat.format(date);
            return dateString;
        } else {
            return "";
        }
    }
  
    /**
     * ��ָ������תΪ��������һ�룬��23:59:59��
     * @param d
     * @return
     */
    public static Date get24Time(Date d){
    	if(d==null){
    		return d;
    	}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		return calendar.getTime();
    }
    /**
     * ��ָ������תΪ�����ָ��ʱ����
     * @param d
     * @return
     */
    public static Date get24Time(Date d,String HHmmss){
    	if(d==null){
    		return d;
    	}
    	String string=DateUtils.date2String(d)+" "+HHmmss;
    	
    	return DateUtils.stringHHmmss2Date(string);
    }
    /**
     * ��ǰʱ������������ʱ��
     * @param date
     * @param days
     * @return
     */
    public static Date getAddDate(Date date,int days){
      if(date==null){
        return null;
      }
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      c.add(Calendar.DAY_OF_YEAR,days);
      return c.getTime();
    }
    
   
    /**
     * ȡ�õ�ǰ���
     * @return
     */
    public static int getCurrentYear(){
    	Calendar calendar = Calendar.getInstance();
    	return calendar.get(Calendar.YEAR);
    }
    /**
     * ȡ�õ�ǰ��
     * @return
     */
    public static int getCurrentMonth(){
    	Calendar calendar = Calendar.getInstance();
    	return calendar.get(Calendar.MONTH)+1;
    }
    
    /**ȡ��ָ�����ڵ�ǰamount��ͺ�amount����ɵ����List
     * @param date
     * @param amount
     * @return ���List����amountΪ0���򷵻ص�Listֻ����һ�����󣬼�date��ʾ����ȣ���amountС��0���򷵻ؿ�List
     */
    public static List getRecentYear(Date date,int amount) {
    	List list = new ArrayList();
        if (date == null) {
        	date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(date);
        int y = Long.valueOf(year).intValue();
        int all = amount*2+1;
        for(int i=0;i<all;i++,amount--){
        	int entry = y - amount;
        	list.add(entry);
        }
        
        return list;
    }
    
    public static void main(String args[]) throws Exception{
    	getRecentYear(null,0);
    }
}
