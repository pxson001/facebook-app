package com.facebook.zero;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: token_store_enabled */
public class Boolean_UseBackupRewriteRulesGatekeeperMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbZeroModule.b(GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
