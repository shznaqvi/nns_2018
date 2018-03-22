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

    /*public static Calendar getCalendarDate(String mm, String yy) {
        String value = "01-"+mm+"-"+yy;
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
    }*/

    public static long ageInYearByDOB(String year) {
        //Calendar cal = getCalendarDate(year);
        long yearofbirth = Integer.valueOf(year);
        //Date dob = cal.gety;
        Date today = new Date();
        Long diff = today.getYear() - yearofbirth;
        long ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365;
        return ageInYears;
    }

    public static long ageInYearByDOB(Calendar cal) {
        //Calendar cal = getCalendarDate(year);
        //long yearofbirth = Integer.valueOf(year);
        Date dob = cal.getTime();
        Date today = new Date();
        Long diff = today.getYear() - dob.getTime();
        long ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365;
        return ageInYears;
    }


}
