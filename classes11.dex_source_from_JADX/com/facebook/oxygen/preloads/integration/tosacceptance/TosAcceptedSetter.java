package com.facebook.oxygen.preloads.integration.tosacceptance;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.oxygen.preloads.sdk.firstparty.settings.FirstPartySettings;

/* compiled from: textDecorationLine */
public class TosAcceptedSetter {
    public static void m1421a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        ContentResolver contentResolver = context.getContentResolver();
        ComponentName componentName = new ComponentName(context, TosAcceptedFlagComponent.class);
        if (packageManager.getComponentEnabledSetting(componentName) != 1) {
            FirstPartySettings.m1425a(contentResolver, packageName, true);
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }
}
