package com.facebook.ads.internal.server;

import com.facebook.ads.internal.dto.C1926c;

public class C1956c {
    public C1926c f14265a;
    private C1955a f14266b;

    public enum C1955a {
        UNKNOWN,
        ERROR,
        ADS
    }

    public C1956c(C1955a c1955a, C1926c c1926c) {
        this.f14266b = c1955a;
        this.f14265a = c1926c;
    }

    public final C1955a m14393a() {
        return this.f14266b;
    }

    public final C1926c m14394b() {
        return this.f14265a;
    }
}
