package com.facebook.attribution;

import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: marketplace_saved */
public class AttributionState {
    public final String f14987a;
    public final long f14988b;
    public final long f14989c;
    public final boolean f14990d;
    public final String f14991e;
    public final JsonNode f14992f;

    public AttributionState(String str, long j, long j2, boolean z, String str2, JsonNode jsonNode) {
        this.f14987a = str;
        this.f14988b = j;
        this.f14989c = j2;
        this.f14990d = z;
        this.f14991e = str2;
        this.f14992f = jsonNode;
    }
}
