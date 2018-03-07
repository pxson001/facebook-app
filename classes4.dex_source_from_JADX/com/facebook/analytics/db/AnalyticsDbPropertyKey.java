package com.facebook.analytics.db;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: time_since_last_install_millisecs */
public class AnalyticsDbPropertyKey extends TypedKey<AnalyticsDbPropertyKey> {
    public AnalyticsDbPropertyKey(String str) {
        super(str);
    }

    private AnalyticsDbPropertyKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m1340a(TypedKey typedKey, String str) {
        return new AnalyticsDbPropertyKey(typedKey, str);
    }
}
