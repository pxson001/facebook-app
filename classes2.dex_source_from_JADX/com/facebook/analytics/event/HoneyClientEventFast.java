package com.facebook.analytics.event;

import com.facebook.analytics.AbstractAnalyticsLogger.C01221;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: num_stories_to_keep_in_feed_adapter_tail_after_prune */
public class HoneyClientEventFast {
    public final HoneyClientEventFastInternal f11879a;
    private final C01221 f11880b;

    public HoneyClientEventFast(String str, boolean z, C01221 c01221) {
        this.f11879a = new HoneyClientEventFastInternal(str, z);
        this.f11880b = c01221;
    }

    public final HoneyClientEventFast m17385a(String str, @Nullable String str2) {
        this.f11879a.m5271b(str, str2);
        return this;
    }

    public final boolean m17388a() {
        return this.f11879a.mo732l();
    }

    public final HoneyClientEventFast m17381a(String str, int i) {
        this.f11879a.m5265a(str, i);
        return this;
    }

    public final HoneyClientEventFast m17382a(String str, long j) {
        this.f11879a.m5266a(str, j);
        return this;
    }

    public final HoneyClientEventFast m17386a(String str, boolean z) {
        this.f11879a.m5269a(str, z);
        return this;
    }

    public final HoneyClientEventFast m17380a(String str, double d) {
        this.f11879a.m5264a(str, d);
        return this;
    }

    public final HoneyClientEventFast m17387a(@Nullable Map<String, ?> map) {
        this.f11879a.m5270a(map);
        return this;
    }

    public final HoneyClientEventFast m17384a(String str, @Nullable Object obj) {
        this.f11879a.m5268a(str, obj);
        return this;
    }

    public final HoneyClientEventFast m17383a(String str, @Nullable JsonNode jsonNode) {
        this.f11879a.m5267a(str, jsonNode);
        return this;
    }

    public final HoneyClientEventFast m17379a(String str) {
        this.f11879a.m5272g(str);
        return this;
    }

    public final HoneyClientEventFast m17389b(@Nullable String str) {
        this.f11879a.m5273h(str);
        return this;
    }

    public final HoneyClientEventFast m17391c(@Nullable String str) {
        this.f11879a.m5274i(str);
        return this;
    }

    public final HoneyClientEventFast m17392d(@Nullable String str) {
        this.f11879a.m5275j(str);
        return this;
    }

    public final void m17390b() {
        this.f11880b.m3687a(this.f11879a);
    }
}
