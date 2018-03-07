package com.facebook.intent.thirdparty;

import android.text.TextUtils;

/* compiled from: mCommunicationRank */
enum NativeThirdPartyUriHelper$TapBehavior {
    LEGACY("", true, false, true, false),
    INTERSTITIAL_ALWAYS("interstitial_always", true, true, true, true),
    INTERSTITIAL_CONTENT_ONLY("interstitial_content_only", true, true, false, false),
    WEB_ALWAYS("web_always", false, false, false, false),
    APP_FALLBACK_WEB("app_fallback_web", true, false, false, false),
    INTERSTITIAL_INSTALL_ONLY("interstitial_install_only", true, false, true, true),
    APP_FALLBACK_INSTALL("app_fallback_install", true, false, true, false);
    
    private boolean allowOpenInNativeAppIfInstalled;
    private boolean goToMarketIfAppNotInstalled;
    private boolean showInterstitialForInstall;
    private boolean showInterstitialForOpen;
    private String string;

    private NativeThirdPartyUriHelper$TapBehavior(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.string = str;
        this.allowOpenInNativeAppIfInstalled = z;
        this.showInterstitialForOpen = z2;
        this.goToMarketIfAppNotInstalled = z3;
        this.showInterstitialForInstall = z4;
    }

    static NativeThirdPartyUriHelper$TapBehavior fromString(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (NativeThirdPartyUriHelper$TapBehavior nativeThirdPartyUriHelper$TapBehavior : values()) {
                if (nativeThirdPartyUriHelper$TapBehavior.string.equals(str)) {
                    return nativeThirdPartyUriHelper$TapBehavior;
                }
            }
        }
        return LEGACY;
    }

    public final boolean shouldShowInterstitialForOpen() {
        return this.showInterstitialForOpen;
    }

    public final boolean shouldAllowOpenInNativeAppIfInstalled() {
        return this.allowOpenInNativeAppIfInstalled;
    }

    public final boolean shouldShowInterstitialForInstall() {
        return this.showInterstitialForInstall;
    }

    public final boolean shouldGoToMarketIfAppNotInstalled() {
        return this.goToMarketIfAppNotInstalled;
    }
}
