package com.facebook.common.android;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: street */
public class Object_WifiP2pManagerSystemServiceMethodAutoProvider extends AbstractProvider<Object> {
    private static Object m3615b(InjectorLike injectorLike) {
        return AndroidModule.v((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.v((Context) getInstance(Context.class));
    }
}
