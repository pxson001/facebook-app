package com.facebook.ui.media.cache;

import com.facebook.ui.media.cache.MediaCache.InMemoryCachedValue;
import java.util.Comparator;

/* compiled from: search_error/ */
class MediaCache$ExpirationComparator implements Comparator<InMemoryCachedValue<KEY, VALUE>> {
    final /* synthetic */ MediaCache f5233a;
    private long f5234b;

    public int compare(Object obj, Object obj2) {
        InMemoryCachedValue inMemoryCachedValue = (InMemoryCachedValue) obj;
        InMemoryCachedValue inMemoryCachedValue2 = (InMemoryCachedValue) obj2;
        long j = inMemoryCachedValue.f / 120000;
        long j2 = inMemoryCachedValue2.f / 120000;
        long j3 = inMemoryCachedValue.f;
        long j4 = inMemoryCachedValue2.f;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        if (j != this.f5234b) {
            return inMemoryCachedValue2.d - inMemoryCachedValue.d;
        }
        if (j3 < j4) {
            return -1;
        }
        if (j3 > j4) {
            return 1;
        }
        return 0;
    }

    public MediaCache$ExpirationComparator(MediaCache mediaCache) {
        this.f5233a = mediaCache;
        this.f5234b = mediaCache.b.a() / 120000;
    }
}
