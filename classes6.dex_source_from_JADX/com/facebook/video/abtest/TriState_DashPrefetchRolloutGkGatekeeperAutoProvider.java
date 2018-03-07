package com.facebook.video.abtest;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: scoped */
public class TriState_DashPrefetchRolloutGkGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m7986b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(480);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(480);
    }
}
