package com.facebook.components.displaylist;

import android.graphics.Canvas;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: serverAuthCode */
public class DisplayListMarshmallow implements PlatformDisplayList {
    private static Class f2813a;
    private static Class f2814b;
    private static Method f2815c;
    private static Method f2816d;
    private static Method f2817e;
    private static Method f2818f;
    private static Method f2819g;
    private static boolean f2820h = false;
    private static boolean f2821i = false;
    private final Object f2822j;

    private static void m3945a() {
        if (!f2820h && !f2821i) {
            f2813a = Class.forName("android.view.RenderNode");
            f2814b = Class.forName("android.view.DisplayListCanvas");
            f2815c = f2813a.getDeclaredMethod("create", new Class[]{String.class, View.class});
            f2818f = f2814b.getDeclaredMethod("drawRenderNode", new Class[]{f2813a});
            f2816d = f2813a.getDeclaredMethod("start", new Class[]{Integer.TYPE, Integer.TYPE});
            f2817e = f2813a.getDeclaredMethod("end", new Class[]{f2814b});
            f2819g = f2813a.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
            f2820h = true;
        }
    }

    static PlatformDisplayList m3944a(String str) {
        try {
            m3945a();
            if (f2820h) {
                return new DisplayListMarshmallow(f2815c.invoke(null, new Object[]{str, null}));
            }
        } catch (Exception e) {
            f2821i = true;
        }
        return null;
    }

    private DisplayListMarshmallow(Object obj) {
        this.f2822j = obj;
    }

    public final Canvas m3946a(int i, int i2) {
        return (Canvas) Utils.a(f2816d, this.f2822j, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void m3948a(Canvas canvas) {
        Utils.a(f2817e, this.f2822j, new Object[]{canvas});
    }

    public final void m3949b(Canvas canvas) {
        Utils.a(f2818f, canvas, new Object[]{this.f2822j});
    }

    public final void m3947a(int i, int i2, int i3, int i4) {
        Utils.a(f2819g, this.f2822j, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }
}
