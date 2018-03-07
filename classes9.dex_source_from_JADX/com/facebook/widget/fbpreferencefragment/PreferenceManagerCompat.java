package com.facebook.widget.fbpreferencefragment;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.facebook.debug.log.BLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: android.intent.action.INSTALL_PACKAGE */
public class PreferenceManagerCompat {
    private static final String f20531a = PreferenceManagerCompat.class.getSimpleName();

    static PreferenceManager m20075a(Context context) {
        try {
            Constructor declaredConstructor = PreferenceManager.class.getDeclaredConstructor(new Class[]{Context.class});
            declaredConstructor.setAccessible(true);
            return (PreferenceManager) declaredConstructor.newInstance(new Object[]{context});
        } catch (Throwable e) {
            BLog.a(f20531a, "Couldn't call constructor PreferenceManager by reflection", e);
            return null;
        }
    }

    static PreferenceScreen m20076a(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("getPreferenceScreen", new Class[0]);
            declaredMethod.setAccessible(true);
            return (PreferenceScreen) declaredMethod.invoke(preferenceManager, new Object[0]);
        } catch (Throwable e) {
            BLog.a(f20531a, "Couldn't call PreferenceManager.getPreferenceScreen by reflection", e);
            return null;
        }
    }

    static void m20077a(PreferenceManager preferenceManager, int i, int i2, Intent intent) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
        } catch (Throwable e) {
            BLog.a(f20531a, "Couldn't call PreferenceManager.dispatchActivityResult by reflection", e);
        }
    }

    static void m20078b(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityStop", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, new Object[0]);
        } catch (Throwable e) {
            BLog.a(f20531a, "Couldn't call PreferenceManager.dispatchActivityStop by reflection", e);
        }
    }

    static void m20079c(PreferenceManager preferenceManager) {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityDestroy", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, new Object[0]);
        } catch (Throwable e) {
            BLog.a(f20531a, "Couldn't call PreferenceManager.dispatchActivityDestroy by reflection", e);
        }
    }
}
