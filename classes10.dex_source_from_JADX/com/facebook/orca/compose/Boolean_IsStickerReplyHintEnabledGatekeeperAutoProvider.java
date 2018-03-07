package com.facebook.orca.compose;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: original_emoji */
public class Boolean_IsStickerReplyHintEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m4745b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(975, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(975, false));
    }
}
