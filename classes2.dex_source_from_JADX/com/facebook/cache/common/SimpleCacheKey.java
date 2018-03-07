package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;

/* compiled from: measurement_enabled */
public class SimpleCacheKey implements CacheKey {
    final String f14650a;

    public SimpleCacheKey(String str) {
        this.f14650a = (String) Preconditions.a(str);
    }

    public String toString() {
        return this.f14650a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleCacheKey)) {
            return false;
        }
        return this.f14650a.equals(((SimpleCacheKey) obj).f14650a);
    }

    public int hashCode() {
        return this.f14650a.hashCode();
    }

    public final boolean mo2792a(Uri uri) {
        return this.f14650a.contains(uri.toString());
    }
}
