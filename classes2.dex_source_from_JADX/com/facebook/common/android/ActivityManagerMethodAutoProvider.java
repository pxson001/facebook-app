package com.facebook.common.android;

import android.app.ActivityManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: video_channel_has_viewer_subscribed */
public class ActivityManagerMethodAutoProvider extends AbstractProvider<ActivityManager> {
    public static ActivityManager m2391b(InjectorLike injectorLike) {
        return AndroidModule.m2405d((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2405d((Context) getInstance(Context.class));
    }

    public static ActivityManager m2390a(InjectorLike injectorLike) {
        return m2391b(injectorLike);
    }
}
