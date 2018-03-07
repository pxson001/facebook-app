package com.facebook.video.player;

import com.facebook.common.stringformat.StringFormatUtil;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: composer_friend_tagger */
public class Utils {
    public static String m28005a(long j) {
        Appendable stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder, Locale.getDefault());
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        j2 /= 3600;
        stringBuilder.setLength(0);
        if (j2 > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j3)}).toString();
        }
        return formatter.format("%d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3)}).toString();
    }

    public static String m28006b(long j) {
        if (j < 1048576) {
            return StringFormatUtil.formatStrLocaleSafe("%.1f KB", Double.valueOf(((double) j) / 1024.0d));
        }
        return StringFormatUtil.formatStrLocaleSafe("%.1f MB", Double.valueOf((((double) j) / 1024.0d) / 1024.0d));
    }
}
