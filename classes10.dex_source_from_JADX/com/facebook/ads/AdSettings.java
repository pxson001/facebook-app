package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.ads.internal.util.C1983g.C1982a;
import com.facebook.ads.internal.util.C1994r;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdSettings {
    public static volatile boolean f13890a = false;
    public static final String f13891b = AdSettings.class.getSimpleName();
    private static final Collection<String> f13892c = new HashSet();
    private static final Collection<String> f13893d;
    public static String f13894e = null;
    public static boolean f13895f = false;
    private static String f13896g = null;

    static {
        Collection hashSet = new HashSet();
        f13893d = hashSet;
        hashSet.add("sdk");
        f13893d.add("google_sdk");
        f13893d.add("vbox86p");
        f13893d.add("vbox86tp");
    }

    public static boolean m14170a(Context context) {
        if (f13893d.contains(Build.PRODUCT)) {
            return true;
        }
        if (f13896g == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
            String string = sharedPreferences.getString("deviceIdHash", null);
            f13896g = string;
            if (C1994r.m14486a(string)) {
                C1982a a = C1983g.m14456a(context.getContentResolver());
                if (!C1994r.m14486a(a.f14328b)) {
                    f13896g = C1994r.m14487b(a.f14328b);
                } else if (C1994r.m14486a(a.f14327a)) {
                    f13896g = C1994r.m14487b(UUID.randomUUID().toString());
                } else {
                    f13896g = C1994r.m14487b(a.f14327a);
                }
                sharedPreferences.edit().putString("deviceIdHash", f13896g).apply();
            }
        }
        if (f13892c.contains(f13896g)) {
            return true;
        }
        String str = f13896g;
        if (!f13890a) {
            f13890a = true;
            Log.d(f13891b, "Test mode device hash: " + str);
            Log.d(f13891b, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + str + "\");");
        }
        return false;
    }
}
