package com.facebook.greetingcards.render.templatefetch;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: xcvjdf */
public class UriCacheKey extends MediaCacheKey {
    private final Uri f245a;

    public UriCacheKey(Uri uri) {
        Preconditions.checkNotNull(uri);
        this.f245a = uri;
    }

    public final Uri m293a() {
        return this.f245a;
    }

    public final CacheKey m294b() {
        return new SimpleCacheKey(this.f245a.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equal(this.f245a, ((UriCacheKey) obj).f245a);
    }

    public int hashCode() {
        return this.f245a != null ? this.f245a.hashCode() : 0;
    }
}
