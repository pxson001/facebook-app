package com.facebook.hiddenmethods.support.v4;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: durationUs */
public final class NotificationHiddenMethods {
    private static final Method f4917a;

    static {
        Method method;
        try {
            method = Notification.class.getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
        } catch (NoSuchMethodException e) {
            method = null;
        }
        f4917a = method;
    }

    public static void m9855a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        Throwable e;
        if (f4917a == null) {
            throw new RuntimeException("Notification.getMethod not found");
        }
        try {
            f4917a.invoke(notification, new Object[]{context, charSequence, charSequence2, pendingIntent});
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }
}
