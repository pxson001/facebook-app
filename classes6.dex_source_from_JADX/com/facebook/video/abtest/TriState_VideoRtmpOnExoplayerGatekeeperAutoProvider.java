package com.facebook.video.abtest;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: schoolType */
public class TriState_VideoRtmpOnExoplayerGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m7989b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(853);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(853);
    }
}
