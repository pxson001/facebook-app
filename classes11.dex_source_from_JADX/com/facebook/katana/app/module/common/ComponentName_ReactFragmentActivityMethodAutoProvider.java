package com.facebook.katana.app.module.common;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: zero_carrier_manager */
public class ComponentName_ReactFragmentActivityMethodAutoProvider extends AbstractProvider<ComponentName> {
    public static ComponentName m68b(InjectorLike injectorLike) {
        return CommonProcessModule.d((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return CommonProcessModule.d((Context) getInstance(Context.class));
    }
}
