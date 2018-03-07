package com.facebook.video.server;

import java.io.IOException;

/* compiled from: commerce_info */
class NetworkRangeWriter$NoResourceLength extends IOException {
    public NetworkRangeWriter$NoResourceLength(Throwable th) {
        super("Cannot get resource length");
        initCause(th);
    }
}
