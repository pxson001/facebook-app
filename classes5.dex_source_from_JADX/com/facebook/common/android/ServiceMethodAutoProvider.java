package com.facebook.common.android;

import android.app.Service;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: stream already closed */
public class ServiceMethodAutoProvider extends AbstractProvider<Service> {
    private static Service m3617b(InjectorLike injectorLike) {
        return AndroidModule.D((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.D((Context) getInstance(Context.class));
    }
}
