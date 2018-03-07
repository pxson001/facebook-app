package com.facebook.analytics.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.system.ErrnoException;
import com.facebook.debug.log.BLog;
import java.lang.reflect.Field;
import javax.annotation.Nullable;

/* compiled from: throwback_card */
public class ErrnoExtractor {
    private static final String f1938a = ErrnoExtractor.class.getSimpleName();
    private static boolean f1939b;
    private static Class f1940c;
    private static Field f1941d;

    private ErrnoExtractor() {
    }

    public static int m2617a(@Nullable Throwable th) {
        if (th == null) {
            return -1;
        }
        if (VERSION.SDK_INT >= 21) {
            return m2619b(th);
        }
        return m2620c(th);
    }

    @TargetApi(21)
    private static int m2619b(Throwable th) {
        if (th instanceof ErrnoException) {
            return ((ErrnoException) th).errno;
        }
        return -1;
    }

    private static void m2618a() {
        if (!f1939b) {
            synchronized (ErrnoExtractor.class) {
                if (!f1939b) {
                    f1939b = true;
                    try {
                        Class cls = Class.forName("libcore.io.ErrnoException");
                        Field declaredField = cls.getDeclaredField("errno");
                        f1940c = cls;
                        f1941d = declaredField;
                    } catch (Throwable e) {
                        BLog.b(f1938a, "Error loading errno exception class", e);
                    }
                }
            }
        }
    }

    private static int m2620c(Throwable th) {
        int i = -1;
        m2618a();
        if (f1940c != null && th.getClass().equals(f1940c)) {
            try {
                i = f1941d.getInt(th);
            } catch (Throwable e) {
                BLog.b(f1938a, "Error accessing errno field", e);
            }
        }
        return i;
    }
}
