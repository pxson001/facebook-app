package com.facebook.auth.module;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: request_code */
public class TriState_IsMeUserTrustedTesterGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public static TriState m11946b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2185a(466);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.m2131a(this).m2185a(466);
    }

    public static TriState m11945a(InjectorLike injectorLike) {
        return m11946b(injectorLike);
    }
}
