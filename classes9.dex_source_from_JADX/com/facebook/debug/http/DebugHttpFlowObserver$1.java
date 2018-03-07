package com.facebook.debug.http;

import com.facebook.http.observer.Stage;

/* compiled from: ping_payload */
/* synthetic */ class DebugHttpFlowObserver$1 {
    static final /* synthetic */ int[] f6565a = new int[Stage.values().length];

    static {
        try {
            f6565a[Stage.HTTP_CLIENT_EXECUTE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6565a[Stage.READ_RESPONSE_BODY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
