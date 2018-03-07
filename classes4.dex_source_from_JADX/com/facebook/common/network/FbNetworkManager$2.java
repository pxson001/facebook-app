package com.facebook.common.network;

import com.facebook.http.onion.TorProxy.ConnectionState;
import com.facebook.http.onion.TorProxy.State;
import com.facebook.http.onion.TorProxy.TorListener;
import javax.annotation.Nullable;

/* compiled from: is_using_contextual */
class FbNetworkManager$2 implements TorListener {
    final /* synthetic */ FbNetworkManager f9779a;

    FbNetworkManager$2(FbNetworkManager fbNetworkManager) {
        this.f9779a = fbNetworkManager;
    }

    public final void m10203a() {
        this.f9779a.a(this.f9779a.b());
        FbNetworkManager.x(this.f9779a);
    }

    public final void m10204a(State state, @Nullable ConnectionState connectionState) {
    }
}
