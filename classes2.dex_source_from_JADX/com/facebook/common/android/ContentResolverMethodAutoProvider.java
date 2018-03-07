package com.facebook.common.android;

import android.content.ContentResolver;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: update_current */
public class ContentResolverMethodAutoProvider extends AbstractProvider<ContentResolver> {
    public static ContentResolver m3641b(InjectorLike injectorLike) {
        return AndroidModule.m2429z((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2429z((Context) getInstance(Context.class));
    }

    public static ContentResolver m3640a(InjectorLike injectorLike) {
        return m3641b(injectorLike);
    }
}
