package com.facebook.react.uimanager;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* compiled from: friend_finder_send_invite */
public class DisplayMetricsHolder {
    @Nullable
    public static DisplayMetrics f11710a;
    @Nullable
    private static DisplayMetrics f11711b;

    private static void m13807a(DisplayMetrics displayMetrics) {
        f11710a = displayMetrics;
    }

    public static void m13806a(Context context) {
        Throwable e;
        if (m13808b() == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            m13807a(displayMetrics);
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(displayMetrics);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Assertions.a(windowManager, "WindowManager is null!");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics2);
            } else {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    displayMetrics2.widthPixels = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    displayMetrics2.heightPixels = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                } catch (InvocationTargetException e2) {
                    e = e2;
                    throw new RuntimeException("Error getting real dimensions for API level < 17", e);
                } catch (IllegalAccessException e3) {
                    e = e3;
                    throw new RuntimeException("Error getting real dimensions for API level < 17", e);
                } catch (NoSuchMethodException e4) {
                    e = e4;
                    throw new RuntimeException("Error getting real dimensions for API level < 17", e);
                }
            }
            m13809b(displayMetrics2);
        }
    }

    @Deprecated
    public static DisplayMetrics m13805a() {
        return f11710a;
    }

    private static void m13809b(DisplayMetrics displayMetrics) {
        f11711b = displayMetrics;
    }

    public static DisplayMetrics m13808b() {
        return f11711b;
    }
}
