package com.facebook.livephotos.downloader;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;

/* compiled from: permalink_profile_list */
public class LivePhotoCacheKey implements CacheKey {
    private String f6635a;

    public LivePhotoCacheKey(String str) {
        this.f6635a = str;
    }

    public String toString() {
        return this.f6635a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LivePhotoCacheKey)) {
            return false;
        }
        return this.f6635a.equals(((LivePhotoCacheKey) obj).f6635a);
    }

    public int hashCode() {
        return this.f6635a.hashCode();
    }

    public final boolean m8550a(Uri uri) {
        return this.f6635a.equals(uri);
    }
}
