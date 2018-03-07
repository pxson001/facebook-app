package com.facebook.graphql.executor;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: liked_menu */
public class Boolean_IsInFlatBufferJsonParserEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6247b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(81, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(81, false));
    }
}
