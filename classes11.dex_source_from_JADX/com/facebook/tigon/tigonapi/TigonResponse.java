package com.facebook.tigon.tigonapi;

import java.util.Collections;
import java.util.Map;

/* compiled from: no_fundraiser_page */
public final class TigonResponse {
    public final int f5057a;
    public final Map<String, String> f5058b;

    public TigonResponse(int i, Map<String, String> map) {
        this.f5057a = i;
        this.f5058b = Collections.unmodifiableMap(map);
    }
}
