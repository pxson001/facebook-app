package com.facebook.events.ui.date.util;

import android.text.format.Time;

/* compiled from: applicationId */
public class QuickEventTimeUtils {
    public static Time m19632a(Time time, int i, int i2) {
        Time time2 = new Time(time);
        time2.set(0, i2, i, time.monthDay, time.month, time.year);
        return time2;
    }
}
