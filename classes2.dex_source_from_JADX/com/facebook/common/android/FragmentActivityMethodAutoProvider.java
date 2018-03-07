package com.facebook.common.android;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: pages_native_edit_page_gk */
public class FragmentActivityMethodAutoProvider extends AbstractProvider<FragmentActivity> {
    public static FragmentActivity m15506b(InjectorLike injectorLike) {
        return AndroidModule.m2394C((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2394C((Context) getInstance(Context.class));
    }

    public static FragmentActivity m15505a(InjectorLike injectorLike) {
        return m15506b(injectorLike);
    }
}
