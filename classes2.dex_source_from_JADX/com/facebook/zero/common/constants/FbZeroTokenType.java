package com.facebook.zero.common.constants;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.zero.sdk.constants.ZeroTokenType;

/* compiled from: skipped_results */
public enum FbZeroTokenType {
    NORMAL(ZeroTokenType.NORMAL),
    DIALTONE(ZeroTokenType.DIALTONE);
    
    ZeroTokenType mZeroTokenType;

    private FbZeroTokenType(ZeroTokenType zeroTokenType) {
        this.mZeroTokenType = zeroTokenType;
    }

    public final ZeroTokenType getBaseToken() {
        return this.mZeroTokenType;
    }

    public final byte getModeNumber() {
        return this.mZeroTokenType.getModeNumber();
    }

    public final PrefKey getClearablePreferencesRoot() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getClearablePreferencesRoot());
    }

    public final PrefKey getLastTimeCheckedKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getLastTimeCheckedKey());
    }

    public final PrefKey getStatusKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getStatusKey());
    }

    public final PrefKey getCampaignIdKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getCampaignIdKey());
    }

    public final PrefKey getTokenTTLKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getTokenTTLKey());
    }

    public final PrefKey getRegistrationStatusKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getRegistrationStatusKey());
    }

    public final PrefKey getCarrierNameKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getCarrierNameKey());
    }

    public final PrefKey getCarrierIdKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getCarrierIdKey());
    }

    public final PrefKey getCarrierLogoUrlKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getCarrierLogoUrlKey());
    }

    public final PrefKey getUIFeaturesKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getUIFeaturesKey());
    }

    public final PrefKey getRewriteRulesKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getRewriteRulesKey());
    }

    public final PrefKey getBackupRewriteRulesKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getBackupRewriteRulesKey());
    }

    public final PrefKey getUnregisteredReasonKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getUnregisteredReasonKey());
    }

    public final PrefKey getTokenHashKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getTokenHashKey());
    }

    public final PrefKey getTokenRequestTimeKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getTokenRequestTimeKey());
    }

    public final PrefKey getTokenFastHashKey() {
        return (PrefKey) SharedPrefKeys.f987a.m2011a(this.mZeroTokenType.getTokenFastHashKey());
    }
}
