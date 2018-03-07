package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

/* compiled from: mediatek */
public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        super(memoryCache, cacheKeyFactory, producer);
    }

    protected final Consumer<CloseableReference<CloseableImage>> mo2777a(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey) {
        return consumer;
    }

    protected final String mo2778a() {
        return "BitmapMemoryCacheGetProducer";
    }
}
