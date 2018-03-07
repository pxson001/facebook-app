package com.facebook.components.displaylist;

import android.app.Activity;
import android.graphics.Canvas;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: db */
class DisplayListICS implements PlatformDisplayList {
    private static Class f14198a;
    private static Class f14199b;
    private static Class f14200c;
    private static Class f14201d;
    private static Method f14202e;
    private static Method f14203f;
    private static Method f14204g;
    private static Method f14205h;
    private static Method f14206i;
    private static Method f14207j;
    private static Method f14208k;
    private static Field f14209l;
    private static Field f14210m;
    private static boolean f14211n = false;
    private static boolean f14212o = false;
    private final Object f14213p;

    private static void m15015a() {
        if (!f14211n && !f14212o) {
            f14198a = Class.forName("android.view.View$AttachInfo");
            f14199b = Class.forName("android.view.HardwareCanvas");
            f14200c = Class.forName("android.view.DisplayList");
            Class cls = Class.forName("android.view.HardwareRenderer");
            f14201d = cls;
            f14202e = cls.getDeclaredMethod("createDisplayList", new Class[]{String.class});
            f14207j = f14200c.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
            f14203f = f14200c.getDeclaredMethod("start", new Class[]{Integer.TYPE, Integer.TYPE});
            f14204g = f14200c.getDeclaredMethod("end", null);
            f14205h = f14200c.getDeclaredMethod("clear", null);
            f14206i = f14199b.getDeclaredMethod("drawDisplayList", new Class[]{f14200c});
            Method declaredMethod = f14199b.getDeclaredMethod("outputDisplayList", new Class[]{f14200c});
            f14208k = declaredMethod;
            declaredMethod.setAccessible(true);
            Field declaredField = f14198a.getDeclaredField("mHardwareRenderer");
            f14209l = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = View.class.getDeclaredField("mAttachInfo");
            f14210m = declaredField2;
            declaredField2.setAccessible(true);
            f14211n = true;
        }
    }

    static PlatformDisplayList m15014a(Activity activity, String str) {
        View decorView = activity.getWindow().getDecorView();
        try {
            m15015a();
            if (f14211n) {
                Object obj = f14209l.get(f14210m.get(decorView));
                return new DisplayListICS(f14202e.invoke(obj, new Object[]{str}));
            }
        } catch (Exception e) {
            f14212o = true;
        }
        return null;
    }

    private DisplayListICS(Object obj) {
        this.f14213p = obj;
    }

    public final Canvas mo1014a(int i, int i2) {
        return (Canvas) Utils.m15024a(f14203f, this.f14213p, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void mo1016a(Canvas canvas) {
        Utils.m15024a(f14204g, this.f14213p, new Object[0]);
    }

    public final void mo1017b(Canvas canvas) {
        Utils.m15024a(f14206i, canvas, this.f14213p);
    }

    public final void mo1015a(int i, int i2, int i3, int i4) {
        Utils.m15024a(f14207j, this.f14213p, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
