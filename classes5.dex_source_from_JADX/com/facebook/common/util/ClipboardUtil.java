package com.facebook.common.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import javax.annotation.Nullable;

/* compiled from: shipdate_for_display */
public class ClipboardUtil {
    public static void m3893a(Context context, String str) {
        m3894a(context, str, null);
    }

    private static void m3894a(Context context, String str, @Nullable String str2) {
        if (VERSION.SDK_INT >= 11) {
            if (StringUtil.a(str2)) {
                str2 = m3892a(context);
            }
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str2, str));
            return;
        }
        ((android.text.ClipboardManager) context.getSystemService("clipboard")).setText(str);
    }

    private static String m3892a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        if (packageManager != null) {
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            } catch (NameNotFoundException e) {
            }
        }
        return String.valueOf(applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : context.getString(17039375));
    }
}
