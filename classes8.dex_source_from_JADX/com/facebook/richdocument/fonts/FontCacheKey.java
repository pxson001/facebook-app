package com.facebook.richdocument.fonts;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.richdocument.fonts.FontResourceCache.FontResourceKey;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.google.common.base.Objects;

/* compiled from: prefetch_show_failed_wrong_place */
public class FontCacheKey extends MediaCacheKey {
    private final String f5254a;
    private final String f5255b;
    public final String f5256c;

    public FontCacheKey(String str, String str2, String str3) {
        this.f5254a = str;
        this.f5255b = str2;
        this.f5256c = str3;
    }

    public final Uri m5188a() {
        return new Builder().path(m5187e()).build();
    }

    public final CacheKey m5189b() {
        return new SimpleCacheKey(m5187e());
    }

    public final FontResourceKey m5190d() {
        return new FontResourceKey(this.f5254a, this.f5255b);
    }

    private String m5187e() {
        return this.f5254a + "_" + this.f5255b + "_" + this.f5256c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FontCacheKey)) {
            return false;
        }
        FontCacheKey fontCacheKey = (FontCacheKey) obj;
        if (Objects.equal(this.f5254a, fontCacheKey.f5254a) && Objects.equal(this.f5255b, fontCacheKey.f5255b) && Objects.equal(this.f5256c, fontCacheKey.f5256c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f5254a, this.f5255b, this.f5256c});
    }

    public String toString() {
        return m5187e();
    }
}
