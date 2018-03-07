package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.io.Closeable;

/* compiled from: megaphone */
public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, RequestLevel>, CloseableReference<CloseableImage>> {
    private final DefaultCacheKeyFactory f14477b;

    public final Closeable mo2775a(Closeable closeable) {
        return CloseableReference.m15680b((CloseableReference) closeable);
    }

    public BitmapMemoryCacheKeyMultiplexProducer(DefaultCacheKeyFactory defaultCacheKeyFactory, Producer producer) {
        super(producer);
        this.f14477b = defaultCacheKeyFactory;
    }

    protected final Object mo2776a(BaseProducerContext baseProducerContext) {
        return Pair.create(this.f14477b.m15876a(baseProducerContext.f14480a, baseProducerContext.f14483d), baseProducerContext.f14484e);
    }
}
