package com.facebook.fbreact.fb4a;

import com.facebook.inject.AbstractProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: http.tcp.nodelay */
public class Boolean_IsFb4aReactNativePreloadEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Fb4aReactInstanceModule.m11130a((QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
