package com.facebook.analytics.event;

import java.text.NumberFormat;
import java.util.Locale;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: threadId */
public class HoneyProtocolUtils {
    private static final NumberFormat f1191a;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        f1191a = instance;
        instance.setGroupingUsed(false);
        f1191a.setMaximumFractionDigits(3);
    }

    public static synchronized String m1450a(long j) {
        String format;
        synchronized (HoneyProtocolUtils.class) {
            format = f1191a.format(((double) j) / 1000.0d);
        }
        return format;
    }
}
