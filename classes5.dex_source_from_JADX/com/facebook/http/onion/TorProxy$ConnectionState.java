package com.facebook.http.onion;

/* compiled from: diode_sticker */
public enum TorProxy$ConnectionState {
    CHECKING_CONNECTION(2131233719),
    CHECKED_CONNECTION_TOR(2131233720),
    CHECKED_CONNECTION_ONION(2131233721),
    CONNECTION_CHECK_ERROR(2131233723),
    CONNECTION_CHECK_FAILED(2131233723),
    PROXY_ERROR(2131233723);
    
    public int resId;

    private TorProxy$ConnectionState(int i) {
        this.resId = i;
    }

    public final boolean isComplete() {
        return this != CHECKING_CONNECTION;
    }

    public final boolean isCheckedConnection() {
        return this == CHECKED_CONNECTION_TOR || this == CHECKED_CONNECTION_ONION;
    }

    public final boolean hasEncounteredError() {
        return this == CONNECTION_CHECK_ERROR || this == CONNECTION_CHECK_FAILED || this == PROXY_ERROR;
    }
}
