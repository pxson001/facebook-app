package com.facebook.wear;

import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: setup */
public class NotificationManagerCompatMethodAutoProvider extends AbstractProvider<NotificationManagerCompat> {
    public static NotificationManagerCompat m2552b(InjectorLike injectorLike) {
        return NotificationManagerCompat.m2553a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return NotificationManagerCompat.m2553a((Context) getInstance(Context.class));
    }

    public static NotificationManagerCompat m2551a(InjectorLike injectorLike) {
        return m2552b(injectorLike);
    }
}
