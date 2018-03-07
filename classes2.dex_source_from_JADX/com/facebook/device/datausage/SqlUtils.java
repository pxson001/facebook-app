package com.facebook.device.datausage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: liger */
public class SqlUtils {
    public static String m24789a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(date);
    }

    public static Date m24790a(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str);
    }
}
