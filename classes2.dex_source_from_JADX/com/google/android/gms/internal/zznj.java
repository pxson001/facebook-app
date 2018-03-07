package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

public final class zznj {
    private static Pattern f68a = null;

    public static int m175a(int i) {
        return i / 1000;
    }

    public static boolean m176a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
