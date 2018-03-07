package com.facebook.react.uimanager.events;

import android.util.SparseIntArray;

/* compiled from: footerButtonId */
public class TouchEventCoalescingKeyHelper {
    private static final SparseIntArray f11914a = new SparseIntArray();

    public static void m14171a(long j) {
        f11914a.put((int) j, 0);
    }

    public static void m14172b(long j) {
        int i = f11914a.get((int) j, -1);
        if (i == -1) {
            throw new RuntimeException("Tried to increment non-existent cookie");
        }
        f11914a.put((int) j, i + 1);
    }

    public static short m14173c(long j) {
        int i = f11914a.get((int) j, -1);
        if (i != -1) {
            return (short) (i & 65535);
        }
        throw new RuntimeException("Tried to get non-existent cookie");
    }

    public static void m14174d(long j) {
        f11914a.delete((int) j);
    }

    public static boolean m14175e(long j) {
        if (f11914a.get((int) j, -1) == -1) {
            return false;
        }
        return true;
    }
}
