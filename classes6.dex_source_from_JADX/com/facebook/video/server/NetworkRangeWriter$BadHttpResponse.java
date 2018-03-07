package com.facebook.video.server;

import java.io.IOException;

/* compiled from: commerce_info */
class NetworkRangeWriter$BadHttpResponse extends IOException {
    public NetworkRangeWriter$BadHttpResponse(int i, String str) {
        super("Bad HTTP Response: " + i + " - " + str);
    }
}
