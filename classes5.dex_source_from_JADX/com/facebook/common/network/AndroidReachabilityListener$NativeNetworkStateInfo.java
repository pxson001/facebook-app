package com.facebook.common.network;

import com.google.common.base.Preconditions;

/* compiled from: show_tag_expansion_options */
class AndroidReachabilityListener$NativeNetworkStateInfo implements NetworkStateInfo {
    final /* synthetic */ AndroidReachabilityListener f2714a;

    public AndroidReachabilityListener$NativeNetworkStateInfo(AndroidReachabilityListener androidReachabilityListener) {
        this.f2714a = androidReachabilityListener;
    }

    public int getNetworkState() {
        Preconditions.checkNotNull(this.f2714a.c, "FBNetworkManager object cannot be null");
        return AndroidReachabilityListener.b(this.f2714a);
    }
}
