package com.facebook.ads.internal.dto;

import com.facebook.ads.internal.C1931e;

public enum C1925b {
    UNKNOWN,
    BANNER,
    INTERSTITIAL,
    NATIVE;

    public static C1925b m14333a(C1931e c1931e) {
        switch (c1931e) {
            case NATIVE_UNKNOWN:
                return NATIVE;
            case WEBVIEW_BANNER_50:
            case WEBVIEW_BANNER_90:
            case WEBVIEW_BANNER_LEGACY:
            case WEBVIEW_BANNER_250:
                return BANNER;
            case WEBVIEW_INTERSTITIAL_HORIZONTAL:
            case WEBVIEW_INTERSTITIAL_VERTICAL:
            case WEBVIEW_INTERSTITIAL_TABLET:
            case WEBVIEW_INTERSTITIAL_UNKNOWN:
                return INTERSTITIAL;
            default:
                return UNKNOWN;
        }
    }
}
