package com.facebook.common.android;

import android.content.Context;
import android.view.WindowManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: show_nux */
public class WindowManagerMethodAutoProvider extends AbstractProvider<WindowManager> {
    public static WindowManager m8708b(InjectorLike injectorLike) {
        return AndroidModule.m2402b((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2402b((Context) getInstance(Context.class));
    }

    public static WindowManager m8707a(InjectorLike injectorLike) {
        return m8708b(injectorLike);
    }
}
