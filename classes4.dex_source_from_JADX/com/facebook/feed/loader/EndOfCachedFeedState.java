package com.facebook.feed.loader;

import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: webrtc_application_receive_gcm */
public class EndOfCachedFeedState {
    public final FbNetworkManager f147a;
    public boolean f148b = false;
    public boolean f149c = false;

    public static EndOfCachedFeedState m187a(InjectorLike injectorLike) {
        return new EndOfCachedFeedState(FbNetworkManager.a(injectorLike));
    }

    @Inject
    public EndOfCachedFeedState(FbNetworkManager fbNetworkManager) {
        this.f147a = fbNetworkManager;
    }

    public final void m188a(boolean z) {
        this.f148b = true;
        if (z) {
            this.f149c = true;
        }
    }
}
