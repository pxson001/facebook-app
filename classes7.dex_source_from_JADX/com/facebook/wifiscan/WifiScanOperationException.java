package com.facebook.wifiscan;

import com.google.common.base.Preconditions;

/* compiled from: d26138e6c6bf394bac6485b11664e703 */
public class WifiScanOperationException extends Exception {
    public Type type;

    /* compiled from: d26138e6c6bf394bac6485b11664e703 */
    public enum Type {
        NOT_SUPPORTED,
        USER_DISABLED,
        PERMISSION_DENIED,
        TIMEOUT,
        UNKNOWN_ERROR
    }

    public WifiScanOperationException(Type type) {
        super("WiFi scan error: " + type);
        this.type = (Type) Preconditions.checkNotNull(type);
    }
}
