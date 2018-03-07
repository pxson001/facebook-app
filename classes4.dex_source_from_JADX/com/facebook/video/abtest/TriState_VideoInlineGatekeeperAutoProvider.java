package com.facebook.video.abtest;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: presence_lru_cache_recent_threads_size */
public class TriState_VideoInlineGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public static TriState m4832b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1166);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(1166);
    }

    public static TriState m4831a(InjectorLike injectorLike) {
        return m4832b(injectorLike);
    }
}
