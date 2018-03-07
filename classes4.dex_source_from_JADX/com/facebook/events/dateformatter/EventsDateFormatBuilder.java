package com.facebook.events.dateformatter;

import android.os.Build.VERSION;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: option_type */
public class EventsDateFormatBuilder {
    public static String f6019a = "cccc";
    public static String f6020b = "ccc";
    public static String f6021c = "LLLL";

    EventsDateFormatBuilder() {
    }

    static void m6488a(String str, String str2, String str3) {
        f6020b = str;
        f6019a = str2;
        f6021c = str3;
    }

    static DateFormat m6487a(Locale locale, TimeZone timeZone) {
        DateFormat dateInstance;
        if (VERSION.SDK_INT < 18) {
            dateInstance = SimpleDateFormat.getDateInstance(2, locale);
        } else {
            DateFormat simpleDateFormat = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(locale, "EEEMMMd"), locale);
            simpleDateFormat.setTimeZone(timeZone);
            dateInstance = simpleDateFormat;
        }
        dateInstance.setTimeZone(timeZone);
        return dateInstance;
    }
}
