package com.facebook.ads.internal.dto;

import java.util.ArrayList;
import java.util.List;

public class C1926c {
    public List<C1923a> f14139a = new ArrayList();
    private int f14140b = 0;
    public C1927d f14141c;

    public C1926c(C1927d c1927d) {
        this.f14141c = c1927d;
    }

    public final C1927d m14334a() {
        return this.f14141c;
    }

    public final C1923a m14335c() {
        if (this.f14140b >= this.f14139a.size()) {
            return null;
        }
        this.f14140b++;
        return (C1923a) this.f14139a.get(this.f14140b - 1);
    }
}
