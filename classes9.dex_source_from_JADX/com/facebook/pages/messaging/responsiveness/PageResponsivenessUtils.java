package com.facebook.pages.messaging.responsiveness;

import android.content.Context;

/* compiled from: cc_credential */
public class PageResponsivenessUtils {
    private PageResponsivenessUtils() {
    }

    public static String m18432a(Context context, PageResponseTimespan pageResponseTimespan, boolean z) {
        if (z) {
            return context.getString(2131241125);
        }
        switch (pageResponseTimespan) {
            case MINUTES:
                return context.getString(2131241126);
            case ONE_HOUR:
                return context.getString(2131241127);
            case FEW_HOURS:
                return context.getString(2131241128);
            case ONE_DAY:
                return context.getString(2131241129);
            case NONE:
                return context.getString(2131241130);
            default:
                return "";
        }
    }
}
