package com.facebook.common.android;

import android.content.Context;
import android.text.ClipboardManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: string_value */
public class ClipboardManagerMethodAutoProvider extends AbstractProvider<ClipboardManager> {
    public static ClipboardManager m3609a(InjectorLike injectorLike) {
        return AndroidModule.p((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.p((Context) getInstance(Context.class));
    }
}
