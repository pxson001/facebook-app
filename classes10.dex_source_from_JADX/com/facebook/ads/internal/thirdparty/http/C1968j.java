package com.facebook.ads.internal.thirdparty.http;

public enum C1968j {
    GET(true, false),
    POST(true, true);
    
    private boolean f14291c;
    private boolean f14292d;

    private C1968j(boolean z, boolean z2) {
        this.f14291c = z;
        this.f14292d = z2;
    }

    public final boolean m14431a() {
        return this.f14291c;
    }

    public final boolean m14432b() {
        return this.f14292d;
    }

    public final String m14433c() {
        return toString();
    }
}
