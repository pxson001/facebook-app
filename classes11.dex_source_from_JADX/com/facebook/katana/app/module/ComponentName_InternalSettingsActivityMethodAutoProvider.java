package com.facebook.katana.app.module;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: Upgrade Required */
public class ComponentName_InternalSettingsActivityMethodAutoProvider extends AbstractProvider<ComponentName> {
    public static ComponentName m10795b(InjectorLike injectorLike) {
        return MainProcessModule.b((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return MainProcessModule.b((Context) getInstance(Context.class));
    }
}
