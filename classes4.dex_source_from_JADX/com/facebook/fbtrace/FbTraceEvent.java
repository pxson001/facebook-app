package com.facebook.fbtrace;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: file_mime_type = ' */
public enum FbTraceEvent {
    REQUEST_SEND("#rqsend"),
    REQUEST_RECEIVE("#rqrecv"),
    RESPONSE_SEND("#rpsend"),
    RESPONSE_RECEIVE("#rprecv");
    
    public final String encodedName;

    private FbTraceEvent(String str) {
        this.encodedName = str;
    }
}
