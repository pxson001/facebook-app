package com.fasterxml.jackson.core.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: pull_to_refresh_fast */
public final class InternCache extends LinkedHashMap<String, String> {
    public static final InternCache f8652a = new InternCache();

    private InternCache() {
        super(100, 0.8f, true);
    }

    protected final boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 100;
    }

    public final synchronized String m13436a(String str) {
        String str2;
        str2 = (String) get(str);
        if (str2 == null) {
            str2 = str.intern();
            put(str2, str2);
        }
        return str2;
    }
}
