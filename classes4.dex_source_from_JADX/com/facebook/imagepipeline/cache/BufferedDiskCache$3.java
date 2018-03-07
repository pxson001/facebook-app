package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;

/* compiled from: seek_match */
class BufferedDiskCache$3 implements Runnable {
    final /* synthetic */ CacheKey f2917a;
    final /* synthetic */ EncodedImage f2918b;
    final /* synthetic */ BufferedDiskCache f2919c;

    BufferedDiskCache$3(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, EncodedImage encodedImage) {
        this.f2919c = bufferedDiskCache;
        this.f2917a = cacheKey;
        this.f2918b = encodedImage;
    }

    public void run() {
        try {
            BufferedDiskCache.c(this.f2919c, this.f2917a, this.f2918b);
        } finally {
            this.f2919c.g.b(this.f2917a, this.f2918b);
            EncodedImage.d(this.f2918b);
        }
    }
}
