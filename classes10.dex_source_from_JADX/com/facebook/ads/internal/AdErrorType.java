package com.facebook.ads.internal;

import com.facebook.ads.AdError;

public enum AdErrorType {
    UNKNOWN_ERROR(-1, "unknown error", false),
    NETWORK_ERROR(1000, "Network Error", true),
    NO_FILL(1001, "No Fill", true),
    LOAD_TOO_FREQUENTLY(1002, "Ad was re-loaded too frequently", true),
    DISABLED_APP(1005, "App is disabled from making ad requests", true),
    SERVER_ERROR(2000, "Server Error", true),
    INTERNAL_ERROR(2001, "Internal Error", true),
    START_BEFORE_INIT(2004, "initAd must be called before startAd", true),
    AD_REQUEST_FAILED(1111, "Facebook Ads SDK request for ads failed", false),
    AD_REQUEST_TIMEOUT(1112, "Facebook Ads SDK request for ads timed out", false),
    PARSER_FAILURE(1201, "Failed to parse Facebook Ads SDK delivery response", false),
    UNKNOWN_RESPONSE(1202, "Unknown Facebook Ads SDK delivery response type", false),
    ERROR_MESSAGE(1203, "Facebook Ads SDK delivery response Error message", true),
    NO_AD_PLACEMENT(1302, "Facebook Ads SDK returned no ad placements", false);
    
    private final int f13975a;
    private final String f13976b;
    private final boolean f13977c;

    private AdErrorType(int i, String str, boolean z) {
        this.f13975a = i;
        this.f13976b = str;
        this.f13977c = z;
    }

    public static AdErrorType adErrorTypeFromCode(int i) {
        return adErrorTypeFromCode(i, UNKNOWN_ERROR);
    }

    public static AdErrorType adErrorTypeFromCode(int i, AdErrorType adErrorType) {
        for (AdErrorType adErrorType2 : values()) {
            if (adErrorType2.getErrorCode() == i) {
                return adErrorType2;
            }
        }
        return adErrorType;
    }

    final boolean m14205a() {
        return this.f13977c;
    }

    public final AdError getAdError(String str) {
        return new C1920b(this, str).m14328b();
    }

    public final C1920b getAdErrorWrapper(String str) {
        return new C1920b(this, str);
    }

    public final String getDefaultErrorMessage() {
        return this.f13976b;
    }

    public final int getErrorCode() {
        return this.f13975a;
    }
}
