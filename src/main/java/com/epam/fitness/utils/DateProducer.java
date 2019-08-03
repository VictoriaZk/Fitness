package com.epam.fitness.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Designed to define a new date
 */
public class DateProducer {
    /**
     * Get necessary date date.
     *
     * @param dateToAdd       the date to add
     * @param periodExtension the period extension
     * @return the date
     */
    public static  Date getNecessaryDate(Date dateToAdd, Integer periodExtension){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateToAdd);
        calendar.add(Calendar.DAY_OF_YEAR,periodExtension);
        dateToAdd = calendar.getTime();
        return new java.sql.Date(dateToAdd.getTime());
    }
}
