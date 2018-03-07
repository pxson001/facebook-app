package com.facebook.messaging.sms.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.SmsManager;
import com.facebook.debug.log.BLog;
import java.lang.reflect.Method;

/* compiled from: com.facebook.messaging.sms.MMS_DOWNLOADED */
public class TelephonyUtils {
    public static boolean m17717a() {
        return VERSION.SDK_INT >= 22;
    }

    @TargetApi(22)
    public static int m17716a(int i) {
        int defaultSmsSubscriptionId;
        if (m17717a() && i == -1) {
            defaultSmsSubscriptionId = SmsManager.getDefaultSmsSubscriptionId();
        } else {
            defaultSmsSubscriptionId = i;
        }
        if (defaultSmsSubscriptionId < 0) {
            return -1;
        }
        return defaultSmsSubscriptionId;
    }

    public static boolean m17718c(Context context) {
        if (m17719d(context)) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            Method declaredMethod = connectivityManager.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable e) {
            BLog.c("TelephonyUtils", "TelephonyManager.getMobileDataEnabled failed", e);
            return false;
        }
    }

    public static boolean m17719d(Context context) {
        return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }
}
