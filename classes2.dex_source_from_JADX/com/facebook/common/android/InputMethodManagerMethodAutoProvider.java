package com.facebook.common.android;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: query_vertical */
public class InputMethodManagerMethodAutoProvider extends AbstractProvider<InputMethodManager> {
    public static InputMethodManager m12957b(InjectorLike injectorLike) {
        return AndroidModule.m2417n((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2417n((Context) getInstance(Context.class));
    }

    public static InputMethodManager m12956a(InjectorLike injectorLike) {
        return m12957b(injectorLike);
    }
}
