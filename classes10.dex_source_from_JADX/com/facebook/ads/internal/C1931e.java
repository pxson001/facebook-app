package com.facebook.ads.internal;

public enum C1931e {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(101),
    WEBVIEW_INTERSTITIAL_VERTICAL(102),
    WEBVIEW_INTERSTITIAL_TABLET(103),
    NATIVE_UNKNOWN(200),
    NATIVE_250(201);
    
    private final int f14191l;

    private C1931e(int i) {
        this.f14191l = i;
    }

    public final int m14346a() {
        return this.f14191l;
    }
}
