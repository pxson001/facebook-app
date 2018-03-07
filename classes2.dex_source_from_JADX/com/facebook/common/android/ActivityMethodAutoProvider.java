package com.facebook.common.android;

import android.app.Activity;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: subscription_rerun */
public class ActivityMethodAutoProvider extends AbstractProvider<Activity> {
    public static Activity m6475b(InjectorLike injectorLike) {
        return AndroidModule.m2393B((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2393B((Context) getInstance(Context.class));
    }
}
