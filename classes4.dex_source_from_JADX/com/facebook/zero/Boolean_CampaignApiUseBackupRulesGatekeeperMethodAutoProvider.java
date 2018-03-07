package com.facebook.zero;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: simplified_download_manager/ */
public class Boolean_CampaignApiUseBackupRulesGatekeeperMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbZeroModule.c(GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
