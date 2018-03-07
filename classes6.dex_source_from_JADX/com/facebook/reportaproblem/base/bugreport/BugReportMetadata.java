package com.facebook.reportaproblem.base.bugreport;

import android.content.Context;

/* compiled from: shipment_tracking_events */
public class BugReportMetadata {
    public static String m7038b(Context context) {
        int i = -1;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
        }
        return i >= 0 ? String.valueOf(i) : "";
    }
}
