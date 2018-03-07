package com.facebook.react.modules.systeminfo;

import android.os.Build;

/* compiled from: friendsSelectorExcluded */
public class AndroidInfoHelpers {
    private static boolean m13775b() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean m13776c() {
        return Build.FINGERPRINT.contains("generic");
    }

    public static String m13774a() {
        if (m13775b()) {
            return "10.0.3.2:8081";
        }
        if (m13776c()) {
            return "10.0.2.2:8081";
        }
        return "localhost:8081";
    }
}
