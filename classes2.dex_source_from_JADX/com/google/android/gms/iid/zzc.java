package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Process;
import android.util.Log;

public class zzc {
    static String f3675a = null;
    static int f3676b = 0;
    static int f3677c = 0;
    static int f3678d = 0;

    public static String m5941a(Context context) {
        if (f3675a != null) {
            return f3675a;
        }
        f3676b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    f3677c = applicationInfo.uid;
                    String str = resolveInfo.serviceInfo.packageName;
                    f3675a = str;
                    return str;
                } catch (NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares com.google.android.c2dm.intent.REGISTER" + " without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        PackageItemInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            f3675a = applicationInfo2.packageName;
            f3677c = applicationInfo2.uid;
            return f3675a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f3675a = applicationInfo2.packageName;
                f3677c = applicationInfo2.uid;
                return f3675a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }
}
