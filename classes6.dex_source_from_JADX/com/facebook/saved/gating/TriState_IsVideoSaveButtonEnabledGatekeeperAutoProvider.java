package com.facebook.saved.gating;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: setAllowTargetSelection */
public class TriState_IsVideoSaveButtonEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public static TriState m7674b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(829);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(829);
    }
}
