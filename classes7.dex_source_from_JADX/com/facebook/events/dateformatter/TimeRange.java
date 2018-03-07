package com.facebook.events.dateformatter;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: call_id */
public class TimeRange {
    private final long f17896a;
    private final long f17897b;

    private TimeRange(long j, long j2) {
        this.f17896a = j;
        this.f17897b = j2;
    }

    public static TimeRange m21743a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        Calendar gregorianCalendar = new GregorianCalendar(i, instance.get(2), instance.getActualMinimum(5));
        instance.roll(2, 1);
        return new TimeRange(gregorianCalendar.getTimeInMillis(), new GregorianCalendar(i, instance.get(2), instance.getActualMinimum(5)).getTimeInMillis());
    }

    public static TimeRange m21744b(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int actualMinimum = instance.getActualMinimum(2);
        instance.set(2, actualMinimum);
        Calendar gregorianCalendar = new GregorianCalendar(instance.get(1), actualMinimum, instance.getActualMinimum(5));
        instance.setTimeInMillis(j);
        instance.roll(1, 1);
        actualMinimum = instance.getActualMinimum(2);
        instance.set(2, actualMinimum);
        return new TimeRange(gregorianCalendar.getTimeInMillis(), new GregorianCalendar(instance.get(1), actualMinimum, instance.getActualMinimum(5)).getTimeInMillis());
    }

    public final boolean m21745c(long j) {
        return j >= this.f17896a && j < this.f17897b;
    }
}
