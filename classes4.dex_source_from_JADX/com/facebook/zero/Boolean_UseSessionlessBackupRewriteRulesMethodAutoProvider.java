package com.facebook.zero;

import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: voip */
public class Boolean_UseSessionlessBackupRewriteRulesMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbZeroModule.a(GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(this));
    }
}
