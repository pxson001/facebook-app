package com.facebook.common.android;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: placefeed?placeid=%s&surface=%s&placename=%s&wildcard=%s */
public class LayoutInflaterMethodAutoProvider extends AbstractProvider<LayoutInflater> {
    public static LayoutInflater m14787b(InjectorLike injectorLike) {
        return AndroidModule.m2403c((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2403c((Context) getInstance(Context.class));
    }

    public static LayoutInflater m14786a(InjectorLike injectorLike) {
        return m14787b(injectorLike);
    }
}
