package com.facebook.http.protocol;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* compiled from: dialtone_transition_interstitial_impression */
public class DeviceApiContext {
    public final String f5072a;
    public final ImmutableMap<String, String> f5073b;
    public final ImmutableMap<String, String> f5074c;
    public final ImmutableMap<String, String> f5075d;

    public DeviceApiContext(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        this.f5072a = str;
        this.f5073b = ImmutableMap.copyOf(map);
        this.f5074c = ImmutableMap.copyOf(map2);
        this.f5075d = ImmutableMap.copyOf(map3);
    }
}
