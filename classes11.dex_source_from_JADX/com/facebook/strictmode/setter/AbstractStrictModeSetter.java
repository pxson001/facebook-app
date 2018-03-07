package com.facebook.strictmode.setter;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import android.util.Log;
import java.lang.reflect.Field;

/* compiled from: No global redirection_info */
public abstract class AbstractStrictModeSetter implements StrictModeSetter {
    private static final String f12989a = AbstractStrictModeSetter.class.getSimpleName();

    @TargetApi(9)
    public void set() {
        if (VERSION.SDK_INT >= 9 && VERSION.SDK_INT >= 9) {
            ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            boolean a = m13715a(threadPolicy);
            Object a2 = mo366a(new Builder(threadPolicy));
            if (!a && mo367a()) {
                m13708a(a2, "mask", m13706a(m13707a(a2, "mask").intValue(), 16));
            }
            StrictMode.setThreadPolicy(a2);
            VmPolicy vmPolicy = StrictMode.getVmPolicy();
            a = m13717b(vmPolicy);
            a2 = mo368a(m13712a(vmPolicy));
            if (!a && mo369b()) {
                m13708a(a2, "mask", m13706a(m13707a(a2, "mask").intValue(), 16));
            }
            StrictMode.setVmPolicy(a2);
        }
    }

    @TargetApi(9)
    public ThreadPolicy mo366a(Builder builder) {
        return builder.build();
    }

    @TargetApi(9)
    private static VmPolicy.Builder m13710d(VmPolicy vmPolicy) {
        VmPolicy.Builder builder = new VmPolicy.Builder();
        try {
            Class cls = vmPolicy.getClass();
            Class cls2 = builder.getClass();
            Field declaredField = cls.getDeclaredField("mask");
            Field declaredField2 = cls2.getDeclaredField("mMask");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField2.setInt(builder, declaredField.getInt(vmPolicy));
        } catch (Throwable th) {
            Log.e(f12989a, "Failed to inherit existing VmPolicy mask to VmPolicy.Builder.", th);
        }
        return builder;
    }

    @TargetApi(9)
    public final VmPolicy.Builder m13712a(VmPolicy vmPolicy) {
        if (VERSION.SDK_INT >= 11) {
            return new VmPolicy.Builder(vmPolicy);
        }
        if (VERSION.SDK_INT >= 9) {
            return m13710d(vmPolicy);
        }
        throw new IllegalStateException();
    }

    @TargetApi(9)
    public VmPolicy mo368a(VmPolicy.Builder builder) {
        return builder.build();
    }

    public boolean mo367a() {
        return true;
    }

    public boolean mo369b() {
        return true;
    }

    public static Integer m13707a(Object obj, String str) {
        Class cls = obj.getClass();
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return Integer.valueOf(declaredField.getInt(obj));
        } catch (Throwable e) {
            Log.e(f12989a, "Failed to get penalty mask in " + cls.getSimpleName(), e);
            return null;
        }
    }

    public static void m13708a(Object obj, String str, int i) {
        Class cls = obj.getClass();
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.setInt(obj, i);
        } catch (Throwable e) {
            Log.e(f12989a, "Failed to set penalty mask in " + cls.getSimpleName(), e);
        }
    }

    private boolean m13709b(Object obj, String str, int i) {
        Integer a = m13707a(obj, str);
        if (a == null || (a.intValue() & i) == 0) {
            return false;
        }
        return true;
    }

    @TargetApi(9)
    public final boolean m13715a(ThreadPolicy threadPolicy) {
        return m13709b(threadPolicy, "mask", 16);
    }

    @TargetApi(9)
    public final boolean m13717b(VmPolicy vmPolicy) {
        return m13709b(vmPolicy, "mask", 16);
    }

    public static int m13706a(int i, int i2) {
        return (i2 ^ -1) & i;
    }
}
