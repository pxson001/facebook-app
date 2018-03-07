package com.facebook.placetips.presence;

import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: savedThreadPhoto */
class PlaceTipsAppStateReceiver$2 implements FutureCallback<PagePresenceManager> {
    final /* synthetic */ PlaceTipsAppStateReceiver f3902a;

    PlaceTipsAppStateReceiver$2(PlaceTipsAppStateReceiver placeTipsAppStateReceiver) {
        this.f3902a = placeTipsAppStateReceiver;
    }

    public void onSuccess(Object obj) {
        ((PagePresenceManager) obj).a(PresenceSourceType.FORCE_OFF);
    }

    public void onFailure(Throwable th) {
        throw new Error(th);
    }
}
