package com.facebook.common.android;

import android.app.NotificationManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: mUiLock */
public class NotificationManagerMethodAutoProvider extends AbstractProvider<NotificationManager> {
    public static NotificationManager m8723b(InjectorLike injectorLike) {
        return AndroidModule.h((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.h((Context) getInstance(Context.class));
    }

    public static NotificationManager m8722a(InjectorLike injectorLike) {
        return m8723b(injectorLike);
    }
}
