package com.facebook.video.server;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: commerce_collection_item_click */
public class TriState_UseVideoServerGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m28261b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(493);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(493);
    }
}
