package edu.aku.hassannaqvi.nns_2018.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by gul.sanober on 3/21/2018.
 */

public class DateUtils {

    public static Calendar getCalendarDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static Calendar getCalendarDate(String dd, String mm, String yy) {

        String dob = String.format("%02d", Integer.valueOf(dd)) + "-"
                + String.format("%02d", Integer.valueOf(mm))
                + "-" + yy;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(dob);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static Calendar getCalendarDate(String mm, String yy) {

        String dob = String.format("%02d", Integer.valueOf("01")) + "-"
                + String.format("%02d", Integer.valueOf(mm))
                + "-" + yy;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(dob);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }



    public static long ageInYearByDOB(String year) {
        Calendar cal = Calendar.getInstance();
        long yearofbirth = Integer.valueOf(year);
        Long ageInYears = cal.get(Calendar.YEAR) - yearofbirth;
        //long ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365;
        return ageInYears;
    }

    public static long ageInYearByDOB(Calendar cal) {
        Date dob = cal.getTime();
        Date today = new Date();
        Long diff = today.getTime() - dob.getTime();
        double ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365.25;
        long age = (long) Math.ceil(ageInYears);
        return age;
    }

    public static long ageInMonthsByDOB(Calendar cal) {
        Date dob = cal.getTime();
        Date today = new Date();
        Long diff = today.getTime() - dob.getTime();
        double ageInMonths = (diff / (24 * 60 * 60 * 1000)) / 30.4375;
        long age = (long) Math.floor(ageInMonths);
        return age;
    }

    public static int getCurrentYear() {
        Date date = new Date(); // Current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //int year = cal.get(Calendar.YEAR);

        return cal.get(Calendar.YEAR);
    }

    public static int getCurrentMonth() {
        Date date = new Date(); // Current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //int year = cal.get(Calendar.MONTH);

        return cal.get(Calendar.MONTH);
    }

    public static int getCurrentDate() {
        Date date = new Date(); // Current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //int year = cal.get(Calendar.DAY_OF_MONTH);

        return cal.get(Calendar.DAY_OF_MONTH);
    }


}
