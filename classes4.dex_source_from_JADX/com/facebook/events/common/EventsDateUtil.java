package com.facebook.events.common;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.google.common.base.Strings;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: optimistic */
public class EventsDateUtil {
    private static final Date f6045a = new Date(0);
    private static final DateFormat f6046b = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final DateFormat f6047c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    private static final DateFormat f6048d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public static Date m6497a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return f6045a;
        }
        int length = str.length();
        if (length > 19) {
            return m6498a(f6048d, str);
        }
        if (length > 10) {
            return m6498a(f6047c, str);
        }
        return m6498a(f6046b, str);
    }

    private static Date m6498a(DateFormat dateFormat, String str) {
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                dateFormat.parse(str);
            }
            return ((DateFormat) dateFormat.clone()).parse(str);
        } catch (ParseException e) {
            return f6045a;
        }
    }

    public static boolean m6499a(long j) {
        return j > 0;
    }

    public static Date m6500b(long j) {
        return m6499a(j) ? new Date(1000 * j) : f6045a;
    }

    @Nullable
    public static Date m6501c(long j) {
        return m6499a(j) ? new Date(1000 * j) : null;
    }
}
