package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.io.Closeable;

/* compiled from: meme_posted */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, RequestLevel>, EncodedImage> {
    private final DefaultCacheKeyFactory f14463b;

    public final Closeable mo2775a(Closeable closeable) {
        return EncodedImage.m15702a((EncodedImage) closeable);
    }

    public EncodedCacheKeyMultiplexProducer(DefaultCacheKeyFactory defaultCacheKeyFactory, Producer producer) {
        super(producer);
        this.f14463b = defaultCacheKeyFactory;
    }

    protected final Object mo2776a(BaseProducerContext baseProducerContext) {
        return Pair.create(this.f14463b.mo2040a(baseProducerContext.f14480a), baseProducerContext.f14484e);
    }
}
