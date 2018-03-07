package com.facebook.login;

/* compiled from: view == null */
public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, false),
    NATIVE_ONLY(true, false, false),
    WEB_ONLY(false, true, false),
    DEVICE_AUTH(false, false, true);
    
    private final boolean allowsDeviceAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    private LoginBehavior(boolean z, boolean z2, boolean z3) {
        this.allowsKatanaAuth = z;
        this.allowsWebViewAuth = z2;
        this.allowsDeviceAuth = z3;
    }

    public final boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    public final boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }

    public final boolean allowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }
}
