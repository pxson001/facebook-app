package com.facebook.common.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: sid */
public class ApplicationInfoMethodAutoProvider extends AbstractProvider<ApplicationInfo> {
    public static ApplicationInfo m8676b(InjectorLike injectorLike) {
        return AndroidModule.m2397F((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2397F((Context) getInstance(Context.class));
    }
}
