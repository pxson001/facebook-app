package com.facebook.backstage.util;

import com.facebook.common.locale.Locales;
import java.util.Calendar;

/* compiled from: removeAdminsFromGroup */
public class LocaleTimeUtil {
    public static int f5583a = -1;

    public static long m5777a(Locales locales, long j) {
        return ((long) Calendar.getInstance(locales.a()).getTimeZone().getRawOffset()) - j;
    }

    public static String m5778a(long j) {
        long j2 = j / 3600000;
        long j3 = (j / 60000) % 60;
        long j4 = (j / 1000) % 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (j2 > 0) {
            stringBuilder.append(j2 + ":" + (j3 < 10 ? "0" : ""));
        }
        stringBuilder.append(j3 + ":" + (j4 < 10 ? "0" : "") + j4);
        return stringBuilder.toString();
    }
}
