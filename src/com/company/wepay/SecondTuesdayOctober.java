package com.company.wepay;

import java.util.Calendar;
import java.util.Date;

public class SecondTuesdayOctober {

    public static void main(String[] args) {
        Date day = secondTuesday(2000);
        return;
    }

    public static Date secondTuesday(int year){
        int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"Friday",  "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int days = years(year);
        if(isLeap(year))
            m[1] = 29;
        for(int i=0; i<9; i++){
            days+=m[i];
        }

        int tuesdays = 0;

        int date =1;
        while(tuesdays<2){
            if(days%7 == 4) {
                tuesdays++;
                if(tuesdays == 2)
                    break;
            }
            days++;
            date++;
        }
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, date);
        return cal.getTime();


    }

    private static int years(int year) {
        int days = 0;
        for(int i= 1971; i<year; i++){
            if(isLeap(i)) {
                days+=366;
            } else {
                days+=365;
            }
        }
        return days;
    }

    public static boolean isLeap(int year){
        if(year%4!=0)
            return false;
        else if(year%100!=0)
            return true;
        else if(year%400!=0)
            return false;
        return true;
    }

}
