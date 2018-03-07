package com.facebook.messaging.audio.playback;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: origin_place_id */
public class AudioCacheKey extends MediaCacheKey {
    public final Uri f8032a;

    public AudioCacheKey(Uri uri) {
        Preconditions.checkNotNull(uri);
        this.f8032a = uri;
    }

    public final Uri m8307c() {
        return this.f8032a;
    }

    public final Uri m8305a() {
        return this.f8032a;
    }

    public final CacheKey m8306b() {
        return new SimpleCacheKey(this.f8032a.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equal(this.f8032a, ((AudioCacheKey) obj).f8032a);
    }

    public int hashCode() {
        return this.f8032a != null ? this.f8032a.hashCode() : 0;
    }
}
