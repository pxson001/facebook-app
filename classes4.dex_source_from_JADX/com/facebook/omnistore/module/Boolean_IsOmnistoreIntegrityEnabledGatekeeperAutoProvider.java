package com.facebook.omnistore.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: lastReadReceiptTimestampMs */
public class Boolean_IsOmnistoreIntegrityEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m9996xa9ee5f35(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(274, false));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(274, false));
    }
}
