package com.facebook.common.util;

import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Locale;

/* compiled from: scheduler_action */
public class LocaleUtil {
    public static Locale m31239a(String str) {
        Iterable a;
        List a2 = StringUtil.m3587a(str, '_');
        if (a2.size() == 1) {
            a = StringUtil.m3587a(str, '-');
        } else {
            Object obj = a2;
        }
        return new Locale((String) Iterables.m950a(a, (Object) ""), (String) Iterables.m948a(a, 1, (Object) ""), (String) Iterables.m948a(a, 2, (Object) ""));
    }

    public static String m31238a(Locale locale) {
        String displayName = locale.getDisplayName(locale);
        if (locale.toString().equals("fb")) {
            displayName = "FB Hash";
        }
        return StringUtil.m3598c(displayName);
    }
}
