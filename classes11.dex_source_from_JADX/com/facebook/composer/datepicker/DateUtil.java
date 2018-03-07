package com.facebook.composer.datepicker;

import com.facebook.uicontrib.datepicker.Date;
import java.util.Calendar;

/* compiled from: handler_complete */
public class DateUtil {
    public static boolean m7797a(Date date) {
        if (date == null) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        if (date.a() != instance.get(1)) {
            return false;
        }
        if (date.b() == null || date.b().intValue() != instance.get(2) + 1) {
            return false;
        }
        if (date.c() == null || date.c().intValue() != instance.get(5)) {
            return false;
        }
        return true;
    }
}
