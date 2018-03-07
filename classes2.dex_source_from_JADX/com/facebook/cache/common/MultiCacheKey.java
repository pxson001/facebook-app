package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;

/* compiled from: measurement.upload.retry_count */
public class MultiCacheKey implements CacheKey {
    final List<CacheKey> f14692a;

    public final List<CacheKey> m21105a() {
        return this.f14692a;
    }

    public String toString() {
        return "MultiCacheKey:" + this.f14692a.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiCacheKey)) {
            return false;
        }
        return this.f14692a.equals(((MultiCacheKey) obj).f14692a);
    }

    public int hashCode() {
        return this.f14692a.hashCode();
    }

    public final boolean mo2792a(Uri uri) {
        for (int i = 0; i < this.f14692a.size(); i++) {
            if (((CacheKey) this.f14692a.get(i)).mo2792a(uri)) {
                return true;
            }
        }
        return false;
    }
}
