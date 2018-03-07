package com.facebook.common.android;

import android.app.KeyguardManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: number_answers */
public class KeyguardManagerMethodAutoProvider extends AbstractProvider<KeyguardManager> {
    public static KeyguardManager m17177b(InjectorLike injectorLike) {
        return AndroidModule.m2412i((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2412i((Context) getInstance(Context.class));
    }

    public static KeyguardManager m17176a(InjectorLike injectorLike) {
        return m17177b(injectorLike);
    }
}
