package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.helper.ChromePeerManager;
import javax.annotation.Nullable;

/* compiled from: num_ads_to_prepare_for_scroll */
public class NetworkPeerManager extends ChromePeerManager {
    private static NetworkPeerManager f11992a;

    @Nullable
    public static synchronized NetworkPeerManager m17684b() {
        NetworkPeerManager networkPeerManager;
        synchronized (NetworkPeerManager.class) {
            networkPeerManager = f11992a;
        }
        return networkPeerManager;
    }
}
