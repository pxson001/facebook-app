package com.facebook.telephony;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: foreground */
public class FbMultiSimTelephonyManager {
    private Object f23458a = null;
    private Object f23459b = null;
    private boolean f23460c = false;

    @Inject
    public FbMultiSimTelephonyManager(Context context) {
        this.f23460c = m31753a(context);
    }

    public final boolean m31756a() {
        return this.f23460c;
    }

    public final String m31755a(int i) {
        return m31752a("getLine1Number", i);
    }

    public final String m31757b(int i) {
        return m31752a("getIccSerialNumber", i);
    }

    public final String m31758c(int i) {
        return m31752a("getSubscriberId", i);
    }

    @Nullable
    private String m31752a(String str, int i) {
        String str2 = null;
        try {
            Object d = m31754d(i);
            if (d != null) {
                str2 = d.getClass().getDeclaredMethod(str, new Class[0]).invoke(d, new Object[0]).toString();
            }
        } catch (Exception e) {
        }
        return str2;
    }

    private boolean m31753a(Context context) {
        try {
            Class cls = Class.forName("android.telephony.MultiSimTelephonyManager");
            for (Constructor constructor : cls.getConstructors()) {
                if (constructor.getParameterTypes().length == 2) {
                    try {
                        Object newInstance = constructor.newInstance(new Object[]{context, Integer.valueOf(0)});
                        Object newInstance2 = constructor.newInstance(new Object[]{context, Integer.valueOf(1)});
                        Method declaredMethod = cls.getDeclaredMethod("getSubscriberInfo", new Class[0]);
                        declaredMethod.setAccessible(true);
                        this.f23458a = declaredMethod.invoke(newInstance, new Object[0]);
                        this.f23459b = declaredMethod.invoke(newInstance2, new Object[0]);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
            return false;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    private Object m31754d(int i) {
        if (i == 0 || i == 1) {
            return i == 0 ? this.f23458a : this.f23459b;
        } else {
            return null;
        }
    }
}
