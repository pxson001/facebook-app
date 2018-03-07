package com.facebook.common.android;

import android.app.AlarmManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: strip_nulls */
public class AlarmManagerMethodAutoProvider extends AbstractProvider<AlarmManager> {
    public static AlarmManager m6581b(InjectorLike injectorLike) {
        return AndroidModule.m2410g((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2410g((Context) getInstance(Context.class));
    }
}
