package com.facebook.common.android;

import android.content.Context;
import android.hardware.SensorManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: guess_app_start_bg */
public class SensorManagerMethodAutoProvider extends AbstractProvider<SensorManager> {
    public static SensorManager m11374b(InjectorLike injectorLike) {
        return AndroidModule.o((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.o((Context) getInstance(Context.class));
    }
}
