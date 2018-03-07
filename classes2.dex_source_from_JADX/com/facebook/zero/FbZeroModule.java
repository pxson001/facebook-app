package com.facebook.zero;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.zero.annotations.CampaignApiRetryKillswitchGatekeeper;
import com.facebook.zero.annotations.CampaignApiUseBackupRulesGatekeeper;
import com.facebook.zero.annotations.DisableZeroTokenBootstrapGatekeeper;
import com.facebook.zero.sdk.annotations.UseBackupRewriteRulesGatekeeper;
import com.facebook.zero.sdk.annotations.UseSessionlessBackupRewriteRules;

@InjectorModule
/* compiled from: num_consistent_fields */
public class FbZeroModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UseSessionlessBackupRewriteRules
    public static Boolean m17678a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.m2189a(33, true));
    }

    @ProviderMethod
    @UseBackupRewriteRulesGatekeeper
    public static Boolean m17679b(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.m2189a(1186, true));
    }

    @ProviderMethod
    @CampaignApiUseBackupRulesGatekeeper
    public static Boolean m17680c(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.m2189a(525, false));
    }

    @ProviderMethod
    @CampaignApiRetryKillswitchGatekeeper
    public static Boolean m17681d(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.m2189a(524, false));
    }

    @ProviderMethod
    @DisableZeroTokenBootstrapGatekeeper
    public static Boolean m17682e(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.m2189a(563, false));
    }
}
