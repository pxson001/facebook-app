package com.facebook.timeline.cursor;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Preconditions;

/* compiled from: group_feed_model */
public final class TimelineRowIteratorHelper {
    public static String m10506a(String str) {
        return m10507a(str, "");
    }

    public static String m10507a(String str, String str2) {
        Preconditions.checkNotNull(str);
        return StringFormatUtil.formatStrLocaleSafe("%s %s", str, str2);
    }

    public static String m10508b(String str) {
        return str.substring(0, str.indexOf(32));
    }
}
