package com.facebook.languages.switcher;

import com.google.common.collect.ImmutableMap;

/* compiled from: tracking_state */
public class LanguageSwitcherList {
    private final ImmutableMap<String, String> f759a;
    public final int f760b;

    public LanguageSwitcherList(ImmutableMap<String, String> immutableMap, int i) {
        this.f759a = immutableMap;
        this.f760b = i;
    }

    public final String[] m1111a() {
        return (String[]) this.f759a.keySet().toArray(new String[0]);
    }

    public final String[] m1112b() {
        return (String[]) this.f759a.values().toArray(new String[0]);
    }
}
