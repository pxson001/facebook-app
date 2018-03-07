package com.facebook.components.displaylist;

import android.graphics.Canvas;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: serverAuthRequested */
public class DisplayListLollipop implements PlatformDisplayList {
    private static Class f2803a;
    private static Class f2804b;
    private static Method f2805c;
    private static Method f2806d;
    private static Method f2807e;
    private static Method f2808f;
    private static Method f2809g;
    private static boolean f2810h = false;
    private static boolean f2811i = false;
    private final Object f2812j;

    private static void m3939a() {
        if (!f2810h && !f2811i) {
            f2803a = Class.forName("android.view.RenderNode");
            f2804b = Class.forName("android.view.HardwareCanvas");
            f2805c = f2803a.getDeclaredMethod("create", new Class[]{String.class, View.class});
            f2808f = f2804b.getDeclaredMethod("drawRenderNode", new Class[]{f2803a});
            f2806d = f2803a.getDeclaredMethod("start", new Class[]{Integer.TYPE, Integer.TYPE});
            f2807e = f2803a.getDeclaredMethod("end", new Class[]{f2804b});
            f2809g = f2803a.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
            f2810h = true;
        }
    }

    static PlatformDisplayList m3938a(String str) {
        try {
            m3939a();
            if (f2810h) {
                return new DisplayListLollipop(f2805c.invoke(null, new Object[]{str, null}));
            }
        } catch (Exception e) {
            f2811i = true;
        }
        return null;
    }

    private DisplayListLollipop(Object obj) {
        this.f2812j = obj;
    }

    public final Canvas m3940a(int i, int i2) {
        return (Canvas) Utils.a(f2806d, this.f2812j, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void m3942a(Canvas canvas) {
        Utils.a(f2807e, this.f2812j, new Object[]{canvas});
    }

    public final void m3943b(Canvas canvas) {
        Utils.a(f2808f, canvas, new Object[]{this.f2812j});
    }

    public final void m3941a(int i, int i2, int i3, int i4) {
        Utils.a(f2809g, this.f2812j, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }
}
