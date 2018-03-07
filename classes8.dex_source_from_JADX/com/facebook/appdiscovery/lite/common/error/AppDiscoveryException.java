package com.facebook.appdiscovery.lite.common.error;

/* compiled from: is_place_to_people */
public class AppDiscoveryException extends Exception {
    private final AppDiscoveryError mError;

    public AppDiscoveryException(String str, AppDiscoveryError appDiscoveryError) {
        super(str);
        this.mError = appDiscoveryError;
    }

    public AppDiscoveryException(Throwable th, AppDiscoveryError appDiscoveryError) {
        super(th);
        this.mError = appDiscoveryError;
    }
}
