package com.facebook.ads.internal.dto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.ads.internal.C1934f;
import com.facebook.ads.internal.util.C1975b;
import com.facebook.ads.internal.util.C1976c;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.ads.internal.util.C1983g.C1982a;

public class C1930f {
    public static final String f14163a = VERSION.RELEASE;
    public static String f14164b = "";
    public static String f14165c = "";
    public static String f14166d = "";
    public static String f14167e = "";
    public static String f14168f = "";
    public static int f14169g = 0;
    public static String f14170h = "";
    public static int f14171i = 0;
    public static String f14172j = "";
    public static int f14173k = 0;
    public static String f14174l = "";
    public static String f14175m = "";
    public static String f14176n = "";
    public static boolean f14177o = false;
    private static boolean f14178p = false;

    public static synchronized void m14342a(Context context) {
        synchronized (C1930f.class) {
            if (!f14178p) {
                f14178p = true;
                C1930f.m14344c(context);
            }
            C1930f.m14345d(context);
        }
    }

    public static void m14343b(Context context) {
        if (f14178p) {
            try {
                C1982a a;
                C1934f a2;
                SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
                if (sharedPreferences.contains("attributionId")) {
                    f14175m = sharedPreferences.getString("attributionId", "");
                }
                if (sharedPreferences.contains("advertisingId")) {
                    f14176n = sharedPreferences.getString("advertisingId", "");
                    f14177o = sharedPreferences.getBoolean("limitAdTracking", f14177o);
                }
                try {
                    a = C1983g.m14456a(context.getContentResolver());
                } catch (Throwable e) {
                    C1976c.m14446a(C1975b.m14443a(e, "Error retrieving attribution id from fb4a"));
                    a = null;
                }
                if (a != null) {
                    String str = a.f14327a;
                    if (str != null) {
                        f14175m = str;
                    }
                }
                try {
                    a2 = C1934f.m14351a(context, a);
                } catch (Throwable e2) {
                    C1976c.m14446a(C1975b.m14443a(e2, "Error retrieving advertising id from Google Play Services"));
                    a2 = null;
                }
                if (a2 != null) {
                    String a3 = a2.m14353a();
                    Boolean valueOf = Boolean.valueOf(a2.m14354b());
                    if (a3 != null) {
                        f14176n = a3;
                        f14177o = valueOf.booleanValue();
                    }
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("attributionId", f14175m);
                edit.putString("advertisingId", f14176n);
                edit.putBoolean("limitAdTracking", f14177o);
                edit.apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static void m14344c(Context context) {
        String networkOperatorName;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            f14166d = packageInfo.packageName;
            f14168f = packageInfo.versionName;
            f14169g = packageInfo.versionCode;
        } catch (NameNotFoundException e) {
        }
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                f14167e = applicationLabel.toString();
            }
        } catch (NameNotFoundException e2) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null && networkOperatorName.length() > 0) {
                f14170h = networkOperatorName;
            }
        }
        networkOperatorName = Build.MANUFACTURER;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f14164b = networkOperatorName;
        }
        networkOperatorName = Build.MODEL;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f14165c = Build.MODEL;
        }
    }

    private static void m14345d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                f14171i = activeNetworkInfo.getType();
                f14172j = activeNetworkInfo.getTypeName();
                f14173k = activeNetworkInfo.getSubtype();
                f14174l = activeNetworkInfo.getSubtypeName();
            }
        } catch (Exception e) {
        }
    }
}
