package com.facebook.directinstall.util;

import com.facebook.directinstall.intent.DirectInstallAppData.DownloadConnectivityPolicy;

/* compiled from: og_action_type */
/* synthetic */ class DirectInstallApplicationUtils$2 {
    static final /* synthetic */ int[] f8817a = new int[DownloadConnectivityPolicy.values().length];

    static {
        try {
            f8817a[DownloadConnectivityPolicy.WifiForce.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8817a[DownloadConnectivityPolicy.WifiOnly.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
