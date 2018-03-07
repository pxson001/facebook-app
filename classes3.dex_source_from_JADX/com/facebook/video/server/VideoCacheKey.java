package com.facebook.video.server;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.google.common.base.Preconditions;

/* compiled from: RetrieveMetadata */
public class VideoCacheKey extends MediaCacheKey {
    public final int f392a;
    private final Uri f393b;
    private final CacheKey f394c;

    public VideoCacheKey(Uri uri, int i) {
        Preconditions.checkArgument(i >= 0);
        this.f393b = (Uri) Preconditions.checkNotNull(uri);
        this.f392a = i;
        this.f394c = (CacheKey) Preconditions.checkNotNull(new SimpleCacheKey(FacebookUriUtil.i(uri).toString()));
    }

    public final boolean m349c() {
        return this.f392a > 0;
    }

    public final Uri mo5a() {
        return this.f393b;
    }

    public final CacheKey mo6b() {
        return this.f394c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoCacheKey)) {
            return false;
        }
        return this.f394c.equals(((VideoCacheKey) obj).f394c);
    }

    public final int hashCode() {
        return this.f394c.hashCode();
    }
}
