package com.facebook.analytics.samplingpolicy;

import java.util.Map;
import java.util.Set;

/* compiled from: timeline_about_section_add_phone */
public class MapSamplingConfigAccessor extends SamplingConfigAccessor {
    private final Map<String, ?> f1908a;

    public MapSamplingConfigAccessor(Map<String, ?> map) {
        this.f1908a = map;
    }

    protected final Set<String> m2594a(String str, Set<String> set) {
        return this.f1908a.containsKey(str) ? (Set) this.f1908a.get(str) : set;
    }

    protected final int m2592a(String str, int i) {
        return this.f1908a.containsKey(str) ? ((Integer) this.f1908a.get(str)).intValue() : i;
    }

    protected final String m2593a(String str, String str2) {
        return this.f1908a.containsKey(str) ? (String) this.f1908a.get(str) : str2;
    }
}
