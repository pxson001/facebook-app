package com.facebook.katana.app.module.common;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: n must be positive */
public class ComponentName_FragmentChromeActivityMethodAutoProvider extends AbstractProvider<ComponentName> {
    public static ComponentName m19211b(InjectorLike injectorLike) {
        return CommonProcessModule.m9541c((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return CommonProcessModule.m9541c((Context) getInstance(Context.class));
    }
}
