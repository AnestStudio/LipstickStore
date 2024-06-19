package org.anest.mystore.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    public static Date getCurrentDateTime() {
        return new Date();
    }

    public static int getCurrentDate() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    public static int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
