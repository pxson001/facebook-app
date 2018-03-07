package com.facebook.events.dateformatter;

import com.google.common.annotations.VisibleForTesting;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* compiled from: cameraFlipped */
public class EventsBirthdayTimeFormatUtil {
    public static Calendar m21732a(Date date, TimeZone timeZone, int i, int i2) {
        return m21733a(date, timeZone, i, i2, false);
    }

    public static Calendar m21733a(Date date, TimeZone timeZone, int i, int i2, boolean z) {
        Calendar gregorianCalendar = new GregorianCalendar(timeZone);
        gregorianCalendar.setTimeInMillis(date.getTime());
        Calendar gregorianCalendar2 = new GregorianCalendar(timeZone);
        int i3 = gregorianCalendar2.get(1);
        Object obj = 1;
        int i4 = i2 - 1;
        int i5 = gregorianCalendar.get(2);
        if (i5 <= i4) {
            if (i5 < i4) {
                obj = null;
            } else if (gregorianCalendar.get(5) <= i) {
                obj = null;
            }
        }
        if (!(obj == null || z)) {
            i3++;
        }
        gregorianCalendar2.setTime(new Date(0));
        gregorianCalendar2.set(i3, i2 - 1, i);
        return gregorianCalendar2;
    }

    @VisibleForTesting
    public static boolean m21735a(Calendar calendar, Calendar calendar2) {
        return m21736a(calendar, calendar2, 14);
    }

    public static boolean m21736a(Calendar calendar, Calendar calendar2, int i) {
        m21734a(calendar);
        m21734a(calendar2);
        calendar2.set(1, calendar.get(1));
        if (calendar2.before(calendar)) {
            return m21738b(calendar, calendar2, i);
        }
        calendar2.roll(1, -1);
        return m21738b(calendar, calendar2, i);
    }

    private static boolean m21738b(Calendar calendar, Calendar calendar2, int i) {
        long timeInMillis = calendar.getTimeInMillis() - calendar2.getTimeInMillis();
        return timeInMillis > 0 && timeInMillis <= TimeUnit.DAYS.toMillis((long) i);
    }

    private static void m21734a(Calendar calendar) {
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public static boolean m21737a(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date2);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (instance2.get(1) == instance.get(1) && instance2.get(2) == instance.get(2)) {
            return true;
        }
        return false;
    }
}
