package com.facebook.common.android;

import android.content.Context;
import android.os.Vibrator;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: settings/notifications */
public class VibratorMethodAutoProvider extends AbstractProvider<Vibrator> {
    public static Vibrator m2581b(InjectorLike injectorLike) {
        return AndroidModule.k((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.k((Context) getInstance(Context.class));
    }

    public static Vibrator m2580a(InjectorLike injectorLike) {
        return m2581b(injectorLike);
    }
}
