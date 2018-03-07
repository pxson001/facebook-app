package com.facebook.common.hardware;

/* compiled from: splash_uri */
public enum Carrier {
    ATT(310, 410),
    UNKNOWN(0, 0);
    
    private final int mCountryCode;
    private final int mNetworkCode;

    private Carrier(int i, int i2) {
        this.mCountryCode = i;
        this.mNetworkCode = i2;
    }

    public final int getCountryCode() {
        return this.mCountryCode;
    }

    public final int getNetworkCode() {
        return this.mNetworkCode;
    }

    public static Carrier fromMncMcc(int i, int i2) {
        for (Carrier carrier : values()) {
            if (carrier.getCountryCode() == i && carrier.getNetworkCode() == i2) {
                return carrier;
            }
        }
        return UNKNOWN;
    }
}
