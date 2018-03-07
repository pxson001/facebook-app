package com.facebook.katana.login;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: extra_is_admin */
public class ComponentName_LogoutActivityComponentMethodAutoProvider extends AbstractProvider<ComponentName> {
    public static ComponentName m13246b(InjectorLike injectorLike) {
        return Fb4aLoginModule.b((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return Fb4aLoginModule.b((Context) getInstance(Context.class));
    }
}
