package com.facebook.video.abtest;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: score */
public class TriState_DashCbrRolloutGkGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m7985b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(479);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(479);
    }
}
