package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;

public enum C1904h {
    ANBANNER(C1907i.class, C1903g.AN, AdPlacementType.BANNER),
    ANINTERSTITIAL(C1909j.class, C1903g.AN, AdPlacementType.INTERSTITIAL),
    ANNATIVE(C1911k.class, C1903g.AN, AdPlacementType.NATIVE);
    
    public Class<?> f14012d;
    public String f14013e;
    public C1903g f14014f;
    public AdPlacementType f14015g;

    private C1904h(Class<?> cls, C1903g c1903g, AdPlacementType adPlacementType) {
        this.f14012d = cls;
        this.f14014f = c1903g;
        this.f14015g = adPlacementType;
    }
}
