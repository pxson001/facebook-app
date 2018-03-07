package com.facebook.messaging.model.attribution;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Map;

/* compiled from: user_keyboard */
public class ContentAppAttributionBuilder {
    public String f1922a;
    public String f1923b;
    public String f1924c;
    public String f1925d;
    public String f1926e;
    public String f1927f;
    public ImmutableMap<String, String> f1928g = RegularImmutableBiMap.a;
    public AttributionVisibility f1929h = AttributionVisibility.f1903b;

    ContentAppAttributionBuilder() {
    }

    public final ContentAppAttributionBuilder m3268a(ContentAppAttribution contentAppAttribution) {
        this.f1922a = contentAppAttribution.f1914a;
        this.f1923b = contentAppAttribution.f1915b;
        this.f1924c = contentAppAttribution.f1916c;
        this.f1925d = contentAppAttribution.f1917d;
        this.f1926e = contentAppAttribution.f1918e;
        this.f1927f = contentAppAttribution.f1919f;
        ContentAppAttributionBuilder a = m3269a(contentAppAttribution.f1920g);
        a.f1929h = contentAppAttribution.f1921h;
        return a;
    }

    public final ContentAppAttributionBuilder m3270b(String str) {
        this.f1923b = str;
        return this;
    }

    public final ContentAppAttributionBuilder m3271d(String str) {
        this.f1925d = str;
        return this;
    }

    public final ContentAppAttributionBuilder m3272f(String str) {
        this.f1927f = str;
        return this;
    }

    public final ContentAppAttributionBuilder m3269a(Map<String, String> map) {
        this.f1928g = ImmutableMap.copyOf(map);
        return this;
    }

    public final ContentAppAttribution m3273i() {
        return new ContentAppAttribution(this);
    }
}
