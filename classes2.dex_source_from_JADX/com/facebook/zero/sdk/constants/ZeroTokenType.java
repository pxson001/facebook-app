package com.facebook.zero.sdk.constants;

/* compiled from: map_interstitial */
public enum ZeroTokenType {
    DIALTONE((byte) 1, "dialtone/clearable/", "dialtone/clearable/last_time_checked", "dialtone/clearable/current_zero_rating_status", "dialtone/clearable/token", "dialtone/clearable/ttl", "dialtone/clearable/reg_status", "dialtone/clearable/carrier_name", "dialtone/clearable/carrier_id", "dialtone/clearable/carrier_logo_url", "dialtone/clearable/enabled_ui_features", "dialtone/clearable/rewrite_rules", "dialtone/clearable/backup_rewrite_rules", "dialtone/clearable/unregistered_reason", "dialtone/clearable/token_hash", "dialtone/clearable/request_time", "dialtone/clearable/fast_hash"),
    NORMAL((byte) 0, "zero_rating2/clearable/", "zero_rating2/clearable/last_time_checked", "zero_rating2/clearable/current_zero_rating_status", "zero_rating2/clearable/token", "zero_rating2/clearable/ttl", "zero_rating2/clearable/reg_status", "zero_rating2/clearable/carrier_name", "zero_rating2/clearable/carrier_id", "zero_rating2/clearable/carrier_logo_url", "zero_rating2/clearable/enabled_ui_features", "zero_rating2/clearable/rewrite_rules", "zero_rating2/clearable/backup_rewrite_rules", "zero_rating2/clearable/unregistered_reason", "zero_rating2/clearable/token_hash", "zero_rating2/clearable/request_time", "zero_rating2/clearable/fast_hash");
    
    String mBackupRewriteRulesKey;
    String mCampaignIdKey;
    String mCarrierIdKey;
    String mCarrierLogoUrlKey;
    String mCarrierNameKey;
    String mClearablePreferencesRoot;
    String mLastTimeCheckedKey;
    byte mModeNumber;
    String mRegistrationStatusKey;
    String mRewriteRulesKey;
    String mStatusKey;
    String mTokenFastHashKey;
    String mTokenHashKey;
    String mTokenRequestTimeKey;
    String mTokenTTLKey;
    String mUIFeaturesKey;
    String mUnregisteredReasonKey;

    public final byte getModeNumber() {
        return this.mModeNumber;
    }

    public final String getClearablePreferencesRoot() {
        return this.mClearablePreferencesRoot;
    }

    public final String getLastTimeCheckedKey() {
        return this.mLastTimeCheckedKey;
    }

    public final String getStatusKey() {
        return this.mStatusKey;
    }

    public final String getCampaignIdKey() {
        return this.mCampaignIdKey;
    }

    public final String getTokenTTLKey() {
        return this.mTokenTTLKey;
    }

    public final String getRegistrationStatusKey() {
        return this.mRegistrationStatusKey;
    }

    public final String getCarrierNameKey() {
        return this.mCarrierNameKey;
    }

    public final String getCarrierIdKey() {
        return this.mCarrierIdKey;
    }

    public final String getCarrierLogoUrlKey() {
        return this.mCarrierLogoUrlKey;
    }

    public final String getUIFeaturesKey() {
        return this.mUIFeaturesKey;
    }

    public final String getRewriteRulesKey() {
        return this.mRewriteRulesKey;
    }

    public final String getBackupRewriteRulesKey() {
        return this.mBackupRewriteRulesKey;
    }

    public final String getUnregisteredReasonKey() {
        return this.mUnregisteredReasonKey;
    }

    public final String getTokenHashKey() {
        return this.mTokenHashKey;
    }

    public final String getTokenRequestTimeKey() {
        return this.mTokenRequestTimeKey;
    }

    public final String getTokenFastHashKey() {
        return this.mTokenFastHashKey;
    }

    private ZeroTokenType(byte b, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.mModeNumber = b;
        this.mClearablePreferencesRoot = str;
        this.mLastTimeCheckedKey = str2;
        this.mStatusKey = str3;
        this.mCampaignIdKey = str4;
        this.mTokenTTLKey = str5;
        this.mRegistrationStatusKey = str6;
        this.mCarrierNameKey = str7;
        this.mCarrierIdKey = str8;
        this.mCarrierLogoUrlKey = str9;
        this.mUIFeaturesKey = str10;
        this.mRewriteRulesKey = str11;
        this.mBackupRewriteRulesKey = str12;
        this.mUnregisteredReasonKey = str13;
        this.mTokenHashKey = str14;
        this.mTokenRequestTimeKey = str15;
        this.mTokenFastHashKey = str16;
    }
}
