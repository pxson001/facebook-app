package com.facebook.common.network;

import com.facebook.common.network.NetworkMonitor.State;

/* compiled from: show_profile_crop_overlay */
/* synthetic */ class NetworkMonitor$3 {
    static final /* synthetic */ int[] f2720a = new int[State.values().length];

    static {
        try {
            f2720a[State.CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2720a[State.NO_INTERNET.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
