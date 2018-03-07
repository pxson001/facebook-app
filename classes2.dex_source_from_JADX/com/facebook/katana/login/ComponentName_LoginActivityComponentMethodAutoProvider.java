package com.facebook.katana.login;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: should never be called */
public class ComponentName_LoginActivityComponentMethodAutoProvider extends AbstractProvider<ComponentName> {
    public static ComponentName m8838b(InjectorLike injectorLike) {
        return Fb4aLoginModule.m8839a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return Fb4aLoginModule.m8839a((Context) getInstance(Context.class));
    }

    public static ComponentName m8837a(InjectorLike injectorLike) {
        return m8838b(injectorLike);
    }
}
