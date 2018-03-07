package com.facebook.crudolib.appmanifestinfo;

import android.content.Context;
import android.content.pm.PackageInfo;

/* compiled from: TreehouseTTPogsHot */
public final class ApplicationManifestHelper {
    private static volatile int f23966a = 0;
    private static volatile String f23967b = "Unknown";
    public static volatile int f23968c = 0;
    private static volatile boolean f23969d;

    private ApplicationManifestHelper() {
    }

    public static void m25917b(Context context) {
        int i = 0;
        if (!f23969d) {
            try {
                int i2;
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                } else {
                    i2 = 0;
                }
                f23966a = i2;
                f23967b = packageInfo != null ? packageInfo.versionName : "Unknown";
                if (packageInfo != null) {
                    i = packageInfo.applicationInfo.targetSdkVersion;
                }
                f23968c = i;
                f23969d = true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }
}
