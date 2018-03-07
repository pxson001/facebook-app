package com.facebook.common.jobscheduler.compat;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: no-store */
public class DisabledServiceWorkaround {
    public static void m7416a(Context context, ComponentName componentName, IllegalArgumentException illegalArgumentException) {
        int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(componentName);
        if (componentEnabledSetting == 1 || componentEnabledSetting == 0) {
            throw illegalArgumentException;
        }
        new Object[1][0] = componentName;
    }
}
