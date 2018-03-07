package com.facebook.ads.internal.thirdparty.http;

public abstract class C1966l {
    protected String f14284a = "";
    protected C1968j f14285b;
    protected String f14286c;
    protected byte[] f14287d;

    public C1966l(String str, C1972o c1972o) {
        if (str != null) {
            this.f14284a = str;
        }
        if (c1972o != null) {
            this.f14284a += "?" + c1972o.m14439a();
        }
    }

    public final String m14427a() {
        return this.f14284a;
    }

    public final C1968j m14428b() {
        return this.f14285b;
    }

    public final String m14429c() {
        return this.f14286c;
    }

    public final byte[] m14430d() {
        return this.f14287d;
    }
}
