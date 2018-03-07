package com.facebook.content;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* compiled from: ispx_max_aggregation_bwe_offset_isac */
public final class SecurePendingIntent {
    private static final String f9757a = SecurePendingIntent.class.getSimpleName();

    public static PendingIntent m10162a(Context context, int i, Intent intent, int i2) {
        intent.setPackage(context.getPackageName());
        return PendingIntent.getActivity(context, i, intent, i2);
    }

    public static PendingIntent m10163b(Context context, int i, Intent intent, int i2) {
        intent.setPackage(context.getPackageName());
        return PendingIntent.getBroadcast(context, i, intent, i2);
    }

    public static PendingIntent m10164c(Context context, int i, Intent intent, int i2) {
        intent.setPackage(context.getPackageName());
        return PendingIntent.getService(context, i, intent, i2);
    }
}
