package com.facebook.messaging.smsbridge.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: draft */
public class Boolean_IsSmsBridgeEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m14451b(InjectorLike injectorLike) {
        return SmsBridgeAbTestModule.m14452a(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return SmsBridgeAbTestModule.m14452a(GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
