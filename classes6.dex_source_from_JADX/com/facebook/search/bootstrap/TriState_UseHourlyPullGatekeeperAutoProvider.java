package com.facebook.search.bootstrap;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: extra_hasfailed_nonnetwork_error */
public class TriState_UseHourlyPullGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m23186b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(848);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(848);
    }
}
