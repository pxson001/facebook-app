package com.facebook.performancelogger;

/* compiled from: tagging */
public enum MarkerType {
    START("start"),
    STOP("stop"),
    MARK("mark"),
    FAILURE("fail"),
    CANCEL("cancel"),
    CLIENT_TTI("client_tti"),
    CLIENT_FAIL("client_fail"),
    CLIENT_CANCEL("client_cancel"),
    VALUE("value"),
    DATA_REQUESTED("data_requested"),
    DATA_RECEIVED("data_received");
    
    private final String mMarkerName;

    private MarkerType(String str) {
        this.mMarkerName = str;
    }

    public final String toString() {
        return this.mMarkerName;
    }
}
