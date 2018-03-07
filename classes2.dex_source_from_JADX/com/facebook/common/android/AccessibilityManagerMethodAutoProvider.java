package com.facebook.common.android;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: should_update_title_bar */
public class AccessibilityManagerMethodAutoProvider extends AbstractProvider<AccessibilityManager> {
    public static AccessibilityManager m8780b(InjectorLike injectorLike) {
        return AndroidModule.m2423t((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2423t((Context) getInstance(Context.class));
    }
}
